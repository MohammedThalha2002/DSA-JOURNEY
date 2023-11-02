package DataStructures.Stack.Problems;

import java.util.Stack;

public class AddParenthesis {
    public static void main(String[] args) {
        String parenthesis = "(())(";
        int ans = addParenthesis(parenthesis);
        System.out.println(ans);
    }

    private static int addParenthesis(String parenthesis) {
        Stack<Character> stack = new Stack<>();

        for (char ch : parenthesis.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else if(stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.size();
    }
}
