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

    // O(words*wordLen*26), O(words)
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.isEmpty()) {
            return 0;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);

        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                if (isReachable(word, end)) {
                    return steps + 1;
                }
                enqueueAdjacent(word, queue, dict);
            }
            steps++;
        }

        return 0;
    }

    boolean isReachable(String word, String end) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (word.charAt(i) == c) {
                    continue;
                }

                String newWord = replaceChar(word, i, c);
                if (newWord.equals(end)) {
                    return true;
                }
            }
        }

        return false;
    }

    void enqueueAdjacent(String word, Queue<String> queue, Set<String> dict) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (word.charAt(i) == c) {
                    continue;
                }

                String newWord = replaceChar(word, i, c);
                if (dict.contains(newWord)) {
                    queue.offer(newWord);
                    dict.remove(newWord);
                }
            }
        }
    }

    String replaceChar(String word, int pos, char c) {
        char[] chars = word.toCharArray();
        chars[pos] = c;
        return String.valueOf(chars);
    }

    // TODO: Bidirectional BFS

}
