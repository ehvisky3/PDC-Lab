public class AsyncWebEngineApp
{
	public static void main(String[] a)
	{
		System.out.println("main thread name: "+Thread.currentThread().getName());
		TelemetryThread t=new TelemetryThread();
		t.setName("telemetry-worker");
		LogProcessorTask p=new LogProcessorTask();
		Thread w=new Thread(p);
		w.setName("log-worker");
		t.start();
		w.start();
		System.out.println(t.getName()+" state: "+t.getState());
		System.out.println(w.getName()+" state: "+w.getState());
	}
}