/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class Solution {

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null || dict.size() == 0) {
            return false;
        }

        int length = s.length();
        // whether or not substring start from ith pos can break to words
        boolean[] canBreak = new boolean[length + 1];
        canBreak[length] = true;

        int maxLen = maxWordLength(dict);

        for (int i = length - 1; i >= 0; i--) {
            // enhancement: pruning according to the max words length
            int end = Math.min(i + maxLen, length);
            for (int j = i + 1; j <= end; j++) {
                canBreak[i] =  canBreak[j] && dict.contains(s.substring(i, j));
                if (canBreak[i]) {
                    break;
                }
            }
        }

        return canBreak[0];
    }

    public int maxWordLength(Set<String> dict) {
        int maxLen = 0;
        for (String word : dict) {
            maxLen = Math.max(maxLen, word.length());
        }
        return maxLen;
    }
}
