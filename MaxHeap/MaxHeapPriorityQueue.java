public class MaxHeapPriorityQueue<T> implements PriorityQueueInterface {
    private MaxHeapInterface maxHeapPriorityQueue;
    public MaxHeapPriorityQueue(){maxHeapPriorityQueue = new ArrayMaxHeap();}
    public MaxHeapPriorityQueue(int size){maxHeapPriorityQueue = new ArrayMaxHeap(size);}
    public MaxHeapPriorityQueue(Comparable[] arr){maxHeapPriorityQueue = new ArrayMaxHeap((Comparable[]) arr);}

    /**
     * Adds a new entry to this priority queue.
     *
     * @param newEntry An object to be added.
     */
    @Override
    public void add(Comparable newEntry) {
        maxHeapPriorityQueue.add(newEntry);
    }

    /**
     * Removes and returns the entry having the highest priority.
     *
     * @return Either the object having the highest priority or,
     * if the priority queue is empty before the operation, null.
     */
    @Override
    public Comparable remove() {
        return maxHeapPriorityQueue.removeMax();
    }

    /**
     * Retrieves the entry having the highest priority.
     *
     * @return Either the object having the highest priority or,
     * if the priority queue is empty, null.
     */
    @Override
    public Comparable peek() {
        return maxHeapPriorityQueue.getMax();
    }

    /**
     * Detects whether this priority queue is empty.
     *
     * @return True if the priority queue is empty, or false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return maxHeapPriorityQueue.isEmpty();
    }

    /**
     * Gets the size of this priority queue.
     *
     * @return The number of entries currently in the priority queue.
     */
    @Override
    public int getSize() {
        return maxHeapPriorityQueue.getSize();
    }

    /**
     * Removes all entries from this priority queue.
     */
    @Override
    public void clear() {
        maxHeapPriorityQueue.clear();
    }
}
