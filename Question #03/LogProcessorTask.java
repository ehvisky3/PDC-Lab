public class LogProcessorTask implements Runnable
{
	@Override
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(Thread.currentThread().getName()+" | log metric iteration: "+i);
			try
			{
				Thread.sleep(1067);
			}
			catch(InterruptedException e)
			{
				System.out.println("log thread interrupted.");
			}
		}
	}
}