/**
 * Given a list of numbers, and a number k, the majority number is
 * the number that occurs more than 1/k of the size of the List.
 *
 * idea:
 * treat each number as a piece in tetris of k width, put each number
 * in the specific column, when the row is full, eliminate it.
 */
public class Solution {

    // O(n*k), O(k)
    public int majorityNumber(List<Integer> nums, int k) {
        if (nums == null || nums.size() = 0) {
            return -1;
        }

        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for (int i : nums) {
            if (counts.containsKey(i)) {
                counts.put(i, counts.get(i) + 1);
            } else {
                counts.put(i, 1);
            }

            if (counts.size() == k) {
                for (int i : counts.keySet()) {
                    counts.put(i, counts.get(i) - 1);
                    if (counts.get(i) == 0) {
                        counts.remove(i);
                    }
                }
            }
        }

        for (int i : counts.keySet()) {
            counts.put(i, 0);
        }

        for (int i : nums) {
            if (counts.containsKey(i)) {
                counts.put(i, counts.get(i) + 1);

                if (counts.get(i) > (nums.size() / k)) {
                    return i;
                }
            }
        }

        return -1;
    }

}
