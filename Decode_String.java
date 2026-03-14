import java.util.Stack;

public class Decode_String {
    public String decode(String s){
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String finalStr = "";
        int k = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            }

            else if (c == '[') {
                numStack.push(k);
                strStack.push(finalStr);
                finalStr = "";
                k = 0;
            }

            else if (c == ']') {
                int repeat = numStack.pop();
                String prev = strStack.pop();
                String temp = "";
                for (int j = 0; j < repeat; j++) {
                    temp += finalStr;
                }

                finalStr = prev + temp;
            }

            else {
                finalStr += c;
            }
        }

        return finalStr;
    }
   
}
