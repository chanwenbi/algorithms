/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Solution {

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        if(n <= 0) {
            return ret;
        }
        generateParenthesisHelper(ret, "", n, n);
        return ret;
    }

    private void generateParenthesisHelper(ArrayList<String> ret, String s,
            int left, int right) {
        if (left > right || left < 0 || right < 0) {
            return;
        }

        if (left == 0 && right == 0) {
            ret.add(s);
            return;
        }

        generateParenthesisHelper(ret, s + "(", left - 1, right);
        generateParenthesisHelper(ret, s + ")", left, right - 1);
    }

}
