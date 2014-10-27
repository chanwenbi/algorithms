/**
 * Given a string containing just the characters '(', ')', '{', '}',
 * '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}"
 * are all valid but "(]" and "([)]" are not.
 */
public class Solution {
    // O(n) O(n)
    // testcase:
    // null, "", "(", "({}]", "({[]})", "{}()[]"
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }

        String leftParentheses = "({[";
        String rightParentheses = ")}]";

        Stack<Character> stack = new Stack<Character>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (leftParentheses.indexOf(c) != -1) {
                stack.push(c);
            } else if (rightParentheses.indexOf(c) != -1) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (rightParentheses.indexOf(c) != leftParentheses.indexOf(stack.pop())) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
