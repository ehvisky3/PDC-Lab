import java.util.ArrayList;

public class TransactionStack {

    private ArrayList<String> stack = new ArrayList<>();

    public void push(String packet) {
        stack.add(packet);
    }

}