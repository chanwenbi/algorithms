/**
 * Given a string containing only digits, restore it by returning all
 * possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }

        restore(result, new ArrayList<String>(), 0, s);

        return result;
    }

    private void restore(List<String> result, List<String> items, int pos, String s) {
        if (items.size() == 4) {
            if (pos == s.length()) {
                result.add(toIp(items));
            }
            return;
        }

        int size = Math.min(3, s.length() - pos);
        for (int i = 1; i <= size; i++) {
            String sub = s.substring(pos, pos + i);
            int value = Integer.parseInt(sub);
            if (value > 255 || (i == 2 && value < 10) || (i == 3 && value < 100)) {
                continue;
            }

            items.add(sub);
            restore(result, items, pos + i, s);
            items.remove(items.size() - 1);
        }
    }

    private String toIp(List<String> items) {
        StringBuilder sb = new StringBuilder();
        sb.append(items.get(0));
        for (int i = 1; i < items.size(); i++) {
            sb.append(".").append(items.get(i));
        }
        return sb.toString();
    }
}
