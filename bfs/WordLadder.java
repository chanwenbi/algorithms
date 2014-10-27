/**
 * Given two words (start and end), and a dictionary, find the length
 * of shortest transformation sequence from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 *
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class Solution {

    private String replaceChar(String word, int pos, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return String.valueOf(chars);
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.isEmpty()) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (word.charAt(i) == c) {
                            continue;
                        }
                        String replacedWord = replaceChar(word, i, c);
                        if (replacedWord.equals(end)) {
                            return steps + 1;
                        }
                        if (dict.contains(replacedWord)) {
                            queue.offer(replacedWord);
                            dict.remove(replacedWord);
                        }
                    }
                }
            }
            steps++;
        }

        return 0;
    }
}
