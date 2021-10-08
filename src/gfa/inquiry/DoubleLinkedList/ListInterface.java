package gfa.inquiry.DoubleLinkedList;

/**
 * ListInterface is a light version
 * of the Java API List interface
 * 
 * - it uses Object rather than template class syntax
 * - represents a subset of methods from the util List hierarchy
 * 
 * @author J. Smith
 * @version September 2021
 */
public interface ListInterface {
    boolean add(Object element);
    boolean add(int index, Object element);
    void clear();
    boolean contains(Object element);
    Object get(int index);
    int indexOf(Object element);
    int lastIndexOf(Object element);
    boolean remove(Object element);
    Object remove(int index);
    Object set(int index, Object element);
    int size();
    String toString();
}
