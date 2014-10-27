/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 *
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Solution {

    // O(2^n), O(2^n)
    public List<List<Integer>> subsetsWithDup(int[] S) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0) {
            return results;
        }
        Arrays.sort(S);
        add(results, new ArrayList<Integer>(), 0, S);
        return results;
    }

    public void add(List<List<Integer>> results, List<Integer> path, int pos, int[] S) {
        results.add(new ArrayList<Integer>(path));

        for (int i = pos; i < S.length; i++) {
            if (i != pos && S[i] == S[i - 1]) {
                continue;
            }
            path.add(S[i]);
            add(results, path, i + 1, S);
            path.remove(path.size() - 1);
        }
    }

}
