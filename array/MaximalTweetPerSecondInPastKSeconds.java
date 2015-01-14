/**
 * Given an array and an integer k, find the maximum for each and every
 * contiguous subarray of size k.
 *
 * Examples:
 *
 * Input :
 * arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * k = 3
 * Output :
 * 3 3 4 5 5 5 6
 *
 * Input :
 * arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
 * k = 4
 * Output :
 * 10 10 10 15 15 90 90
 *
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 */
public class Solution {

    public List<Integer> kMax(int[] A, int k) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<Integer> deque = new LinkedList<Integer>();

        // put first k - 1 elements
        int i = 0;
        for (; i < k - 1; i++) {
            while (!deque.isEmpty() && A[i] >= A[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        for (; i < A.length; i++) {
            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && A[i] >= A[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
            result.add(A[deque.peekFirst()]);
        }

        return result;
    }
}
