public class Solution {

    public List<List<Integer>> printFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0) {
            return result;
        }

        print(result, new ArrayList<Integer>(Arrays.asList(1)), 2, n);
        return result;
    }

    private void print(List<List<Integer>> result, List<Integer> path, int pos, int n) {
        if (n == 1) {
            return;
        }

        List<Integer> ret = new ArrayList<Integer>(path);
        ret.add(n);
        result.add(ret);

        int up = (int) Math.floor(Math.sqrt(n));
        for (int i = pos; i <= up; i++) {
            if (n % i != 0) {
                continue;
            }

            path.add(i);
            print(result, path, i, n / i);
            path.remove(path.size() - 1);
        }
    }
}


/**
 * Efficient program to print all prime factors of a given number
 * Given a number n, write an efficient function to print all prime factors of n. For example, if the input number is 12, then output should be “2 2 3″. And if the input number is 315, then output should be “3 3 5 7″.
 *
 * http://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
 */
public List<Integer> primeFactors(int n) {
    List<Integer> result = new ArrayList<Integer>();
    while (n % 2 == 0) {
        result.add(2);
        n /= 2;
    }

    for (int i = 3; i <= (int) Math.floor(Math.sqrt(n)); i += 2) {
        while (n % i == 0) {
            result.add(i);
            n /= i;
        }
    }

    if (n > 2) {
        result.add(n);
    }

    return result;
}
