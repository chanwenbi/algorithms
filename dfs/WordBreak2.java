/**
 * Given a string s and a dictionary of words dict, add spaces in s to
 * construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class Solution {

    // Version 1: dfs, exceed time limit
    private void wordBreakHelper(List<String> result, String sentence,
            String s, int start, Set<String> dict) {

        if (start == s.length()) {
            result.add(sentence);
            return;
        }

        for (int i = start + 1; i < s.length(); i++) {
            String word = s.substring(start, i);
            if (dict.contains(word)) {
                wordBreakHelper(result, sentence.length() == 0 ?
                        word : sentence + " " + word, s, i, dict);
            }
        }
    }

    // Version 2: dfs with memo
    private Map<Integer, List<String>> memo = new HashMap<Integer, List<String>>();

    private List<String> wordBreakHelper(int pos, String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();

        if (pos == s.length()) {
            return result;
        }

        // could be optimized by cal the maximum word length
        for (int i = pos + 1; i <= s.length(); i++) {
            String word = s.substring(pos, i);
            if (!dict.contains(word)) {
                continue;
            }

            if (i == s.length()) {
                result.add(word);
                break;
            }

            for (String subSentence : getOrUpdate(i, s, dict)) {
                result.add(word + " " + subSentence);
            }
        }

        return result;
    }

    private List<String> getOrUpdate(int pos, String s, Set<String> dict) {
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        List<String> result = wordBreakHelper(pos, s, dict);
        memo.put(pos, result);
        return result;
    }

    public List<String> wordBreak(String s, Set<String> dict) {
        return wordBreakHelper(0, s, dict);
    }
}
