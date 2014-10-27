/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class Solution {
    // O(2^n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (candidates == null || candidates.length == 0 || target <= 0) {
            return result;
        }

        Arrays.sort(candidates);

        dfs(result, new ArrayList<Integer>(), 0, candidates, target);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int pos, int[] candidates, int target) {
        if (0 == target) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            if (i != pos && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            dfs(result, path, i + 1, candidates, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
