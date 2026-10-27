import java.util.concurrent.ForkJoinPool;
public class ForkJoinPortfolioApp
{
	public static void main(String[] a)
	{
		double[] ar=new double[10000];
		for(int i=0;i<ar.length;i++)
		{
			ar[i]=200.0;
		}
		ForkJoinPool p=new ForkJoinPool();
		long st=System.nanoTime();
		ParallelRiskCalculator ic=new ParallelRiskCalculator(ar,0,ar.length);
		double is=p.invoke(ic);
		PortfolioThresholdTask pt=new PortfolioThresholdTask(ar,0,ar.length,150.0);
		p.invoke(pt);
		ParallelRiskCalculator fc=new ParallelRiskCalculator(ar,0,ar.length);
		double fs=p.invoke(fc);
		long et=System.nanoTime();
		long tt=et-st;
		System.out.println("initial risk score: "+is);
		System.out.println("adjusted risk score (after 5% penalty): "+fs);
		System.out.println("total processing time (ns): "+tt);
	}
}