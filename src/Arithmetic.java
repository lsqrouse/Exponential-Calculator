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

    public static double divide(double n1, double n2) throws DivideByZeroException{
        if(n2 == 0)
            throw new DivideByZeroException("Divide by Zero");
        return n1 / n2;
    }

    public static double solve(String s) throws DivideByZeroException{
        String toParse = noSpace(s);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < toParse.length(); i++) {
            char c = toParse.charAt(i);
            double n2 = Double.parseDouble(Character.toString(toParse.charAt(i + 1)));
            if(Character.isDigit(c) && i == 0)
                stack.push(Character.toString(c));
            if(c == '(')
                stack.push(Character.toString(toParse.charAt(1 + i)));
            else if (c == '+') {
                try {
                    double n1 = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(add(n1, n2)));
                } catch (NumberFormatException e) {
                    double n1 = Double.parseDouble(stack.pop());
                    n2 = solve(toParse.substring(i));
                    stack.push(Double.toString(add(n1, n2)));
                }
            } else if (c == '-') {
                try {
                    double n1 = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(subtract(n1, n2)));
                } catch (NumberFormatException e) {
                    double n1 = Double.parseDouble(stack.pop());
                    n2 = solve(toParse.substring(i));
                    stack.push(Double.toString(subtract(n1, n2)));
                }
            } else if (c == '/') {
                try {
                    double n1 = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(subtract(n1, n2)));
                } catch (NumberFormatException e) {
                    double n1 = Double.parseDouble(stack.pop());
                    n2 = solve(toParse.substring(i));
                    stack.push(Double.toString(divide(n1, n2)));
                }
            } else if (c == '*') {
                try {
                    double n1 = Double.parseDouble(stack.pop());
                    stack.push(Double.toString(subtract(n1, n2)));
                } catch (NumberFormatException e) {
                    double n1 = Double.parseDouble(stack.pop());
                    n2 = solve(toParse.substring(i));
                    stack.push(Double.toString(multiply(n1, n2)));
                }
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
