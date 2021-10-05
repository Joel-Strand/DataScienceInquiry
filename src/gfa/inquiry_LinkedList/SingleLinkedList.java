package gfa.inquiry_LinkedList;

/**
 * SingleLinkedList is an experiment designed to help study linked data
 * structures. This particular class focuses on a single linear linked
 * list, organized from left-to-right, in ascending index order.
 *
 * The time complexity of the structure can be extremely costly, as
 * there are multiple checks and cases that must be handled before a
 * change can be made.
 *
 * @author J. Smith, Joel Strand
 * @version 1.0.5
 * @date 5th October 2021.
 */

public class SingleLinkedList implements ListInterface {

    private Node front;
    private int numElements;

    /**
     * Creates an empty LinkedList
     *
     * Worst Case Time Complexity: Constant Time - O(1)
     */
    public SingleLinkedList() {
        front = null;
        numElements = 0;
    }

    /**
     * Adds item to the end of the list.
     * Allows duplicates of items.
     * Does not allow null items.
     *
     * Worst Case Time Complexity: Constant Time - O(1)
     *
     * @param element Object, null
     * @return true, IllegalArgumentException
     */
    @Override
    public boolean add(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot manually add a null node");
        }

        Node newNode = new Node(element);

        // Handle Empty List Case
        if (numElements == 0) {
            this.front = new Node(element);
        } else {
            Node before = getNode(numElements - 1);
            before.setNext(newNode);
        }
        numElements++;
        return true;
    }

    /**
     * Adds item at specified index position.
     * Allows duplicates of items.
     * Does not allow null items.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @param index   (0 <= index < numElements), (index > numElements), (index < 0)
     * @param element Object
     * @return true, IllegalArgumentException, IllegalArgumentException
     */
    @Override
    public boolean add(int index, Object element) {
        if (index > numElements || index < 0) {
            throw new IllegalArgumentException("Cannot insert at index " + index + ", Out Of Bounds.");
        } else if (element == null) {
            throw new IllegalArgumentException("Cannot manually add a null node");
        }

        Node ptr = new Node(element);

        // Handle edge case
        // front = ptr, ptr points to old front.
        if (index == 0) {
            Node second = this.front;
            this.front = ptr;
            ptr.setNext(second);
            numElements++;
            return true;
        }

        // Find the node before insertion index
        Node before = getNode(index - 1);

        // Handle edge case
        if (index == numElements) {
            before.setNext(ptr);
            numElements++;
            return true;
        }

        // Node that will be after the new node's insertion.
        Node after = before.getNext();

        // Link before to new, new to after.
        before.setNext(ptr);
        ptr.setNext(after);
        numElements++;
        return true;
    }

    /**
     * Removes every object in the list.
     * List becomes empty.
     *
     * Worst Case Time Complexity: Exponential - O(n^3) (yikes)
     * ^ (get() inside of remove(int index) can be performed twice, leading to the same linear process being performed twice.
     */
    @Override
    public void clear() {
        int counter = 0;
        // Iterate through entire list, remove every object.
        while (counter <= numElements - 1) {
            remove(0);
        }
        numElements = 0;
    }

    /**
     * Uses indexOf() to determine if the list contains the element.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @param element objectInList, objectNotInList, null
     * @return true, false, IllegalArgumentException
     */
    @Override
    public boolean contains(Object element) {
        // Returns a boolean dependent on result of indexOf(element)
        return indexOf(element) != -1;
    }

    /**
     * Iterates over the list,
     * Returns the data of node found.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @param index objectInList, objectNotInList, (index > numElements - 1), (index < 0)
     * @return Object, null, IllegalArgumentException, IllegalArgumentException
     */
    @Override
    public Object get(int index) {
        if (index > numElements - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Cannot get at index " + index + ", Out Of Bounds.");
        }

        Node ptr = this.front;
        int counter = 0;

        // Iterate over whole list
        while (ptr.getNext() != null) {
            if (counter == index) {
                // When counter ==  index requested,
                // return the Object at that index.
                return ptr.getValue();
            } else {
                // Continue iterating
                ptr = ptr.getNext();
                counter++;
            }
        }
        return ptr.getValue();
    }

    /**
     * Iterates over the list,
     * Returns the counter (index position) when the Object is found.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @param element objectInList, objectNotInList, null
     * @return counter, -1, IllegalArgumentException
     */
    @Override
    public int indexOf(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("Null elements are not contained in the list.");
        }
        // Checks first edge.
        if (this.front == null) {
            return -1;
        } else if (this.front.getValue().equals(element)) {
            return 0;
        }

        Node ptr = this.front;
        int counter = 0;

        while (ptr.getNext() != null) {
            if (ptr.getValue().equals(element)) {
                return counter;
            }
            ptr = ptr.getNext();
            counter++;
        }
        if (ptr.getValue().equals(element)) {
            return counter;
        }
        return -1;
    }

    /**
     * Returns the total amount of elements in the list minus 1.
     *
     * Worst Case Time Complexity: Constant Time - O(1)
     *
     * @param element emptyList, listOf100Items, null
     * @return 0, 99, IllegalArgumentException
     */
    @Override
    public int lastIndexOf(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot find last index of a null element.");
        }

        // Handle empty list case
        if (numElements == 0) {
            return -1;
        }
        return numElements - 1;
    }

    /**
     * Calls back to remove(int index)
     * ^ for overall simplicity
     *
     * Worst Case Time Complexity: Quadratic - O(n^2)
     * ^ (get() inside of remove(int index) can be performed twice, leading to the same linear process being performed twice.
     *
     * @param element ObjectInList, ObjectNotInList, null
     * @return true, false, IllegalArgumentException
     */
    @Override
    public boolean remove(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("No null objects exist in this list.");
        }

        // Handle element not existing
        if (indexOf(element) == -1) {
            return false;
        }

        // Call to other remove method
        remove(indexOf(element));
        return true;
    }

    /**
     * Sequentially deduces where item is in the list
     * Then sets the previous node to the node after the node that is being removed
     *
     * Worst Case Time Complexity: Quadratic - O(n^2)
     * ^ (get() inside of remove(int index) can be performed twice, leading to the same linear process being performed twice.
     *
     * @param index objectInList, objectNotInList, (index > numElements - 1), (index < 0)
     * @return Object, IllegalArgumentException, IllegalArgumentException, IllegalArgumentException
     */
    @Override
    public Object remove(int index) {
        if (index > numElements - 1 || index < 0) {
            throw new IllegalArgumentException("Cannot remove at index " + index + ", Out Of Bounds.");
        }

        Node ptr = getNode(index);

        // Handle edge case
        if (index == 0) {
            if (ptr.getNext() == null) {
                this.front = null;
                numElements = 0;
                return ptr.getValue();
            }

            this.front = ptr.getNext();
            numElements--;
            return ptr.getValue();
        }

        // Node before the node that's being removed.
        Node before = getNode(index - 1);

        if (ptr.getNext() == null) {
            before.setNext(null);
            numElements--;
            return ptr.getValue();
        }

        // Node after the node that's being removed.
        Node after = getNode(index + 1);

        // Link before to after
        before.setNext(after);
        numElements--;
        return ptr.getValue();
    }

    /**
     * Finds Node at provided index, sets the data of the node to Object element.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @param index   (0 < index < numElements), (index > numElements), (index < 0)
     * @param element Object, null
     * @return (1, 1) true, (1, 2) IllegalArgumentException, (2, 1) IllegalArgumentException, (2,2) IllegalArgumentException
     * (3, 1) IllegalArgumentException, (3, 2) IllegalArgumentException
     */
    @Override
    public Object set(int index, Object element) {
        if (index > numElements - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Cannot insert at index " + index + ", Out Of Bounds.");
        } else if (element == null) {
            throw new IllegalArgumentException("Cannot manually set a null node");
        }

        // Get the node, set its value to element.
        Node ptr = getNode(index);
        ptr.setValue(element);
        return ptr.getValue();
    }

    /**
     * Returns the total amount of elements in the list
     * NullPointer not included.
     *
     * Worst Case Time Complexity: Constant - O(1)
     *
     * @return numElements
     */
    @Override
    public int size() {
        // Return # of elements in the list.
        return this.numElements;
    }

    /**
     * Iterates over the whole LinkedList, concatenating each element to a string
     * which is then returned after the iteration process.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * @return "[ele 1, ele 2, ... ele numElements -1]"
     */
    public String toString() {
        Node ptr = this.front;
        String s = "[";
        if (ptr == null) {
            return "[]";
        }

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
     * Helper Method
     *
     * Same process as get(), except this returns the node rather than
     * the node's data.
     *
     * Worst Case Time Complexity: Linear - O(n)
     *
     * pre: numElements > 0, 0 <= index < numElements
     *
     * @param index objectNotInList, (index > numElements - 1), (index < 0)
     * @return Object, null, IllegalArgumentException, IllegalArgumentException
     */
    private Node getNode(int index) {
        Node ptr = this.front;
        int counter = 0;

        // Iterate over whole list
        while (ptr.getNext() != null) {
            if (counter == index) {
                // When counter ==  index requested,
                // return the Object at that index.
                return ptr;
            } else {
                // Continue iterating
                ptr = ptr.getNext();
                counter++;
            }
        }
        return ptr;
    }
}
