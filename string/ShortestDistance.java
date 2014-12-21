/**
 * You have a large text file containing words.
 * Given any two words, find the shortest distance
 * (in terms of number of words) between them in the file.
 *
 * could use HashMap to reduce the time complexity if this function will be used
 * multiple times.
 */
public class Solution {

    public int shortest(String[] words, String w1, String w2) {
        int min = Integer.MAX_VALUE;
        int w1Pos = -1;
        int w2Pos = -1;

        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(w1) && !words[i].equals(w2)) {
                continue;
            }

            if (words[i].equals(w1)) {
                w1Pos = i;
            } else if (words[i].equals(w2)) {
                w2Pos = i;
            }

            if (w1Pos != -1 && w2Pos != -1) {
                min = Math.min(min, Math.abs(w1Pos - w2Pos));
            }
        }

        return min;
    }
}
