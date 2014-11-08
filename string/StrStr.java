/**
 * Implement strStr().
 *
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 */
public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }

        int hLen = haystack.length();
        int nLen = needle.length();
        for (int i = 0; i < hLen - nLen + 1; i++) {
            int j = 0;
            for (j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nLen) {
                return haystack.substring(i);
            }
        }
        return null;
    }

    // version 2: kmp
    public int[] buildNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;

        for (int i = 1; i < next.length; i++) {
            int pos = next[i - 1];
            while (pos >= 0 && pattern.charAt(i) != pattern.charAt(pos + 1)) {
                pos = next[pos];
            }
            if (pattern.charAt(i) == pattern.charAt(pos + 1)) {
                next[i] = pos + 1;
            } else {
                next[i] = -1;
            }
        }

        return next;
    }

    public String strStr(String text, String pattern) {
        if (text == null || pattern == null) {
            // invalid input
            return null;
        }
        int n1 = text.length();
        int n2 = pattern.length();

        if (n2 == 0) {
            return text;
        }

        int[] next = buildNext(pattern);

        int i = 0;
        int j = 0;
        while (i < n1) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j - 1] + 1;
                }
            }
            if (j == n2) {
                return text.substring(i - n2);
            }
        }

        return null;
    }
}
