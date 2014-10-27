/**
 * Given a string s, partition s such that every substring of the partition
 * is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 *   [
 *       ["aa","b"],
 *       ["a","a","b"]
 *   ]
 */
public class Solution {

    // Version 1(recommand): dfs
    // O(2^n)
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (s == null) {
            return result;
        }

        ArrayList<String> path = new ArrayList<String>();
        helper(s, path, 0, result);

        return result;
    }

    private void helper(String s, ArrayList<String> path, int pos,
            ArrayList<ArrayList<String>> result) {
        if (pos == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int i = pos + 1; i <= s.length(); i++) {
            String prefix = s.substring(pos, i);
            if (!isPalindrome(prefix)) {
                continue;
            }

            path.add(prefix);
            helper(s, path, i, result);
            path.remove(path.size() - 1);
        }
    }

    // version 2: divide and conquer
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public List<List<String>> prefix(List<List<String>> original, String s) {
        List<List<String>> result = new ArrayList<List<String>>();

        for (List<String> ls : original) {
            List<String> lscopy = new ArrayList<String>();
            lscopy.add(s);
            lscopy.addAll(ls);
            result.add(lscopy);
        }

        return result;
    }

    public void partitionHelper(List<List<String>> partition, String s) {

        if (s.length() <= 1) {
            List<String> p = new ArrayList<String>();
            if (!s.isEmpty()) {
                p.add(s);
            }
            partition.add(p);
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String subString = s.substring(0, i);
            if (isPalindrome(subString)) {
                List<List<String>> arr = new ArrayList<List<String>>();
                partitionHelper(arr, s.substring(i, s.length()));
                partition.addAll(prefix(arr, subString));
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<List<String>>();
        partitionHelper(ret, s);
        return ret;
    }
}
