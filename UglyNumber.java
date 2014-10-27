/**
 * Ugly number is the number can only be divided by 2/3/5,
 * return the kth ugly number.
 */
public class Solution {

    // version 1: brute force,
    // recursive all number from 1, check whether it's ugly number
    // O(n)
    public int getUglyNumber(int k) {

    }

    // version 2: using min heap
    // every time remove the minimal element, insert A * 2, A * 3, A * 5
    // O(klgk), O(k)

    // version 3: using 3 pointer to memo the next *2, *3, *5 item which is
    // larger than the current one
    // O(k), O(k)
}
