package gfa.inquiry.DoubleLinkedList;

/**
 * DoubleLinkedList is a version of the Linked List data type that
 * offers the current node 'links' to both its previous node, and its
 * next node. This helps in optimizing the list modification process,
 * as it is easier to gain reference to the previous node in a
 * DoubleLinkedList than it is in a SingleLinkedList.
 *
 * @author Joel Strand
 * @version 1.0.2
 */

public class DoubleLinkedList implements ListInterface {

    private Node front;
    private int numElements;

    /**
     * Class Constructor
     *
     * Worst Case Time Complexity: Constant - O(1)
     */
    public DoubleLinkedList() {
        this.front = null;
        numElements = 0;
    }

    /**
     * Adds a new node to the end of the list.
     * Allows Duplicates
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @param element Object, null
     * @return true, IllegalArgumentException
     */
    @Override
    public boolean add(Object element) {
        if (element == null) throw new IllegalArgumentException("Cannot manually insert null nodes.");

        Node nodeToAdd = new Node(element);

        if (numElements == 0) {
            this.front = nodeToAdd;
        } else {
            Node prev = getNode(numElements - 1);
            prev.setNext(nodeToAdd);
            nodeToAdd.setPrevious(prev);
        }
        numElements++;
        return true;
    }

    /**
     * Adds a new node at a specified index position.
     * Allows Duplicates.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @param index (0 < index < numElements - 1), (index > numElements - 1 || index < 0)
     * @param element Object, null
     * @return (1, 1) true, (index 2) IndexOutOfBoundsException, (element 2) IllegalArgumentException
     */
    @Override
    public boolean add(int index, Object element) {
        if (index > numElements - 1 || index < 0) throw new IndexOutOfBoundsException("Cannot get at index " + index + ", Out Of Bounds.");
        else if (element == null) throw new IllegalArgumentException("Cannot add a null node.");

        Node nodeToAdd = new Node(element);

        if (index == 0) {
            Node next = this.front;
            this.front = nodeToAdd;
            nodeToAdd.setNext(next);
            next.setPrevious(nodeToAdd);
            numElements++;
            return true;
        }

        Node ptr = getNode(index);
        Node prev = ptr.getPrevious();

        prev.setNext(nodeToAdd);
        nodeToAdd.setNext(ptr);
        nodeToAdd.setPrevious(prev);
        ptr.setPrevious(nodeToAdd);
        return true;
    }

    /**
     * Clears the entire linked list to empty.
     *
     * Worst Case Time Complexity: Constant - 0(1)
     */
    @Override
    public void clear() {
        this.front = null;
        numElements = 0;
    }

    /**
     * Returns boolean based on result of indexOf()
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @param element objectInList, objectNotInList, null
     * @return true, false, IllegalArgumentException
     */
    @Override
    public boolean contains(Object element) {
        if (element == null) throw new IllegalArgumentException("Nulls are not contained in list.");
        return indexOf(element) != -1;
    }

    /**
     * Returns data of the node at the specified index position.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @param index (0 < index < numElements - 1), objectNotInList (index > numElements - 1 || index < 0)
     * @return Object, null, IndexOutOfBoundsException
     */
    @Override
    public Object get(int index) {
        if (index > numElements - 1 || index < 0) throw new IndexOutOfBoundsException("Cannot get at index " + index + ", Out Of Bounds.");

        Node ptr = this.front;
        int counter = 0;

        while (ptr.getNext() != null) {
            // If found, return value.
            if (counter == index) return ptr.getValue();

            // Continue Iterating
            ptr = ptr.getNext();
            counter++;
        }
        if (counter == index){
            return ptr.getValue();
        }
        return null;
    }

    /**
     * Returns index position of a specified element.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @param element objectInList, objectNotInList, null
     * @return index, -1, IllegalArgumentException
     */
    @Override
    public int indexOf(Object element) {
        if (element == null) throw new IllegalArgumentException("Element cannot be null");

        Node ptr = this.front;
        int counter = 0;

        if (front == null) {
            return -1;
        } else if (this.front.getValue().equals(element)) {
            return 0;
        }

        while (ptr.getNext() != null) {
            if (ptr.getValue().equals(element)){
                return counter;
            }
            ptr = ptr.getNext();
            counter++;
        }
        if (ptr.getValue().equals(element)){
            return counter;
        }
        return -1;
    }

    /**
     * Returns the final index of the Linked List.
     *
     * Worst Case Time Complexity: Constant - O(1)
     *
     * @param element Object, null
     * @return numElements - 1, IllegalArgumentException
     */
    @Override
    public int lastIndexOf(Object element) {
        if (element == null) throw new IllegalArgumentException("Element cannot be null");
        if (numElements == 0) return -1;
        return numElements - 1;
    }

    /**
     * Removes an element from the Linked List.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @param element objectInList, objectNotInList, null
     * @return true, IllegalArgumentException, IllegalArgumentException
     */
    @Override
    public boolean remove(Object element) {
        if (element == null || indexOf(element) == -1) throw new IllegalArgumentException("Element cannot be null");
        else if (indexOf(element) == -1) throw new IllegalArgumentException("Element not in list");

        Node ptr = getNode(indexOf(element));

        if (ptr.getPrevious() == null) {
            if (ptr.getNext() == null) {
                this.front = null;
            } else {
                this.front = ptr.getNext();
                this.front.setPrevious(null);
            }
            numElements--;
            return true;
        }

        Node prev = ptr.getPrevious();

        if (ptr.getNext() == null) {
            prev.setNext(null);
            numElements--;
            return true;
        }

        Node next = ptr.getNext();
        prev.setNext(next);
        next.setPrevious(prev);
        numElements--;
        return true;
    }

    /**
     * Removes an element from the list at a specified index position.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @param index (0 < index < numElements - 1), (index < 0 || index > numElements - 1)
     * @return Object, IndexOutOfBoundsException
     */
    @Override
    public Object remove(int index) {
        if (index < 0 || index > numElements - 1) throw new IndexOutOfBoundsException("Cannot remove at index " + index + ", Out Of Bounds.");

        Node ptr = getNode(index);

        if (index == 0) {
            if (ptr.getNext() == null) {
                this.front = null;
            } else {
                this.front = ptr.getNext();
                this.front.setPrevious(null);
            }
            numElements--;
            return ptr.getValue();
        }

        Node prev = ptr.getPrevious();

        if (index == numElements - 1) {
            prev.setNext(null);
            numElements--;
            return ptr.getValue();
        }

        Node next = ptr.getNext();

        prev.setNext(next);
        next.setPrevious(prev);
        numElements--;
        return ptr.getValue();
    }

    /**
     * Sets the data of an element to specified data.
     *
     * Worst Case Time Complexity - Linear - O(n)
     *
     * @param index (0 < index < numElements - 1), (index > numElements - 1 || index < 0)
     * @param element Object, null
     * @return (1, 1) Object, (index 2) IndexOutOfBoundsException, (element 2) IllegalArgumentException
     */
    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index > numElements - 1) throw new IndexOutOfBoundsException("Cannot set at index " + index + ", Out Of Bounds.");
        else if (element == null) throw new IllegalArgumentException("Element can not be null");

        Node ptr = getNode(index);
        ptr.setValue(element);
        return ptr.getValue();
    }

    /**
     * Returns the total amount of elements in the Linked List.
     *
     * Worst Case Time Complexity - Constant - O(1)
     *
     * @return numElements
     */
    @Override
    public int size() {
        return this.numElements;
    }

    /**
     * Returns the contents of the Linked List as a String.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @return "[ele 1, ele 2, ... ele numElements -1]"
     */
    @Override
    public String toString() {
        Node ptr = this.front;
        String s = "[";

        if (ptr == null) return "[]";

        // Iterate over list
        while (ptr.getNext() != null) {
            // Concat element to string
            Object temp = ptr.getValue();
            s = s.concat(temp + ", ");
            ptr = ptr.getNext();
        }
        // Handle edge == null case
        if (ptr.getValue() == null) {
            s = s.concat("]");
            return s;
        }

        // handle edge != null
        s = s.concat(ptr.getValue() + "]");
        return s;
    }

    /**
     * Helper Method to return a node at a given index position.
     *
     * Worst Case Time Complexity - Linear - O(n)
     *
     * @param index (0 < index < numElements - 1), (index < 0 || index > numElements - 1)
     * @return Node, null
     */
    private Node getNode(int index) {
        Node ptr = this.front;
        int counter = 0;

        while (ptr.getNext() != null) {
            if (counter == index) return ptr;

            ptr = ptr.getNext();
            counter++;
        }
        return ptr;
    }
}
