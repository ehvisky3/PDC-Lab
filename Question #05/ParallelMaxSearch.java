public class ParallelMaxSearch extends SensorSearchEngine
{
	public ParallelMaxSearch(double[] a,int st,int en)
	{
		super(a,st,en);
	}
	@Override
	public void processgrid()
	{
		r=d[s];
		for(int i=s+1;i<e;i++)
		{
			if(d[i]>r)
			{
				r=d[i];
			}
		}
	}
}