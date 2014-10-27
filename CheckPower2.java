/**
 * O(1) check power of 2.
 */
public class Solution {

    public boolean check(int num) {
        return num & (num - 1) == 0;
    }

}
