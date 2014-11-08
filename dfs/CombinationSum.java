/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations
 * in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return result;
        }

        Arrays.sort(candidates);
        combinationSumHelper(result, new ArrayList<Integer>(), 0, candidates, target);
        return result;
    }

    private void combinationSumHelper(List<List<Integer>> result, List<Integer> path,
            int pos, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }

            if (i != pos && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            combinationSumHelper(result, path, i, candidates, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
