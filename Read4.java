/**
 * Read N Characters Given Read4
 *
 * By using the read4 API, implement the function int read(char[] buf, int n)
 * that read n characters from the file.
 *
 * The return value is the actual number of characters read.
 * For example, it returns 3 if there is only 3 characters left in the file.
 */
public class Solution {

    public int read(char[] buf, int n) {
        if (buf == null || n <= 0 || buf.length < n) {
            return 0;
        }

        int count = 0;
        char[] temp = new char[4];
        while (n > 0) {
            int k = read4(temp);

        }
    }
}
