/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 *
 * For example, [0,2,3,1] is also a valid gray code sequence according to the
 * above definition.
 *
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
 */
public class Solution {
    private int negativeBit(int num, int pos) {
        int bitValue = num >> pos & 1;
        return bitValue == 1 ? num - (1 << pos) : num + (1 << pos);
    }

    // O(2^n)
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if (n == 0) {
            return res;
        }

        int num = 0;
        res.add(0);
        int i = 0;
        while(i < n) {
            int newNum = negativeBit(num, i);
            if (res.contains(newNum)) {
                i++;
                continue;
            }
            res.add(newNum);
            num = newNum;
            i = 0;
        }
        return res;
    }

    // version 2:
    // n-bit Gray Codes can be generated from list of (n-1)-bit Gray codes using following steps.
    // 1) Let the list of (n-1)-bit Gray codes be L1. Create another list L2 which is reverse of L1.
    // 2) Modify the list L1 by prefixing a ’0′ in all codes of L1.
    // 3) Modify the list L2 by prefixing a ’1′ in all codes of L2.
    // 4) Concatenate L1 and L2. The concatenated list is required list of n-bit Gray codes.)
    // O(2^n)
    public List<Integer> grayCode(int n) {
        if (n < 0) {
            // invalid input
            return null;
        }

        if (n == 0) {
            return Arrays.asList(0);
        }

        List<Integer> result = new ArrayList<Integer>();
        List<Integer> preCode = grayCode(n - 1);
        result.addAll(preCode);

        for (int i = preCode.size() - 1; i >= 0; i--) {
            result.add(preCode.get(i) | 1 << (n - 1));
        }

        return result;
    }

    // check is two gray code are successive
    // idea:
    // compare from the most significant bit
    // 0, 0 -> isSuccessive(a, b, i + 1)
    // 1, 1 -> isSuccessive(b, a, i + 1)
    // 1, 0 -> return false
    // 0, 1 -> check the following chars, should be 10*
}
