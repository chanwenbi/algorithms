/**
 * Given a digit string, return all possible letter combinations that the
 * number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 */
public class Solution {

    // version 1: dfs
    List<String> keyboard = Arrays.asList(" ", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz");

    private void letterCombinationsDfs(List<String> result, StringBuilder letters,
            int pos, String digits) {
        if (pos == digits.length()) {
            result.add(letters.toString());
            return;
        }

        String mapping = keyboard.get(digits.charAt(pos) - '0');
        for (int i = 0; i < mapping.length(); i++) {
            letters.append(mapping.charAt(i));
            letterCombinationsDfs(result, letters, pos + 1, digits);
            letters.deleteCharAt(letters.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        letterCombinationsDfs(result, new StringBuilder(), 0, digits);

        return result;
    }

    // version 2: divide and conquer
    private Map<Character, String> charMapping;

    private Map<Character, String> getIntToChars() {
        Map<Character, String> charMapping = new HashMap<Character, String>();
        charMapping.put('2', "abc");
        charMapping.put('3', "def");
        charMapping.put('4', "ghi");
        charMapping.put('5', "jkl");
        charMapping.put('6', "mno");
        charMapping.put('7', "pqrs");
        charMapping.put('8', "tuv");
        charMapping.put('9', "wxyz");
        return charMapping;
    }

    private void letterCombinationsHelper(List<List<String>> combinations, String digits, int pos) {
        if (pos >= digits.length()) {
            return;
        }
        List<String> newCombinations = new ArrayList<String>();
        String chars = charMapping.get(digits.charAt(pos));
        // divide and conquer
        for (int i = 0; i < chars.length(); i++) {
            char s = chars.charAt(i);
            for (String comb : combinations.get(combinations.size() - 1)) {
                newCombinations.add(comb + s);
            }
        }
        combinations.add(newCombinations);
        letterCombinationsHelper(combinations, digits, pos+1);
    }

    public List<String> letterCombinations(String digits) {
        charMapping = getIntToChars();
        List<List<String>> combinations = new ArrayList<List<String>>();
        List<String> empty = new ArrayList<String>();
        empty.add("");
        combinations.add(empty);
        letterCombinationsHelper(combinations, digits, 0);
        return combinations.get(combinations.size() - 1);
    }
}
