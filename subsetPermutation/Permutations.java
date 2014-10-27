/**
 * Given a collection of numbers, return all possible permutations.
 * You can assume that the nums are all different.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Solution {

    private void permuteHelper(List<List<Integer>> result, List<Integer> list, int[] num) {
        if (list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (list.contains(num[i])) {
                continue;
            }
            list.add(num[i]);
            permuteHelper(result, list, num);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }
        permuteHelper(result, new ArrayList<Integer>(), num);
        return result;
    }
}
