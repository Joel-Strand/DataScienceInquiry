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
public class Node
{
    private Object data;
    private Node link;

    /**
     * Constructor for objects of class Node
     */
    public Node() {
        data = null;
        link = null;
    }
    
    public Node (Object element, Node nextLink) {
        data = element;
        link = nextLink;
    }
    
    public Node (Object element) {
        data = element;
        link = null;
    }
    
    public Object getValue() {
        return data;
    }
    
    public Node getNext () {
        return link;
    }
    
    public void setValue(Object replace) {
        data = replace;
    }
    
    public void setNext(Node next) {
        link = next;
    }
}
