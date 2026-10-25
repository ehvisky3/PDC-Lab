import java.util.ArrayList;

public class TransactionStack {

    private ArrayList<String> stack = new ArrayList<>();

    public void push(String packet) {
        stack.add(packet);
    }

    public String pop() {
        if (stack.isEmpty()) {
            return null;
        }

        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public String peek() {
        if (stack.isEmpty()) {
            return null;
        }

        return stack.get(stack.size() - 1);
    }

}