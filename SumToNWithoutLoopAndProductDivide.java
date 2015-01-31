/**
 * calculate 1 + 2 + 3 + ... + n
 * without product, divide, for, while if, else, switch, case and (? :)
 */
public class Solution {
    int sum = 0;

    public boolean cal(int n) {
        sum += n;
        return n == 1 || cal(n - 1);
    }
}
