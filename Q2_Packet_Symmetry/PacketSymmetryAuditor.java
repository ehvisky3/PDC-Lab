
public class PacketSymmetryAuditor {

    public static void main(String[] args) {

        TransactionStack stack = new TransactionStack();
        RequestQueue queue = new RequestQueue();

        stack.push("Packet-A");
        stack.push("Packet-B");
        stack.push("Packet-C");

        queue.enqueue("Packet-A");
        queue.enqueue("Packet-B");
        queue.enqueue("Packet-C");

        System.out.println("Stack uses LIFO:");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("\nQueue uses FIFO:");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

    }

}
