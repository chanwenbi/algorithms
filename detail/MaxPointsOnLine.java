/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {

    // version 1(recommand): using slope as key
    public int maxPoints(Point[] points) {
        if (points.length == 1) return 1;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> counts = new HashMap<Double, Integer>();
            int result = 0;
            int same = 1;
            for (int j = i+1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;

                if (x == 0 && y == 0) {
                    same++;
                    continue;
                }

                // 1.0 * 0 / -1 = -0.0, so need to convert it by + 0.0
                double slope = x == 0 ? Double.POSITIVE_INFINITY : 1.0 * y/x + 0.0;

                if (counts.containsKey(slope)) {
                    counts.put(slope, counts.get(slope) + 1);
                } else {
                    counts.put(slope, 1);
                }

                result = Math.max(result, counts.get(slope));
            }
            max = Math.max(result + same, max);
        }
        return max;
    }

    // version 2: using gcd as key
    public int gcd(int x, int y) {
        if (x < y) return gcd(y, x);
        return y == 0 ? x : gcd(y, x % y);
    }

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        if (points.length == 1) {
            return 1;
        }

        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> counts = new HashMap<String, Integer>();
            int result = 0;
            int same = 1;
            for (int j = i+1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;

                if (x == 0 && y == 0) {
                    same++;
                    continue;
                }

                int sign = (x == 0) ? y / Math.abs(y) : x / Math.abs(x);
                int g = gcd(Math.abs(x), Math.abs(y)) * sign;
                x = x / g;
                y = y / g;

                String key = x + " " + y;
                if (counts.containsKey(key)) {
                    counts.put(key, counts.get(key) + 1);
                } else {
                    counts.put(key, 1);
                }

                result = Math.max(result, counts.get(key));
            }
            max = Math.max(result + same, max);
        }
        return max;
    }

}
