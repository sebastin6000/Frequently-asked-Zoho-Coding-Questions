/* 
Question:
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. 
Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation:
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

Constraints:
1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
*/

/* 
Understanding the Problem Statement:
- The problem involves creating a Least Recently Used (LRU) cache system.
- The cache has a fixed capacity, and as items are accessed or added, their "recent usage" is tracked.
- If the cache exceeds its capacity, the least recently used (LRU) item is removed.
- The goal is to create a data structure that allows us to access and modify the cache in O(1) time complexity for both `get()` and `put()` operations.

What is being asked:
- Implement the LRUCache class with the ability to:
  1. Initialize a cache with a given capacity.
  2. Get the value of a key if it exists.
  3. Put a key-value pair in the cache, updating it if the key already exists, and evicting the least recently used key if necessary.

*/

/* 
Extracting Information from the Problem Statement:
1. Input data type:
   - A series of operations are given to be executed on an LRU cache object, 
     including the `LRUCache(int capacity)`, `get(int key)`, and `put(int key, int value)` methods.

2. Expected Output:
   - The output for each operation is:
     - `null` for `put()` operations, as they don't return a value.
     - The value of the key for `get()` operations or `-1` if the key doesn't exist.

3. Output return type:
   - `get()` returns the value for the key or `-1` if not found.
   - `put()` has no return value, so it returns `null`.

4. Time complexity expectations:
   - Both the `get()` and `put()` functions must operate in O(1) average time complexity.

5. Constraints:
   - The cache has a fixed capacity, and the size of the cache and operations are constrained as outlined in the problem.

*/

/* 
Thinking Solution for the Problem Statement:
1. Identification Part:
   - This is a data structure design problem where we need to implement a cache with a specific eviction policy (LRU).
   - The key challenge is ensuring that both `get()` and `put()` operations run in constant time, O(1).

2. Destructuring:
   - LRU means that the least recently used item will be evicted when the cache exceeds its capacity.
   - To achieve O(1) operations, we need an efficient way to access, insert, and remove items while also tracking their usage.
   - A **doubly linked list** and a **hashmap** are ideal for this.
     - The hashmap allows O(1) access to elements.
     - The doubly linked list keeps the elements in order of usage, so removing the least recently used element (head) is O(1).

3. Conversational solution into smaller subtask:
   - Step 1: Create a doubly linked list to store the key-value pairs in order of usage.
   - Step 2: Use a hashmap to map keys to their corresponding nodes in the doubly linked list.
   - Step 3: For `put()`, insert the element and move it to the front if it's already present, or add it at the front if not.
   - Step 4: For `get()`, move the accessed element to the front of the list and return its value.
   - Step 5: Evict the least recently used element (remove from the tail) when the cache exceeds its capacity.

*/

/* 
Conversional Solution into Subtasks:
1. Use a doubly linked list to maintain the order of access.
2. Use a hashmap to store the key-node mapping for constant-time access.
3. Implement methods to add, remove, and move elements in the doubly linked list.
4. Ensure the cache never exceeds its capacity by removing the least recently used item when necessary.

*/

/* 
Subtasks of Conversional Solution into Code:
1. Create the `LRUCache` class and initialize the cache with a given capacity.
2. Create a doubly linked list node structure for storing key-value pairs.
3. Use a hashmap for O(1) access to the nodes in the list.
4. Implement `get()` to access values and move the node to the front.
5. Implement `put()` to insert or update values and manage the eviction policy.

*/

/* 
Java Code according to conversational subtasks.
*/

import java.util.*;

public class LRUCache {

    // Doubly linked list node class to store key-value pairs
    private class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;

    // Initialize LRU cache with positive size capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1, -1);  // Dummy head node
        tail = new Node(-1, -1);  // Dummy tail node
        head.next = tail;
        tail.prev = head;
    }

    // Move the given node to the front of the list (most recently used)
    private void moveToFront(Node node) {
        removeNode(node);
        addNodeAtFront(node);
    }

    // Add the node right after the head
    private void addNodeAtFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Remove a node from the list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Get the value of the key if it exists, otherwise return -1
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveToFront(node);  // Move the accessed node to the front (most recently used)
        return node.value;
    }

    // Put the key-value pair into the cache
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update the existing node and move it to the front
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            // Create a new node
            Node node = new Node(key, value);
            cache.put(key, node);
            addNodeAtFront(node);

            // If the cache exceeds capacity, remove the least recently used node (tail)
            if (cache.size() > capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
        }
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        // Test case 1
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);  // cache = {1=1}
        cache.put(2, 2);  // cache = {1=1, 2=2}
        System.out.println(cache.get(1));  // returns 1
        cache.put(3, 3);  // evicts key 2, cache = {1=1, 3=3}
        System.out.println(cache.get(2));  // returns -1 (not found)
        cache.put(4, 4);  // evicts key 1, cache = {4=4, 3=3}
        System.out.println(cache.get(1));  // returns -1 (not found)
        System.out.println(cache.get(3));  // returns 3
        System.out.println(cache.get(4));  // returns 4
    }
}

/* 
Time and Space Complexity Explanation:
1. Time Complexity:
   - `get(key)` operation: O(1), since both accessing the hashmap and moving the node in the doubly linked list are O(1).
   - `put(key, value)` operation: O(1), 
      as it involves inserting or updating the node in the hashmap and moving the node in the doubly linked list, both of which are O(1).
   
2. Space Complexity:
   - O(capacity), as the cache stores at most `capacity` key-value pairs.

*/

/* 
For loop/while loop walkthrough:
- The doubly linked list is updated using operations like `addNodeAtFront` and `removeNode`, which don't require explicit loops.

*/

/* 
Complete code walkthrough:
- The `LRUCache` class is initialized with a fixed capacity.
- We use a hashmap to store key-value pairs and a doubly linked list to maintain the order of usage.
- `put()` inserts or updates a key-value pair and ensures that the cache does not exceed its capacity by evicting the least recently used key.
- `get()` retrieves the value of a key and moves the key to the front of the list to mark it as recently used.
*/
