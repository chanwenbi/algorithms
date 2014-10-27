public class Solution {

    static class TrieNode {
        TrieNode[] childs;
        List<String> values;
        char minChar;

        public TrieNode() {
            this.childs = new TrieNode[256];
            this.values = new ArrayList<String>();
            this.minChar = Character.MAX_VALUE;
        }
    }

    static TrieNode buildTrie(String[] usernames) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < usernames.length; i++) {
            int len = usernames[i].length();
            TrieNode current = root;
            for (int j = 0; j < len; j++) {
                char c = Character.toLowerCase(usernames[i].charAt(j));
                if (current.childs[c] == null) {
                    current.childs[c] = new TrieNode();
                    if (c < current.minChar) {
                        current.minChar = c;
                    }
                }
                current = current.childs[c];
            }
            current.values.add(usernames[i]);
        }
        return root;
    }

    static void queryString(TrieNode node, String q) {
        TrieNode current = node;

        for (int i = 0; i < q.length(); i++) {
            char c = Character.toLowerCase(q.charAt(i));
            if (current.childs[c] == null) {
                System.out.println("-1");
                return;
            }

            current = current.childs[c];
        }
        printSmallest(current);
    }

    static void printSmallest(TrieNode node) {
        while (node != null) {
            TrieNode minNode = node.childs[node.minChar];
            if (minNode.values.size() == 0) {
                node = minNode;
                continue;
            }

            System.out.println(minNode.values.get(0));
        }
    }

    public static void typeahead(String[] usernames, String[] queries) {
        // Write your code here
        // To print results to the standard output please use System.out.println
        // Example: System.out.println("Hello world!");
        if (usernames == null || usernames.length == 0) {
            return;
        }
        TrieNode root = buildTrie(usernames);
        for (String query : queries) {
            queryString(root, query);
        }
    }
}
