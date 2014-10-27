/**
 * Given two words (start and end), and a dictionary, find all
 * shortest transformation sequence(s) from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 *
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 *    ["hit","hot","dot","dog","cog"],
 *    ["hit","hot","lot","log","cog"]
 * ]
 */
public class Solution {

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();

        if (start == null || end == null || dict == null) {
            return result;
        }

        Map<String, List<String>> predecessor = getPredecessor(start, end, dict);

        if (predecessor == null) {
            return result;
        }

        List<String> path = new ArrayList<String>();
        path.add(end);
        getPath(result, path, start, end, predecessor);

        return result;
    }

    // O(words*wordLen*26), O(words)
    private Map<String, List<String>> getPredecessor(String start, String end, Set<String> dict) {
        int len = start.length();

        Map<String, List<String>> predecessor = new HashMap<String, List<String>>();
        Map<String, Integer> steps = new HashMap<String, Integer>();
        Queue<String> words = new LinkedList<String>();
        words.offer(start);
        steps.put(start, 1);

        boolean found = false;

        while (!words.isEmpty()) {
            int size = words.size();
            while (size-- > 0) {
                String word = words.poll();
                for (int i = 0; i < len; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (word.charAt(i) == c) {
                            continue;
                        }

                        String newWord = replaceChar(word, i, c);

                        if (!dict.contains(newWord)) {
                            continue;
                        }

                        if (predecessor.containsKey(newWord)) {
                            if (steps.get(newWord) == steps.get(word) + 1) {
                                predecessor.get(newWord).add(word);
                            }
                        } else {
                            words.offer(newWord);
                            steps.put(newWord, steps.get(word) + 1);
                            List<String> p = new ArrayList<String>();
                            p.add(word);
                            predecessor.put(newWord, p);
                        }

                        if (newWord.equals(end)) {
                            found = true;
                        }
                    }
                }
            }

            if (found) {
                break;
            }
        }

        if (found) {
            return predecessor;
        } else {
            return null;
        }
    }

    private String replaceChar(String word, int pos, char c) {
        char[] chars = word.toCharArray();
        chars[pos] = c;
        return String.valueOf(chars);
    }

    // O(shortPathLen * solutionNum)
    private void getPath(List<List<String>> result, List<String> path,
            String start, String end, Map<String, List<String>> predecessor) {

        if (end.equals(start)) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (String s : predecessor.get(end)) {
            path.add(0, s);
            getPath(result, path, start, s, predecessor);
            path.remove(0);
        }
    }
}
