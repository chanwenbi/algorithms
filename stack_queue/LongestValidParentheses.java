/**
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has
 * length = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring
 * is "()()", which has length = 4.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        // max len has been reached
        int maxLen = 0;

        // used to memo the previous valid parentheses length when the stack
        // is empty.
        int accumulatedLen = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            if (stack.isEmpty()) {
                accumulatedLen = 0;
                continue;
            }

            int matchedPos = stack.pop();
            int matchedLen = 0;

            if (stack.isEmpty()) {
                accumulatedLen += i - matchedPos + 1;
                matchedLen = accumulatedLen;
            } else {
                matchedLen = i - stack.peek();
            }

            maxLen = Math.max(maxLen, matchedLen);
        }

        return maxLen;
    }
}
