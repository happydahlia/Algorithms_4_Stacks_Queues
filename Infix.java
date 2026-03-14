import java.util.Stack;
public class Infix {
    public static int precedence(char p) {
        if (p == '^'){
            return 3;
        }
        if (p == '*' || p == '/'){
            return 2;
        }
        if (p == '+' || p == '-') {
            return 1;
        }
        return 0;
    }
    public static String infixToPostfix(String s) {
        Stack<Character> varStack = new Stack<>();
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                output += c;
            }

            else if (c == '(') {
                varStack.push(c);
            }

            else if (c == ')') {
                while (!varStack.isEmpty() && varStack.peek() != '(') {
                    output += varStack.pop();
                }
                varStack.pop();
            }

            else {
                while (!varStack.isEmpty() && precedence(varStack.peek()) >= precedence(c)) {
                    output += varStack.pop();
                }
                varStack.push(c);
            }
        }
        while (!varStack.isEmpty()) {
            output += varStack.pop();
        }

        return output;
    }
    
}
