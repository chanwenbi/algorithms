/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 *
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 *
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 *
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<Integer, UndirectedGraphNode> nodes = new HashMap<Integer, UndirectedGraphNode>();

    // Version 1: dfs with recursion
    // O(n), O(n) n is the nodes number
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        if (nodes.containsKey(node.label)) {
            return nodes.get(node.label);
        }

        UndirectedGraphNode copiedNode = new UndirectedGraphNode(node.label);
        nodes.put(copiedNode.label, copiedNode);
        List<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();
        for (UndirectedGraphNode n : node.neighbors) {
            neighbors.add(cloneGraph(n));
        }
        copiedNode.neighbors = neighbors;

        return copiedNode;
    }

    // Version 2: bfs
    // O(n), O(n) n is the nodes number
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> nodes = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map
            = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        // clone nodes
        nodes.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            while (size-- > 0) {
                UndirectedGraphNode head = nodes.poll();
                UndirectedGraphNode newHead = map.get(head);
                for (int i = 0; i < head.neighbors.size(); i++) {
                    UndirectedGraphNode neighbor = head.neighbors.get(i);
                    if (!map.containsKey(neighbor)) {
                        UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                        map.put(neighbor, newNeighbor);
                        nodes.offer(neighbor);
                    }
                    newHead.neighbors.add(map.get(neighbor));
                }
            }
        }

        return map.get(node);
    }
}
