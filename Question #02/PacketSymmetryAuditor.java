public class PacketSymmetryAuditor
{
    public static void main(String[] args)
    {
        String p = "tacocat";
        int l = p.length();

        TransactionStack s = new TransactionStack(l);
        RequestQueue q = new RequestQueue(l);

        for(int i = 0; i < l; i++)
        {
            char c = p.charAt(i);
            s.push(c);
            q.enqueue(c);
        }

        boolean sym = true;

        while(!s.isempty() && !q.isempty())
        {
            char fs = s.pop();
            char fq = q.dequeue();

            System.out.println("stack pop: " + fs + " | queue dequeue: " + fq);
        }
    }
}