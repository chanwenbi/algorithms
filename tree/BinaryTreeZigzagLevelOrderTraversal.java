/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    // version 1(recommand): using deque
    // one pass, O(n), O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            List<Integer> levelValues = new ArrayList<Integer>();
            while (levelCount-- > 0) {
                if (leftToRight) {
                    // pollFirst, left, right, offerLast
                    TreeNode node = queue.pollFirst();
                    levelValues.add(node.val);
                    if (node.left != null) {
                        queue.offerLast(node.left);
                    }
                    if (node.right != null) {
                        queue.offerLast(node.right);
                    }
                } else {
                    // pollLast, right, left, offerFirst
                    TreeNode node = queue.pollLast();
                    levelValues.add(node.val);
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                }
            }
            result.add(levelValues);
            leftToRight = !leftToRight;
        }

        return result;
    }

    // version 2: reverse after first traverse
    // one pass, O(2n), O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelValues = new ArrayList<Integer>();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelValues);
        }

        return zigZagList(result);
    }

    private List<List<Integer>> zigZagList(List<List<Integer>> levels) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> level = levels.get(i);
            if (i % 2 == 0) {
                result.add(level);
            } else {
                List<Integer> reverseList = new ArrayList<Integer>();
                for (int j = level.size() - 1; j >= 0; j--) {
                    reverseList.add(level.get(j));
                }
                result.add(reverseList);
            }
        }
        return result;
    }

}
