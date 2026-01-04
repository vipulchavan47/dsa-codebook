package linkedlist.dll;

import java.util.HashMap;
import java.util.Map;

class LRUcache {

    // Doubly Linked List node
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;                 // Max cache size
    private Map<Integer, Node> map;        // Key → Node mapping
    private Node head, tail;               // Dummy head & tail

    public LRUcache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Create dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        // Connect head and tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // If key not present, return -1
        if (!map.containsKey(key)) {
            return -1;
        }

        // Move accessed node to front (MRU)
        Node node = map.get(key);
        remove(node);
        insertAfterHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        // If key already exists
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            // Update recent usage
            remove(node);
            insertAfterHead(node);
        }
        // New key
        else {
            // If cache full, remove LRU (before tail)
            if (map.size() == capacity) {
                Node lru = tail.prev;
                map.remove(lru.key);
                remove(lru);
            }

            // Insert new node at front
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAfterHead(newNode);
        }
    }

    // Remove node from doubly linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node right after head (most recently used)
    private void insertAfterHead(Node node) {
        Node nextNode = head.next;

        head.next = node;
        node.prev = head;

        node.next = nextNode;
        nextNode.prev = node;
    }


    public static void main(String[] args) {
            LRUcache cache = new LRUcache(2);

            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1)); // 1

            cache.put(3, 3);                  // evicts key 2
            System.out.println(cache.get(2)); // -1

            cache.put(4, 4);                  // evicts key 1
            System.out.println(cache.get(1)); // -1
            System.out.println(cache.get(3)); // 3
            System.out.println(cache.get(4)); // 4
    }

}
