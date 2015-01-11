/**
 * Given arrival and departure times of all trains that reach a railway station,
 * find the minimum number of platforms required for the railway station so that
 * no train waits.
 *
 * We are given two arrays which represent arrival and departure times of
 * trains that stop, examples:
 *
 * Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
 *         dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 *         Output: 3
 *         There are at-most three trains at a time (time between 11:00 to 11:20)
 */
public class Solution {

    // version 1: Using one day minutes interval tree, count the max trains
    // in each time range during insert trains

    // version 2: sort the arrive and departure time, keep track the trains
    // arrived but not leaved
    public int minStations(int[] arrive, int[] departure) {
        if (arrive == null || departure == null || arrive.length != departure.length) {
            // invalid input
            return -1;
        }

        Arrays.sort(arrive);
        Arrays.sort(departure);

        int result = 0;
        int arrived = 0;
        int i = 0;
        int j = 0;
        while (i < arrive.length && j < departure.length) {
            if (arrive[i] < departure[j]) {
                arrived++;
                i++;
                result = Math.max(result, arrived);
            } else {
                arrived--;
                j++;
            }
        }

        return result;
    }
}
