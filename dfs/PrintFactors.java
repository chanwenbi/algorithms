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
