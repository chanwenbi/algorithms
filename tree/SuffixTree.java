public class SuffixTree {
    private final String s;
    private final SuffixTreeNode root;

    public SuffixTree(String s) {
        this.s = s;
        this.root = new SuffixTreeNode();
    }

    public init() {
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            root.insertString(suffix, i);
        }
    }

    public List<Integer> getIndices(String s) {
        return root.getIndices(s);
    }

    static class SuffixTreeNode {
        final Map<Character, SuffixTreeNode> children;
        final List<Integer> indices;

        public SuffixTreeNode() {
            this.children = new HashMap<Character, SuffixTreeNode>();
            this.indices = new ArrayList<Integer>();
        }

        public void insertString(String s, int index) {
            indices.add(index);
            if (s.length() == 0) {
                return;
            }

            char c = s.charAt(0);
            if (!children.containsKey(c)) {
                children.put(c, new SuffixTreeNode());
            }
            children.get(c).insertString(s.substring(1), index);
        }

        public List<Integer> getIndices(String s) {
            if (s == null || s.length() == 0) {
                return indices;
            }

            char c = s.charAt(0);
            if (!children.containsKey(c)) {
                return new ArrayList<Integer>();
            }

            return children.get(c).getIndices(s.substring(1));
        }
    }
}
