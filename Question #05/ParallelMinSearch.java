public class ParallelMinSearch extends SensorSearchEngine
{
	public ParallelMinSearch(double[] a,int st,int en)
	{
		super(a,st,en);
	}
	@Override
	public void processgrid()
	{
		r=d[s];
		for(int i=s+1;i<e;i++)
		{
			if(d[i]<r)
			{
				r=d[i];
			}
		}
	}
}