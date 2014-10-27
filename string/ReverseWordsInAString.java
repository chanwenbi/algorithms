/**
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class Solution {

    // Confirm:
    // 1. will the string leading or trailing with whitespaces? how to deal with it?
    // 2. how about multiple spaces? return only 1 space.
    // 3. can I use string.split()?

    // Version 1: split the string
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() != 0) {
                sb.append(arr[i]).append(" ");
            }
        }

        String ret = sb.toString();

        return ret.length() == 0 ? "" : ret.substring(0, ret.length() - 1);
    }

    // Version 2: reverse the whole string, then reverse each word
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        char[] charArray = s.toCharArray();
        reverse(charArray, 0, charArray.length - 1);

        int i = 0;
        while (i < charArray.length) {
            if (charArray[i] == ' ') {
                // Point 2: don't forget to i++
                i++;
                continue;
            }
            int start = i;
            int end = i;
            // Point 3: always  check the bound of array index
            while (end < charArray.length && charArray[end] != ' ') {
                end++;
            }
            reverse(charArray, start, end - 1);
            sb.append(charArray, start, end - start).append(' ');

            i = end;
        }

        String result = sb.toString();
        // Point 4: checking argument validation
        return result.length() > 0 ? result.substring(0, result.length() - 1) : result;
    }

    public void reverse(char[] s, int start, int end) {
        // Point 1: use < not, !=, as start may large than end
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
