package gfa.inquiry_LinkedList;

/**
 * class SingleLinkedList is
 * a first experiment  working with linked
 * structures - the most simple option is a
 * single link -- also costly! Watch the big-O!
 * 
 * To do: 9/28 week
 * for each method:
 *    - comment on Big O
 *    - implement all methods
 *    - throw appropriate exceptions
 *    - toString should look like ArrayList output
 *      that is [e1, e2,.. en]
 *      
 *    Unit test is coming
 *
 * @author J. Smith, Joel Strand
 * @version 1.0.1
 */
public class SingleLinkedList implements ListInterface
{
    private Node front;
    private int numElements;

    /**
     * create an empty list
     */
    public SingleLinkedList()
    {
        front = null;
        numElements = 0;
    }

    /*
     * Adds' behavior is to add elements
     * at the end of the list
     */

    // Allows Duplication
    @Override
    public boolean add(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot manually add a null node");
        }

        Node newNode = new Node(element);

        if (numElements == 0) {
            front = new Node(element);
        } else {
            Node before = (Node) get(lastIndexOf(element));
            before.setNext(newNode);
        }
        numElements++;
        return true;
    }

    // Allows Duplication
    @Override
    public boolean add(int index, Object element) {
        if (index > numElements || index < 0) {
            throw new IllegalArgumentException("Cannot insert at index " + index + ", Out Of Bounds.");
        } else if (element == null) {
            throw new IllegalArgumentException("Cannot manually add a null node");
        }

        Node ptr = new Node(element);

        // If Index is 0, make front = the new node, then link the new front to the old front.
        if (index == 0) {
            Node second = this.front;
            this.front = ptr;
            ptr.setNext(second);
            numElements++;
            return true;
        }

        Node before = (Node) get(index - 1);

        if (index == numElements) {
            before.setNext(ptr);
            numElements++;
            return true;
        }

        Node after = before.getNext();

        before.setNext(ptr);
        ptr.setNext(after);
        numElements++;
        return true;
    }

    @Override
    public void clear() {
        Node ptr = this.front;
        int counter = 0;

        while (counter <= numElements - 1) {
            remove(0);
        }
        numElements = 0;
    }

    @Override
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    @Override
    public Object get(int index) {
        if (index > numElements - 1 || index < 0) {
            throw new IllegalArgumentException("Cannot get at index " + index + ", Out Of Bounds.");
        }

        Node ptr = this.front;
        int counter = 0;

        while (ptr.getNext() != null) {
            if (counter == index) {
                return ptr;
            } else {
                ptr = ptr.getNext();
                counter++;
            }
        }
        return ptr;
    }

    @Override
    public int indexOf(Object element) {
        Node ptr = this.front;
        int counter = 0;

        while (ptr.getNext() != null) {
            if (ptr.getValue() == element) {
                return counter;
            } else {
                ptr = ptr.getNext();
                counter++;
            }
        }
        if (ptr.getValue() == element) {
            return counter;
        } else {
            return -1;
        }
    }

    @Override
    public int lastIndexOf(Object element) {
        return numElements - 1;
    }

    @Override
    public boolean remove(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("No null objects exist in this list.");
        }

        if (indexOf(element) == -1) {
            return false;
        }

        remove(indexOf(element));
        numElements--;
        return true;
    }

    @Override
    public Object remove(int index) {
        if (index > numElements - 1 || index < 0) {
            throw new IllegalArgumentException("Cannot remove at index " + index + ", Out Of Bounds.");
        }

        Node ptr = (Node) get(index);

        if (index == 0) {
            if (ptr.getNext() == null) {
                this.front = new Node();
                numElements--;
                return ptr;
            }
            this.front = ptr.getNext();
            numElements--;
            return ptr;
        }

        Node before = (Node) get(index - 1);

        if (ptr.getNext() == null) {
            before.setNext(null);
            numElements--;
            return ptr;
        }

        Node after = (Node) get(index + 1);

        before.setNext(after);
        numElements--;
        return ptr;
    }

    @Override
    public Object set(int index, Object element) {
        if (index > numElements - 1 || index < 0) {
            throw new IllegalArgumentException("Cannot insert at index " + index + ", Out Of Bounds.");
        } else if (element == null) {
            throw new IllegalArgumentException("Cannot manually set a null node");
        }

        Node ptr = (Node) get(index);
        ptr.setValue(element);
        return ptr;
    }

    @Override
    public int size () {
        return this.numElements;
    }

    @Override
    public void print() {
        System.out.println(sllToString());
    }

    private String sllToString() {
        Node ptr = this.front;
        String s = "[";
        while (ptr.getNext() != null) {
            Object temp = ptr.getValue();
            s = s.concat(temp + ", ");
            ptr = ptr.getNext();
        }
        if (ptr.getValue() == null) {
            s = s.concat("]");
            return s;
        }
        s = s.concat(ptr.getValue() + "]");
        return s;
    }
}
