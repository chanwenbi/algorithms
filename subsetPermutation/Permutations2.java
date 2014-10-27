/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 *
 */
public class Solution {

    private void permuteHelper(List<List<Integer>> result, List<Integer> list, int[] num, boolean[] included) {
        if (list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (included[i] || (i != 0 && num[i] == num[i - 1] && !included[i - 1])) {
                continue;
            }
            list.add(num[i]);
            included[i] = true;
            permuteHelper(result, list, num, included);
            list.remove(list.size() - 1);
            included[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }
        boolean[] included = new boolean[num.length];
        Arrays.sort(num);
        permuteHelper(result, new ArrayList<Integer>(), num, included);
        return result;
    }
}
