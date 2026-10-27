public class RequestQueue
{
	private char[] a;
	private int f;
	private int r;
	private int s;
	public RequestQueue(int c)
	{
		a=new char[c];
		f=0;
		r=-1;
		s=0;
	}
	public void enqueue(char c)
	{
		r++;
		a[r]=c;
		s++;
	}
	public char dequeue()
	{
		char c=a[f];
		f++;
		s--;
		return c;
	}
	public boolean isempty()
	{
		return s==0;
	}
}