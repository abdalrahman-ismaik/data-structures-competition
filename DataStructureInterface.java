/**
 * Interface for a basic data structure supporting insert, delete, and search operations.
 * This data structure should not allow duplicate elements.
 * @param <T> the type of elements stored in the data structure
 */
public interface DataStructureInterface<T> {
    /**
     * Insert an item into the data structure.
     * If the item already exists, it should not be inserted again.
     * @param item the item to insert
     * @return true if the item was inserted, false if it was a duplicate
     */
    boolean insert(T item);
    
    /**
     * Delete an item from the data structure.
     * @param item the item to delete
     * @return true if the item was found and deleted, false otherwise
     */
    boolean delete(T item);
    
    /**
     * Search for an item in the data structure.
     * @param item the item to search for
     * @return true if the item was found, false otherwise
     */
    boolean search(T item);
}
