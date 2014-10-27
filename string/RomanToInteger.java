/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {

    private Map<Character, Integer> getRomanMap() {
        Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        return romanMap;
    }

    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = getRomanMap();

        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int value = romanMap.get(s.charAt(i));
            int nextValue = romanMap.get(s.charAt(i+1));
            if (value < nextValue) {
                result -= value;
            } else {
                result += value;
            }
        }
        result += romanMap.get(s.charAt(s.length()-1));

        return result;
    }
}
