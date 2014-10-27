/**
 * Follow up for N-Queens problem.
 *
 * Now, instead outputting board configurations,
 * return the total number of distinct solutions.
 */
public class Solution {
    int count = 0;

    private boolean isAttackable(List<Integer> queues, int newQueue) {
        int size = queues.size();
        int row = size;
        int col = newQueue;
        for (int i = 0; i < size; i++) {
            int rowI = i;
            int colI = queues.get(i);

            if (Math.abs(row - rowI) == Math.abs(col - colI)) {
                return true;
            }
        }

        return false;
    }

    private void permutation(List<Integer> queues, int n) {
        if (queues.size() == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (queues.contains(i) || isAttackable(queues, i)) {
                continue;
            }

            queues.add(i);
            permutation(queues, n);
            queues.remove(queues.size() - 1);
        }

    }

    public int totalNQueens(int n) {
        permutation(new ArrayList<Integer>(), n);
        return count;
    }
}
