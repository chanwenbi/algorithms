/**
 * optimized for multiple minimum range query
 *
 * http://www.topcoder.com/tc?d1=tutorials&d2=lowestCommonAncestor&module=Static
 */
public class Solution {

    // version 1: for all range cache all minimum, preprocessing: O(n^2), query: O(1)
    // version 2: split into sqrt(n) pieces, cache each piece minimum, preprocessing: O(n), query: O(sqrt(n))
    // version 3: sparse table, m[i][j] contains the index of minimum value in range i to i + 2^j - 1
    //            preprocessing: O(nlgn), query: O(1)
    // version 4: segment trees, preprocessing: O(n), query: O(lgn)

}
