/**
 * The code base version is an integer and start from 0 to n.
 * One day, someone commit a bad version in the code case, so it
 * caused itself and the following versions are all failed in the unittests.
 * You can determine whether a version is bad by the following interface:
 * boolean isBadVersion(int version);
 *
 * Find the first bad version.
 *
 * reduce this problem to:
 * {1, 1, 1, 1, 1, 0, 0, 0}
 * find the first 0 pos.
 *
 * simple version of search range problem.
 */
public class Solution {

    public int search(int[] version) {
        // left close, right open
        int l = 0;
        int h = version.length;

        int first = -1;

        while (l < h) {
            int m = l + (h - l) / 2;
            if (isBadVersion(version[m])) {
                h = m;
                first = m;
            } else {
                l = m + 1;
            }
        }

        return first == -1 ? -1 : version[first];
    }

}
