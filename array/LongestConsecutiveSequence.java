/**
 * Given an unsorted array of integers, find the length of the
 * longest consecutive elements sequence.
 *
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 */
public class Solution {
    public int longestConsecutive(int[] num) {
        // using hashmap to reduce the time complexity of checking num exists
        Map<Integer, Boolean> numVisited = new HashMap<Integer, Boolean>();

        for (int i : num) {
            numVisited.put(i, false);
        }

        int max = 1;
        for (int i : num) {
            if (numVisited.get(i)) {
                continue;
            }

            numVisited.put(i, true);

            int count = 1;
            // find up sequence
            int n = i + 1;
            while (numVisited.containsKey(n)) {
                numVisited.put(n, true);
                count++;
                n++;
            }

            // find low sequence
            n = i - 1;
            while (numVisited.containsKey(n)) {
                numVisited.put(n, true);
                count++;
                n--;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
