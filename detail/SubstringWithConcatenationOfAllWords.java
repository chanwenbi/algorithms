/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 *
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class Solution {

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if (S.length() == 0 || L.length == 0) {
            return result;
        }

        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        for (String s : L) {
            if (wordCount.containsKey(s)) {
                wordCount.put(s, wordCount.get(s) + 1);
            } else {
                wordCount.put(s, 1);
            }
        }

        int wordLen = L[0].length();
        for (int i = 0; i <= S.length() - wordLen * L.length; i++) {
            String word = S.substring(i, i + wordLen);
            if (wordCount.containsKey(word)) {
                checkWord(S, wordLen, L.length, i, wordCount, result);
            }
        }
        return result;
    }

    public void checkWord(String S, int wordLen, int totalWords, int start,
            Map<String, Integer> wordCount, List<Integer> result) {
        int i = start;
        int findNum = 0;
        Map<String, Integer> foundWords = new HashMap<String, Integer>();
        while (i < S.length() - wordLen + 1) {
            String word = S.substring(i, i + wordLen);
            if (wordCount.containsKey(word) && (!foundWords.containsKey(word)
                        || foundWords.get(word) < wordCount.get(word))) {
                findNum++;
                if (foundWords.containsKey(word)) {
                    foundWords.put(word, foundWords.get(word) + 1);
                } else {
                    foundWords.put(word, 1);
                }

                if (findNum == totalWords) {
                    result.add(start);
                }
            } else {
                break;
            }
            i += wordLen;
        }
    }
}
