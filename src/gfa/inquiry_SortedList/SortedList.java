package gfa.inquiry_SortedList;

/**
 * @author Joel Strand
 * @version 1.0.2
 * @date 9/13/2021
 */

public class SortedList implements ListInterface {

    private String[] stringArr;
    private int numElements;


    // Constructor
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
            stringArr = expandArray(stringArr, numElements * 2);
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
        stringArr = new String[1];
        numElements = 0;
        stringArr = shrinkArray(stringArr, 1);
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
    public boolean remove(Object var1) {
        if (contains(var1)) {
            for (int i = indexOf(var1); i < stringArr.length - 1; i++) {
                stringArr[i] = stringArr[i + 1];
            }

            numElements--;
            if (numElements < stringArr.length / 2) {
                stringArr = shrinkArray(stringArr, stringArr.length / 2);
            }
            return true;
        }
        return false;
    }

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
            if (numElements < stringArr.length / 2) {
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
        return this.numElements;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < numElements; i++) {
            String temp = stringArr[i];
            if (i == numElements -1) {
                result = result + temp;
            } else {
                result = result + temp + ", ";
            }
        }
        return result + "]";
    }

    private static String[] expandArray(String[] oldArray, int newSize) {
        String[] tempArr = new String[newSize];
        for (int i = 0; i < oldArray.length; i++) {
            String temp = oldArray[i];
            tempArr[i] = temp;
        }
        return tempArr;
    }

    private static String[] shrinkArray(String[] oldArray, int newSize) {
        String[] tempArr = new String[newSize];
        if (newSize > 1) {
            for (int i = 0; i < newSize; i++) {
                tempArr[i] = oldArray[i];
            }
        }
        return tempArr;
    }
}
