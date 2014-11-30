public class Solution {

    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }

        int sum = a ^ b;
        int carrying = (a & b) << 1;
        return add(sum, carrying);
    }
}
