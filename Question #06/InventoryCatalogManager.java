import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class InventoryCatalogManager
{
	public static void benchmarksync() throws InterruptedException
	{
		Map<String,Integer> c=Collections.synchronizedMap(new HashMap<>());
		runbench("synchronizedmap",c);
	}
	public static void benchmarkconc() throws InterruptedException
	{
		Map<String,Integer> c=new ConcurrentHashMap<>();
		runbench("concurrenthashmap",c);
	}
	private static void runbench(String t,Map<String,Integer> c) throws InterruptedException
	{
		for(int i=0;i<100;i++)
			c.put("prod_"+i,1000);
		Thread[] w=new Thread[10];
		long st=System.nanoTime();
		for(int i=0;i<10;i++)
		{
			w[i]=new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					for(int j=0;j<50000;j++)
					{
						String k="prod_"+(j%100);
						c.get(k);
						c.put(k,j);
					}
				}
			});
			w[i].start();
		}
		for(int i=0;i<10;i++)
			w[i].join();
		long tt=System.nanoTime()-st;
		double s=tt/1000000000.0;
		long to=10L*50000L*2L;
		long tp=(long)(to/s);
		System.out.println(t+" | execution time: "+(tt/1000000)+" ms | throughput: "+tp+" ops/sec");
	}
	public static void main(String[] a) throws InterruptedException
	{
		benchmarksync();
		benchmarkconc();
	}
}