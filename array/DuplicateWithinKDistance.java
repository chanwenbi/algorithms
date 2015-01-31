/**
 * Write a function that determines whether a array contains duplicate
 * characters within k indices of each other
 */
public class Solution {

    public boolean duplicateInKDistance(int[] A, int k){
        Set<Integer> numInKDistances = new HashSet<Integer>();

        for (int i = 0; i < A.length; i++) {
            if (numInKDistances.contains(A[i])) {
                return true;
            }

            // act like a circular buffer
            if (i >= k) {
                numInKDistances.remove(A[i - k]);
            }

            numInKDistances.add(A[i]);
        }

        return false;
    }
}
