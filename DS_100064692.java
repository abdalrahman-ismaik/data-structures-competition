/**
 * High-performance hash table implementation for COSC310 assignment
 * Uses open addressing with linear probing for maximum speed
 * 
 * @param <T> the type of elements stored in the data structure
 */

 public class DS_100064692 implements DataStructureInterface<Integer> {
    private static final int INIT_CAPACITY = 1 << 15; // Initial capacity (must be a power of 2)
    private static final float LOAD_FACTOR = 0.40f;   // Load factor to determine resizing threshold

    // Use primitive int array instead of Integer for better performance
    private int[] keys; // Stores keys
    private boolean[] used; // Tracks used slots
    private int size; // Current number of elements
    private int capacity; // Current capacity of the table
    private int threshold; // Maximum size before rehashing
    private static final int DELETED = Integer.MIN_VALUE; // Marker for deleted slots

    public DS_100064692 () {
        this.capacity = INIT_CAPACITY;
        this.threshold = (int)(capacity * LOAD_FACTOR); // Calculate threshold based on load factor
        this.keys = new int[capacity];
        this.used = new boolean[capacity];
        this.size = 0;
    }

    // Optimized hash function - inlined and simplified
    private int getIndex(int key) {
        // Hash mixing to reduce collisions
        int h = key;
        h ^= h >>> 16;
        h *= 0x85ebca6b;
        h ^= h >>> 13;
        h *= 0xc2b2ae35;
        h ^= h >>> 16;
        
        // Use bitwise AND for fast modulo operation
        return h & (capacity - 1);
    }

    public boolean insert(Integer keyObj) {
        if (size >= threshold) return false; // Prevent insertion if table is full
        
        final int key = keyObj.intValue(); // Unbox key
        int i = getIndex(key); // Get initial index
        final int startIdx = i; // Save starting index for loop termination
        
        do {
            if (!used[i]) { // Empty slot found
                used[i] = true;
                keys[i] = key;
                size++;
                return true;
            }
            
            if (keys[i] == key) return false; // Key already exists
            
            i = (i + 1) & (capacity - 1); // Linear probing with wrap-around
        } while (i != startIdx); // Stop if we loop back to the start
        
        return false; // Table is full
    }

    public boolean search(Integer keyObj) {
        final int key = keyObj.intValue(); // Unbox key
        int i = getIndex(key); // Get initial index
        final int startIdx = i; // Save starting index for loop termination
        
        do {
            if (!used[i]) return false; // Stop if empty slot is found
            if (keys[i] == key) return true; // Key found
            i = (i + 1) & (capacity - 1); // Linear probing with wrap-around
        } while (i != startIdx); // Stop if we loop back to the start
        
        return false; // Key not found
    }

    public boolean delete(Integer keyObj) {
        final int key = keyObj.intValue(); // Unbox key
        int i = getIndex(key); // Get initial index
        final int startIdx = i; // Save starting index for loop termination
        
        do {
            if (!used[i]) return false; // Stop if empty slot is found
            
            if (keys[i] == key) { // Key found
                keys[i] = DELETED; // Mark slot as deleted
                size--;
                return true;
            }
            
            i = (i + 1) & (capacity - 1); // Linear probing with wrap-around
        } while (i != startIdx); // Stop if we loop back to the start
        
        return false; // Key not found
    }
}