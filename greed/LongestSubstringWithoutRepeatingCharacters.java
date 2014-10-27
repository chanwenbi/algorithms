/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 * For example, the longest substring without repeating letters for "abcabcbb"
 * is "abc", which the length is 3. For "bbbbb" the longest substring is "b",
 * with the length of 1.
 */
public class Solution {
    // O(n), O(n)
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> pos = new HashMap<Character, Integer>();

        int max = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pos.containsKey(c)) {
                int prePos = pos.get(c);
                if (prePos >= start) {
                    max = Math.max(max, i - start);
                    start = prePos + 1;
                }
            }
            pos.put(c, i);
        }
        max = Math.max(max, s.length() - start);
        return max;
    }
}
