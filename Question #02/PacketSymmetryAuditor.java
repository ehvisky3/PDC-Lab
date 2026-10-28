public class PacketSymmetryAuditor
{
    public static void main(String[] args)
    {
        String p = "tacocat";
        int l = p.length();

        TransactionStack s = new TransactionStack(l);
        RequestQueue q = new RequestQueue(l);
    }
}