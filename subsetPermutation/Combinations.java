/**
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) {
            // invalid input
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combineDfs(result, new ArrayList<Integer>(), 1, n, k);

        return result;
    }

    private void combineDfs(List<List<Integer>> result, List<Integer> path, int pos, int n, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = pos; i <= n; i++) {
            path.add(i);
            combineDfs(result, path, i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }
}
