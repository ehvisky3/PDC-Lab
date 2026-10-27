import java.util.concurrent.RecursiveTask;
public class ParallelRiskCalculator extends RecursiveTask<Double>
{
	private static final int THRESHOLD=1000;
	private double[] a;
	private int s;
	private int e;
	public ParallelRiskCalculator(double[] ar,int st,int en)
	{
		a=ar;
		s=st;
		e=en;
	}
	@Override
	protected Double compute()
	{
		if((e-s)<=THRESHOLD)
		{
			double sum=0;
			for(int i=s;i<e;i++)
			{
				sum+=a[i];
			}
			return sum;
		}
		else
		{
			int m=(s+e)/2;
			ParallelRiskCalculator lt=new ParallelRiskCalculator(a,s,m);
			ParallelRiskCalculator rt=new ParallelRiskCalculator(a,m,e);
			lt.fork();
			rt.fork();
			return lt.join()+rt.join();
		}
	}
}