/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 */
public class Solution {

    // O(n) O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            // invalid input
        }

        // the start station's pos
        int pos = 0;
        // total gas left from pos station to current station
        int totalGas = 0;
        // remember each range needed gas
        int needGas = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            // if totalGas < 0, then the stations between [pos, i]
            // could not be the start station.
            if (totalGas < 0) {
                needGas += -totalGas;
                totalGas = 0;
                pos = i + 1;
            }
        }

        // check whether the gas left can fit the needed gas
        if (pos == gas.length || totalGas < needGas) {
            return -1;
        }


        return pos;
    }

}
