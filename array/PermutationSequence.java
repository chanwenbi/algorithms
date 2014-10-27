/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class Solution {

    private int getNumOnPosWithoutOccupied(boolean[] flags, int pos) {
        int index = 0;
        for (int i = 0; i < flags.length; i++) {
            if (flags[i]) {
                continue;
            }
            if (pos == 0 || ++index == pos) {
                flags[i] = true;
                return i + 1;
            }
        }

        return -1;
    }

    public String getPermutation(int n, int k) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        String ret = "";
        boolean[] flags = new boolean[n];
        while (n > 0) {
            factorial = factorial / n;
            int pos = (int) Math.ceil((double)k / factorial);
            k = k % factorial;
            if (k == 0) {
                k = factorial;
            }
            int num = getNumOnPosWithoutOccupied(flags, pos);
            ret += num;
            n--;
        }

        return ret;
    }
}
