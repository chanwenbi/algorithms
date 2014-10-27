/**
 * Given a string which contains only letters. Sort it by lower case first and
 * upper case second.
 *
 * Note
 * It's not necessary to keep the original order of lower-case letters and upper
 * case letters.
 *
 * Example
 * For "abAcD", a reasonable answer is "acbAD"
 */
public class Solution {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if (chars == null) {
            return;
        }

        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a') {
                swap(chars, index, i);
                index++;
            }
        }
    }

    private void swap(char[] chars, int pos1, int pos2) {
        if (pos1 == pos2) {
            return;
        }

        char temp = chars[pos1];
        chars[pos1] = chars[pos2];
        chars[pos2] = temp;
    }
}
