public class Arithmetic {
    private static Stack stack = new Stack();
    public static double add(double n1, double n2) {
        return n1 + n2;
    }

    public static double subtract(double n1, double n2) {
        return n1 - n2;
    }

    public static double multiply(double n1, double n2) {
        return n1 * n2;
    }

    public static double divide(double n1, double n2) {
        return n1 / n2;
    }

    public static double solve(String todo) {
        String noSpace = noSpace(todo);
        for (int i = 0; i < todo.length(); i++) {
            char c = todo.charAt(i);
            if(c == '(' || c == '+' || c == '-' || c == '/') {
                stack.push(Character.toString(todo.charAt(i++)));
            }
        }

        return 0;
    }

    public static String noSpace(String s) {
        StringBuilder out = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(c != ' ')
                out.append(Character.toString(c));
        }
        return out.toString();
    }
}
