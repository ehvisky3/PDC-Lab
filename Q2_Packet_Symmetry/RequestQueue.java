import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {

    private Queue<String> queue = new LinkedList<>();

    public void enqueue(String request) {
        queue.add(request);
    }

}