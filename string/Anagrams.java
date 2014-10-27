/**
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * anagram: reorder the Characters to form a new word.
 * So how to check whether two words are anagram:
 * they're contains the same num of different chars.
 *
 * Note: All inputs will be in lower-case.
 */
public class Solution {

    private int getHash(int[] count) {
        int hash = 0;
        for (int num : count) {
            hash = hash * 37 + num;
        }
        return hash;
    }

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            int hash = getHash(count);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }

            map.get(hash).add(str);
        }

        for (ArrayList<String> tmp : map.values()) {
            if (tmp.size() > 1) {
                result.addAll(tmp);
            }
        }

        return result;
    }
}
