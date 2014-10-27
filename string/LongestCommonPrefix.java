/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution {

    // Solution 1, start from the first one, compare prefix with next string, until end;
    // Solution 2, start from the first char, compare it with all string, and then the second char
    // I'm using the second one

    // version 1: non-recursive
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String base = strs[0];

        for (int i = 0; i < base.length(); i++) {
            char c = base.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }

    // version 2: recursive
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        longestCommonPrefixHelper(sb, strs, 0);
        return sb.toString();
    }

    private void longestCommonPrefixHelper(StringBuilder sb, String[] strs, int start) {
        if (strs == null || strs.length == 0) {
            return;
        }

        if (start > strs[0].length() - 1) {
            return;
        }

        char c = strs[0].charAt(start);
        for (int i = 1; i < strs.length; i++) {
            if (start > strs[i].length()-1 || strs[i].charAt(start) != c) {
                return;
            }
        }

        sb.append(c);
        longestCommonPrefixHelper(sb, strs, start+1);
    }
}
