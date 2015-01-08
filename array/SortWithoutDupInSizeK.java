/**
 * http://www.careercup.com/question?id=6026101998485504
 * Given an unordered array of positive integers, create an algorithm that
 * makes sure no group of integers of size bigger than M have the same integers.
 *
 * Input: 2,1,1,1,3,4,4,4,5 M = 2
 * Output: 2,1,1,3,1,4,4,5,4
 */
public class Solution {

    public boolean group(int[] A, int k){
        int max = 0;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

        for(int i = 0; i < A.length; i++) {
            if(!count.containsKey(A[i])){
                count.put(A[i], 0);
            }
            int size = count.get(A[i]) + 1;
            count.put(A[i], size);
            max = Math.max(max, size);
        }

        if (max > Math.ceil(A.length / k)) {
            return false;
        }

        int posInGroup = 0;
        int pos = posInGroup;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            while(count-- > 0) {
                A[pos] = value;
                pos += k;
                if (pos >= A.length) {
                    posInGroup++;
                    pos = posInGroup;
                }
            }
        }

        return true;
    }
}
