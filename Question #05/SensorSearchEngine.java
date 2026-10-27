public abstract class SensorSearchEngine implements Runnable
{
	protected double[] d;
	protected int s;
	protected int e;
	protected double r;
	public SensorSearchEngine(double[] a,int st,int en)
	{
		d=a;
		s=st;
		e=en;
	}
	public abstract void processgrid();
	@Override
	public void run()
	{
		processgrid();
	}
	public double getresult()
	{
		return r;
	}
}