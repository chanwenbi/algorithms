/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to
 * ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int l = 0;
        int h = s.length() - 1;
        while (l < h) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(h))) {
                h--;
            } else if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(h))) {
                l++;
                h--;
            } else {
                return false;
            }
        }
        return true;
    }
}
