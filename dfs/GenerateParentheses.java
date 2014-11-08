/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Solution {

    // time complexity: catalan number, C(2*n, n)/(n + 1)
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }

        generate(result, new StringBuilder(), n, n);
        return result;
    }

    private void generate(List<String> result, StringBuilder sb, int left, int right) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }

        generate(result, sb.append("("), left - 1, right);
        sb.deleteCharAt(sb.length() - 1);
        generate(result, sb.append(")"), left, right - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
