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
 * @version 1.0.1
 * @date 9/13/2021
 */
// opt + enter for test class.

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
        String var1String = (String) var1;

        // If object is not a String
        if (var1 == null) {
            throw new IllegalArgumentException("Strings Only.");
        } else if (stringArr[0] == null) {
                stringArr[0] = var1String;
                numElements++;
                return true;
        } else if (contains(var1)) {
            // Already contains the item, so return false as no operation was performed.
            return false;
        }

        // If array expansion is needed
        if (stringArr.length == numElements) {
            stringArr = resizeArray(stringArr, numElements * 2);
        }

        // Add Item
        stringArr[numElements] = var1String;
        numElements++;
        String temp = "";

        // Sort the Array
        for (int i = 0; i < stringArr.length - 1; i++) {
            for (int x = i+1; x < stringArr.length; x++) {
                if (stringArr[x] == null) {
                    break;
                }
                if (stringArr[i].compareToIgnoreCase(stringArr[x]) > 0) {
                    temp = stringArr[i];
                    stringArr[i] = stringArr[x];
                    stringArr[x] = temp;
                }
            }
        }
        return true;
    }

    @Override
    public void add(int var1, Object var2) {
        throw new IllegalArgumentException("Sorted lists do not allow manual precision insertion");
    }

    @Override
    public void clear() {

        for (int i = 0; i < numElements; i++) {
            remove(i);
        }
        numElements = 0;                                    // Reset numElements.
    }

    @Override
    public boolean contains(Object var1) {
        if (var1 == null) {
            return false;
        }
        if (!(var1 instanceof String)) {
            throw new IllegalArgumentException("Must be a string.");
        }

        String stringVar = (String) var1;
        for (int i = 0; i < numElements; i++) {
            String temp = stringArr[i];
            if (stringVar.compareToIgnoreCase(temp) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int var1) {
        if (var1 > numElements - 1 || var1 < 0) {
            throw new ArrayIndexOutOfBoundsException("Please reference an inbound index position.");
        }
        return stringArr[var1];
    }

    @Override
    public int indexOf(Object var1) {
        if (!(var1 instanceof String)) {
            throw new IllegalArgumentException("Object supplied needs to be a String");
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
        if (!(var1 instanceof Object[])) {
            throw new IllegalArgumentException("Cannot find lastIndexOf if an array is not passed to method.");
        }
        Object[] var1Arr = (Object[]) var1;
        int finalIndex = 0;
        for (int i = 0; i < var1Arr.length; i++) {
            if (var1Arr[i] == null) {
                finalIndex = i - 1;
                break;
            }
        }
        return finalIndex;
    }

    @Override
    public boolean remove(Object var1) {
        if (contains(var1)) {
            // Starts at Index of Object to be Removed. Sets the next object to the current index, effectively removing object.
            for (int i = indexOf(var1); i < stringArr.length - 1; i++) {
                stringArr[i] = stringArr[i+1];
            }
            numElements--;
            return true;
        }
        return false;
    }

    // Why return the object if its been removed?
    @Override
    public Object remove(int var1) {
        if (var1 > numElements - 1 || var1 < 0) {
            throw new ArrayIndexOutOfBoundsException("Please reference an inbound index position.");
        } else {
            Object objectToReturn = stringArr[var1];
            for (int i = var1; i < stringArr.length - 1; i++) {
                stringArr[i] = stringArr[i + 1];
            }
            numElements--;
            if (numElements <= stringArr.length / 2) {
                stringArr = shrinkArray(stringArr, stringArr.length / 2);
            }
            return objectToReturn;
        }
    }

    @Override
    public Object set(int var1, Object var2) {
        throw new IllegalArgumentException("Sorted lists do not allow manual precision insertion");
    }

    @Override
    public int size() {
//        return this.numElements;
        return this.stringArr.length;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < numElements; i++) {
            String temp = stringArr[i];
            if (i == numElements -1) {
                result = result + temp;
            }else {
                result = result + temp + ',';
            }
        }
        return result + "]";
    }

    private static String[] resizeArray(String[] oldArray, int newSize) {
        String[] tempArr = new String[newSize];
        for (int i = 0; i < oldArray.length; i++) {
            String temp = oldArray[i];
            tempArr[i] = temp;
        }
        return tempArr;
    }

    private static String[] shrinkArray(String[] oldArray, int newSize) {
        // Figure out how to downsize old array
        return null;
    }
}
