import java.util.concurrent.RecursiveAction;
public class PortfolioThresholdTask extends RecursiveAction
{
	private static final int THRESHOLD=1000;
	private double[] a;
	private int s;
	private int e;
	private double r;
	public PortfolioThresholdTask(double[] ar,int st,int en,double rc)
	{
		a=ar;
		s=st;
		e=en;
		r=rc;
	}
	@Override
	protected void compute()
	{
		if((e-s)<=THRESHOLD)
		{
			for(int i=s;i<e;i++)
			{
				if(a[i]>r)
				{
					a[i]=a[i]*0.95;
				}
			}
		}
		else
		{
			int m=(s+e)/2;
			PortfolioThresholdTask lt=new PortfolioThresholdTask(a,s,m,r);
			PortfolioThresholdTask rt=new PortfolioThresholdTask(a,m,e,r);
			lt.fork();
			rt.fork();
			lt.join();
			rt.join();
		}
	}
}