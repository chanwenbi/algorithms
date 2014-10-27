/**
 * Given a rotated sorted array, recover it to sorted array in-place.
 *
 * Example
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 */
public class Solution {

    private int findRevertPos(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                return i;
            }
        }

        return -1;
    }

    private void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);

            start++;
            end--;
        }
    }

    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {

        if (nums == null || nums.size() <= 1) {
            return;
        }

        int pos = findRevertPos(nums);

        if (pos == -1) {
            return;
        }

        reverse(nums, 0, pos);
        reverse(nums, pos + 1, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }
}
