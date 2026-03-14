import java.util.LinkedList;

public class Balanced_Symbols {
    public String isBalanced(String s){
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{' || c == '<' || c == '¿') {
                stack.add(0,c);
            }

            else {
                if (stack.peek() == null) {
                    return "NO";
                }
                char first = stack.peek();
                if ((c == ')' && first == '(') ||
                        (c == ']' && first == '[') ||
                        (c == '}' && first == '{') ||
                        (c == '>' && first == '<') ||
                        (c == '?' && first == '¿')) {

                    stack.remove();
                }
                else {
                    return "NO";
                }
            }
        }

        if (stack.peek() == null) {
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args) {
        Balanced_Symbols sequence = new Balanced_Symbols();
        String Test = "[[[]<>][(]]";
        System.out.print(sequence.isBalanced(Test));
    }
}
