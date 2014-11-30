
public class Solution {
    public int countKsInRange(int num, int k) {
        int count = 0;
        int len = String.valueOf(num).length();
        for (int i = 0; i < len; i++) {
            count += countKsAtDigit(num, i, k);
        }
        return count;
    }

    private int countKsAtDigit(int num, int i, int k) {
        int powerOf10 = (int) Math.pow(10, i);
        int nextPowerOf10 = powerOf10 * 10;
        int right = num % powerOf10;

        int roundDown = num - num % nextPowerOf10;
        int roundUp = roundDown + nextPowerOf10;

        int digit = (num / powerOf10) % 10;
        if (digit < k) {
            return roundDown / 10;
        } else if (digit == k) {
            return roundDown / 10 + right + 1;
        } else {
            return roundUp / 10;
        }
    }
}
