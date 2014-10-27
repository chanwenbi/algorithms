/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 *
 * idea:
 * count each bit num
 */
public class Solution {

    public int singleNumber(int[] A) {
        int result = 0;
        int[] bits = new int[32];

        for (int i = 0; i < 32; i++) {
            for (int num : A) {
                bits[i] += (num >> (31 - i)) & 1;
            }
            result |= (bits[i] % 3) << (31 - i);
        }

        return result;
    }

    // Version 2:
    // using one to memo bits of 1 '1'
    // two to memo bits of 2 '1'
    // when one and two 's same bit are '1', means the '1' at that bit occurs 3 times, need to clear
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            // invalid input
            return -1;
        }

        int n1 = 0, n2 = 0;
        for (int i = 0; i < A.length; ++i) {
            n2 = n2 | (n1 & A[i]);
            n1 = n1 ^ A[i];
            int n3 = n1 & n2;
            n1 = n1 & ~n3;
            n2 = n2 & ~n3;
        }
        return n1;
    }

    public int singleNumber(int[] A) {
        int n1 = 0, n2 = 0;
        for (int i = 0; i < A.length; ++i) {
            n1 = (n1 & ~A[i]) | (~n1 & ~n2 & A[i]);
            n2 = (n2 & ~A[i]) | (~n1 & ~n2 & A[i]);
        }
        return n1;
    }
}
