/**
 * Partition problem is the task of deciding whether a given set of positive
 * integers can be partitioned into two subsets S1 and S2 such that the sum
 * of the numbers in S1 equals the sum of the numbers in S2.
 *
 * The partition problem is NP-complete, but we could use dynamic programming
 * to solve it in pseudo-polynomial time O(sum *n).
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 *
 * The optimization version which partition the set S to two subsets S1, S2 with
 * closest sum is NP-hard problem.
 *
 * Approximation algorithm:
 * greed: sort in descending order, assigning each of them to the subset with smaller sum.
 * O(nlgn) time complexity, has 4/3 approximation to the optimal solution
 *
 * Heuristic algorithm:
 * add all numbers to priority queue, each step removes two numbers from the set
 * and replace them with difference. This represents the decision to put the two numbers
 * in different sets, without immediately deciding which one is in which set.
 * The result is better than greedy one.
 *
 */
public class Solution {

    // greedy approximation algorithm
    public void divide(int[] A, List<Integer> l1, List<Integer> l2){
        if (A == null || l1 == null || l2 == null) {
            // invalid input
        }

        int sum1 = 0;
        int sum2 = 0;

        Arrays.sort(A);
        for(int i = A.length - 1; i >= 0; i--){
            if(sum1 <= sum2){
                l1.add(A[i]);
                sum1 += A[i];
            }else{
                l2.add(A[i]);
                sum2 += A[i];
            }
        }
    }
}
