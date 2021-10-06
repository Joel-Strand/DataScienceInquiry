package gfa.inquiry_LinkedList;

/**
 * class Node represents
 * an element of a singly linked list
 * 
 * purpose:  explore a linked structure
 *
 * @author J. Smith
 * @version Sept. 2021
 */
public class Node {

    private Object data;
    private Node link;
    private Node previous;

    /**
     * Constructor for objects of class Node
     */
    public Node() {
        data = null;
        link = null;
        previous = null;
    }
    
    public Node(Object element, Node nextLink) {
        data = element;
        link = nextLink;
    }
    
    public Node(Object element) {
        data = element;
        link = null;
        previous = null;
    }
    
    public Object getValue() {
        return data;
    }
    
    public Node getNext() {
        return link;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setValue(Object replace) {
        data = replace;
    }
    
    public void setNext(Node next) {
        link = next;
    }

    public void setPrevious(Node prevLink) {
        previous = prevLink;
    }
}
