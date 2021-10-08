package gfa.inquiry.DoubleLinkedList;

/**
 * class Node represents
 * an element of a singly linked list
 * 
 * purpose:  explore a linked structure
 *
 * @author J. Smith, Joel Strand
 * @version 1.0.2
 */

public class Node {

    private Object data;
    private Node nextLink;
    private Node prevLink;

    /**
     * Constructor for objects of class Node
     */
    public Node() {
        this.data = null;
        this.nextLink = null;
        this.prevLink = null;
    }
    
    public Node(Object element, Node nextLink) {
        this.data = element;
        this.nextLink = nextLink;
    }
    
    public Node(Object element) {
        this.data = element;
        this.nextLink = null;
        this.prevLink = null;
    }
    
    public Object getValue() {
        return data;
    }
    
    public Node getNext() {
        return nextLink;
    }

    public Node getPrevious() {
        return prevLink;
    }

    public void setValue(Object replace) {
        this.data = replace;
    }
    
    public void setNext(Node next) {
        this.nextLink = next;
    }

    public void setPrevious(Node prevLink) {
        this.prevLink = prevLink;
    }
}
