package DataStructures.Stack.Problems;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String parenthesis = "(({})){[]}";
        boolean ans = isValidParenthesis(parenthesis);
        System.out.println(ans);
    }

    private static boolean isValidParenthesis(String parenthesis) {
        Stack<Character> stack = new Stack<>();

        for (char ch : parenthesis.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char popped = stack.pop();
                if (ch == ')' && popped != '(') {
                    return false;
                } else if (ch == '}' && popped != '{') {
                    return false;
                } else if (ch == ']' && popped != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
