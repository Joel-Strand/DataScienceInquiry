package gfa.inquiry_SortedList;

/**
 * class SortedStringList should create a sequential
 * list built from a primitive array that maintains 
 * alphabetically sorted Strings.
 * 
 * Realize the ListInterface interface
 * Supply a single constructor that creates an empty list.
 * throw an UnsupportedOperation exception for methods that can
 * not be supported by this type of list.
 * Supply a toString that shows the list from element 0 to size()

 * @author Joel Strand
 * @version 1.0.0
 * @date 9/13/2021
 */

public class SortedList implements ListInterface {

    private String[] stringArr;
    private int numElements;


    public SortedList() {
        // Creates Empty Array with a length of 1
        this.stringArr = new String[1];
        numElements = 0;
    }

    @Override
    public boolean add(Object var1) {
        // If object is not a String
        if (!(var1 instanceof String)) {
            throw new IllegalArgumentException("Strings Only.");
        }

        // If array expansion is needed
        if (stringArr.length == numElements) {
            stringArr = resizeArray(stringArr, numElements * 2);
        }



        return false;
    }

    @Override
    public void add(int var1, Object var2) {

    }

    @Override
    public void clear() {
        this.stringArr = new String[1];
    }

    @Override
    public boolean contains(Object var1) {
        for (Object temp : stringArr) {
            if (var1 == temp) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int var1) {
        return stringArr[var1];
    }

    @Override
    public int indexOf(Object var1) {
        if (!(var1 instanceof String[])) {
            throw new IllegalArgumentException("Object supplied needs to be a Primitive String[]");
        }

        for (int i = 0; i < stringArr.length; i++) {
            Object temp = stringArr[i];
            if (temp == var1) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object var1) {
        return 0;
    }

    @Override
    public boolean remove(Object var1) {
        return false;
    }

    @Override
    public Object remove(int var1) {
        return null;
    }

    @Override
    public Object set(int var1, Object var2) {
        return null;
    }

    @Override
    public int size() {
        return this.numElements;
    }

    private static String[] resizeArray(String[] oldArray, int newSize) {
        String[] tempArr = new String[newSize];
        for (int i = 0; i < oldArray.length; i++) {
            String temp = oldArray[i];
            tempArr[i] = temp;
        }

        return tempArr;
    }
}

    //instanceof
    // if (! (element instanceof String))
            //throw new IllegalArgumentException(");
//
