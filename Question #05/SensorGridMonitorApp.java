public class SensorGridMonitorApp
{
	public static void main(String[] a) throws InterruptedException
	{
		double[] d=new double[50000];
		for(int i=0;i<d.length;i++)
		{
			d[i]=67;
		}
		d[1200]=-15.67;
		d[38000]=467.67;
		long st=System.nanoTime();
		ParallelMinSearch m1=new ParallelMinSearch(d,0,25000);
		ParallelMinSearch m2=new ParallelMinSearch(d,25000,50000);
		ParallelMaxSearch x1=new ParallelMaxSearch(d,0,25000);
		ParallelMaxSearch x2=new ParallelMaxSearch(d,25000,50000);
		Thread t1=new Thread(m1);
		Thread t2=new Thread(m2);
		Thread t3=new Thread(x1);
		Thread t4=new Thread(x2);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		double gmin=Math.min(m1.getresult(),m2.getresult());
		double gmax=Math.max(x1.getresult(),x2.getresult());
		long tt=System.nanoTime()-st;
		System.out.println("global minimum temperature: "+gmin);
		System.out.println("global maximum vibration: "+gmax);
		System.out.println("execution time (ns): "+tt);
	}
}