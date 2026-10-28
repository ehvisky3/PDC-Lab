public class TransactionStack
{
    private char[] a;
    private int t;

    public TransactionStack(int c)
    {
        a = new char[c];
        t = -1;
    }
}