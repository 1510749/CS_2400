import java.util.EmptyStackException;

public class LinkedStack <T> implements StackInterface<T>{
    private T[] items;
    private final static int DEFAULT_SIZE = 50;
    public Node head = null;
    private int qtyOfItems = 0;

    public LinkedStack(){
        items = (T[]) new Object[DEFAULT_SIZE];
        qtyOfItems = 0;
    }
    public LinkedStack(int initialSize){
        items = (T[]) new Object[initialSize];
        qtyOfItems = 0;
    }

    /**
     * Adds a new entry to the top of this stack.
     *
     * @param newEntry An object to be added to the stack.
     */
    @Override
    public void push(T newEntry) {
        Node newNode = new Node(newEntry, head);
        head = newNode;
        qtyOfItems++;
    }

    /**
     * Removes and returns this stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty before the operation.
     */
    @Override
    public T pop() {
        if (isEmpty()) {throw new EmptyStackException();}
        T returnItem = head.item;
        head = head.next;
        qtyOfItems--;
        return returnItem;
    }

    /**
     * Retrieves this stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public T peek() {
        if(!isEmpty()) {
            return head.item;
        }
        throw new EmptyStackException();
    }

    /**
     * Detects whether this stack is empty.
     *
     * @return True if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return qtyOfItems == 0;
    }

    /**
     * Removes all entries from this stack.
     */
    @Override
    public void clear() {
        Node ptr = head;
        while (head != null) {
            head = head.next;
            ptr.next = null;
            ptr = head;
        }
        qtyOfItems = 0;
    }


    private class Node{
        T item;
        Node next;

        private Node() {
            this(null,null);
        }

        private Node(T item) {
            this(item,null);
        }

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
