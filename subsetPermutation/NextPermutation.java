/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as
 * the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and
 * its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null) {
            return;
        }

        int len = num.length;
        for (int i = len - 2; i >= 0; i--) {
            //The following algorithm generates the next permutation
            //lexicographically after a given permutation. It changes the given
            //permutation in-place.
            //Find the largest index k such that a[k] < a[k + 1]. If no such
            //index exists, the permutation is the last permutation.
            //Find the largest index l greater than k such that a[k] < a[l].
            //Swap the value of a[k] with that of a[l].
            //Reverse the sequence from a[k + 1] up to and including the final
            //element a[n].

            // 2, 1, 4, 3
            // 2, 3, 1, 4
            // num[i] < num[i + 1] && num[j] > num[i],
            // swap num i and j. reverse i + 1 string
            if (num[i + 1] > num[i]) {
                int j;
                for (j = len - 1; j > i; j--) {
                    if (num[j] > num[i]) {
                        break;
                    }
                }

                swap(num, i, j);
                reverse(num, i + 1, len-1);
                return;
            }
        }

        reverse(num, 0, len-1);
    }

    void swap(int[] num, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    void reverse(int[] num, int beg, int end) {
        for (int i = beg, j = end; i < j; i++, j--) {
            swap(num, i, j);
        }
    }
}
