public class SuffixTree {
    SuffixTreeNode root = new SuffixTreeNode();
    public SuffixTree(String s) {
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            root.insertString(suffix, i);
        }
    }

    public List<Integer> getIndexes(String s) {
        return root.getIndexes(s);
    }
}

public class SuffixTreeNode {
    Map<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
    List<Integer> indexes = new ArrayList<Integer>();

    public void insertString(String s, int index) {
        indexes.add(index);
        if (s.length() == 0) {
            return;
        }
        char c = s.charAt(0);
        if (!children.containsKey(c)) {
            children.put(c, new SuffixTreeNode());
        }
        children.get(c).insertString(s.substring(1), index);
    }

    public List<Integer> getIndexes(String s) {
        if (s == null || s.length() == 0) {
            return indexes;
        }
        char c = s.charAt(0);
        if (!children.containsKey(c)) {
            return new ArrayList<Integer>();
        }

        return children.get(c).getIndexes(s.substring(1));
    }
}
