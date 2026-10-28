public class TransactionStack
{
    private char[] a;
    private int t;

    public TransactionStack(int c)
    {
        a = new char[c];
        t = -1;
    }

    public void push(char c)
    {
        t++;
        a[t] = c;
    }

    public char pop()
    {
        char c = a[t];
        t--;
        return c;
    }

    public char peek()
    {
        return a[t];
    }
}