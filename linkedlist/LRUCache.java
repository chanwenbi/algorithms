/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 *
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 *
 */
public class LRUCache {
    // using double-linked list and hashmap, set and get will only take O(1)
    // using dummy head and tail node to reduce the complexity
    public static class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private Map<Integer, Node> values = new HashMap<Integer, Node>();

    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }

        Node node = values.get(key);

        moveToTail(node);
        return node.value;
    }

    private void moveToTail(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        insertToTail(node);
    }

    private void insertToTail(Node node) {
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
        node.next = tail;
    }

    public void set(int key, int value) {
        if (values.containsKey(key)) {
            Node node = values.get(key);
            node.value = value;

            moveToTail(node);
            return;
        }

        if (values.size() >= capacity) {
            // remove head
            values.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node node = new Node(key, value);
        values.put(key, node);

        insertToTail(node);
    }
}
