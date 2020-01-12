import java.util.ArrayList;

public class Stack {
    private ArrayList<String> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(String s) {
        stack.add(0,s);
    }

    public String pop() {
        String s = stack.get(0);
        stack.remove(0);
        return s;
    }


}
