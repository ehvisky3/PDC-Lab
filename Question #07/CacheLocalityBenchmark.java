public class CacheLocalityBenchmark
{
	private static final int n=2000;
	private static double[][] m=new double[n][n];
	public static double traverserow()
	{
		double s=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				s+=m[i][j];
		return s;
	}
	public static double traversecol()
	{
		double s=0;
		for(int j=0;j<n;j++)
			for(int i=0;i<n;i++)
				s+=m[i][j];
		return s;
	}
	public static void main(String[] a)
	{
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				m[i][j]=1.0;
		long rs=System.nanoTime();
		for(int k=0;k<10;k++)
			traverserow();
		long rtns=System.nanoTime()-rs;
		long cs=System.nanoTime();
		for(int k=0;k<10;k++)
			traversecol();
		long ctns=System.nanoTime()-cs;
		double rtms=rtns/1000000.0;
		double ctms=ctns/1000000.0;
		double sp=ctms/rtms;
		System.out.println("row-major time (10 iterations): "+rtms+" ms");
		System.out.println("column-major time (10 iterations): "+ctms+" ms");
		System.out.println("speedup ratio: "+sp+"x faster");
	}
}