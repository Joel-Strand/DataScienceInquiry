package gfa.inquiry_LinkedList;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Copy;

public class DoubleLinkedList implements ListInterface {

    private Node front;
    private Node last;
    private int numElements;

    public DoubleLinkedList() {
        this.front = null;
        this.last = null;
        numElements = 0;
    }

    @Override
    public boolean add(Object element) {
        if (element == null) throw new IllegalArgumentException("Cannot manually insert null nodes.");

        Node nodeToAdd = new Node(element);
        Node previous = this.last; // Copy Last Node

        if (numElements == 0) {
            this.front = nodeToAdd;
            this.last = nodeToAdd;
            numElements++;
            return true;
        }

        this.last.setNext(nodeToAdd);       // Add Final Node
        this.last = nodeToAdd;              // Set last to Final
        this.last.setPrevious(previous);    // link to the previous node
        previous.setNext(this.last);        // link to the last node

        numElements++;
        return true;

    }

    @Override
    public boolean add(int index, Object element) {
        return false;
    }

    @Override
    public void clear() {
        this.front = null;
        this.last = null;
    }

    @Override
    public boolean contains(Object element) {
        return false;
    }

    @Override
    public Object get(int index) {
        if (index > numElements - 1 || index < 0) throw new IndexOutOfBoundsException("Cannot get at index " + index + ", Out Of Bounds.");

        Node ptr = this.front;
        int counter = 0;

        if (index == numElements - 1) return this.last.getValue();

        while (ptr.getNext() != null) {
            if (counter == index) return ptr.getValue();
            ptr = ptr.getNext();
            counter++;
        }
        return null;
    }

    @Override
    public int indexOf(Object element) {
        Node ptr = this.front;
        int counter = 0;

        if (front == null) return -1;
        else if (this.front.getValue().equals(ptr)) return 0;

        while (ptr.getNext() != null) {
            if (ptr.getValue().equals(ptr)) return counter;
            ptr = ptr.getNext();
            counter++;
        }
        if (ptr.getValue().equals(ptr)) return counter;

        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        return 0;
    }

    @Override
    public boolean remove(Object element) {
        return false;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

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
