package gfa.inquiry.SingleLinkedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class Test.
 *
 * @author  Zoma T
 * @version 9/21/21
 */
public class LinkedTest
{
    /**
     * Default constructor for test class Test
     */
    public LinkedTest()
    {
    }

    @Test
    public void constructorTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        assertEquals(0, list.size());
    }
    
    @Test
    public void addTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        assertEquals(true, list.add(5.5));
    }
    
    @Test
    public void length1Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(9.3);
        assertEquals(1, list.size());
    }
    
     @Test
    public void length2Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(9.3);
        list.add("Hello");
        assertEquals(2, list.size());
    }
    
    @Test
    public void length3Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        list.add("test");
        list.add(7.7);
        assertEquals(3, list.size());
    }
    
    @Test
    public void length4Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(4);
        list.add(6.6);
        list.add(7.7);
        list.add("test");
        assertEquals(4, list.size());
    }
    
    @Test
    public void length5Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        list.add(4);
        list.add("string");
        int[] array = new int[]{4,5,6};
        list.add(array);
        list.add(8.0);
        assertEquals(5, list.size());
    }

    @Test
    public void indexOf0Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        assertEquals(-1, list.indexOf(5.5));
    }
    
    @Test
    public void indexOf1Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        assertEquals(0, list.indexOf(5.5));
    }
    
    @Test
    public void indexOf2Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(6.6);
        list.add(5.5);
        assertEquals(0, list.indexOf(6.6));
        assertEquals(1, list.indexOf(5.5));
    }
    
    @Test
    public void indexOfEndTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(6.6);
        list.add(5.5);
        list.add(7.7);
        list.add("test");
        assertEquals(0, list.indexOf(6.6));
        assertEquals(1, list.indexOf(5.5));
        assertEquals(2, list.indexOf(7.7));
        assertEquals(3, list.indexOf("test"));
    }

    @Test
    public void lastIndexOf0Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        assertEquals(-1, list.lastIndexOf(5.5));
    }
    
    @Test
    public void lastIndexOf1Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        assertEquals(0, list.lastIndexOf(5.5));
    }
    
    @Test
    public void lastIndexOf2Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(6.6);
        list.add(5.5);
        assertEquals(1, list.lastIndexOf(5.5));
    }
    
    @Test
    public void lastIndexOf2AgainTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        list.add(5.5);
        assertEquals(1, list.lastIndexOf(5.5));
    }
    
    @Test
    public void lastIndexOf2AgainAgainTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        list.add(6.6);
        assertEquals(0, list.lastIndexOf(5.5));
    }

    @Test
    public void lastIndexOfEndTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        list.add(6.6);
        list.add(5.5);
        list.add(7.7);
        assertEquals(2, list.lastIndexOf(5.5));
    }
    
    @Test
    public void lastIndexOfEpicTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        list.add(6.6);
        list.add(5.5);
        list.add(7.7);
        assertEquals(2, list.lastIndexOf(5.5));
        assertEquals(1, list.lastIndexOf(6.6));
        list.remove(7.7);
        assertEquals(-1, list.lastIndexOf(7.7));
        assertEquals(1, list.lastIndexOf(6.6));
    }

    @Test
    public void contains0Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        assertEquals(false, list.contains(5.5));
    }
    
    @Test
    public void contains1FalseTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(4.4);
        assertEquals(false, list.contains(5.5));
    }
    
    @Test
    public void contains1TrueTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        assertEquals(true, list.contains(5.5));
    }
    
    @Test
    public void containsEndTrueTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        list.add(6.6);
        list.add(7.7);
        list.add(5.5);
        assertEquals(true, list.contains(7.7));
    }
    
    @Test
    public void containsEndFalseTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        list.add(6.6);
        list.add(7.7);
        list.add(5.5);
        assertEquals(false, list.contains(4.4));
    }
    
    @Test
    public void clear0Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.clear();
        assertEquals(0, list.size());
    }
    
    @Test
    public void clear1Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        list.clear();
        assertEquals(0, list.size());
    }
    
    @Test
    public void clearEndTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        list.add(6.6);
        list.add(7.7);
        list.add(5.5);
        list.clear();
        assertEquals(0, list.size());
    }
    
    @Test
    public void get0Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        boolean success = false;
        try {
            Object ob = list.get(0);
        }
        catch (IndexOutOfBoundsException exc)
        {
            success = true;
        }
        assertEquals(true, success);
    }
    
    @Test
    public void get1ErrorTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        boolean success = false;
        try {
            list.get(1);
        }
        catch (IndexOutOfBoundsException exc)
        {
            success = true;
        }
        assertEquals(true, success);
    }
    
    @Test
    public void get1Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        assertEquals(5.5, list.get(0));
    }
    
    @Test
    public void get2Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(4.4);
        list.add(5.5);
        assertEquals(5.5, list.get(1));
    }
    
    @Test
    public void addIndex0Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(0, 5.5);
        assertEquals(1, list.size());
        assertEquals("[5.5]", list.toString());
    }
    
    @Test
    public void addIndex1Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.4);
        list.add(1, 5.5);
        assertEquals(2, list.size());
        assertEquals("[5.4, 5.5]", list.toString());
    }
    
    @Test
    public void addIndex2Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.3);
        list.add(5.4);
        list.add(1, 5.5);
        assertEquals(3, list.size());
        assertEquals("[5.3, 5.5, 5.4]", list.toString());
    }
    
    @Test
    public void addIndexEndTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.1);
        list.add(5.2);
        list.add(5.3);
        list.add(5.4);
        list.add(1, 5.5);
        assertEquals(5, list.size());
        assertEquals("[5.1, 5.5, 5.2, 5.3, 5.4]", list.toString());
    }
    
    @Test
    public void toString0Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        assertEquals("[]", list.toString());
    }
    
    @Test
    public void toString1Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        assertEquals("[5.5]", list.toString());
    }
    
    @Test
    public void toString2Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.4);
        list.add(5.5);
        assertEquals("[5.4, 5.5]", list.toString());
    }
    
    @Test
    public void toStringEndTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.3);
        list.add(5.4);
        list.add(5.5);
        assertEquals("[5.3, 5.4, 5.5]", list.toString());
    }
    
    @Test
    public void remove0Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        assertEquals(false, list.remove(5.5));
    }
    
    @Test
    public void remove1FalseTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.3);
        assertEquals(false, list.remove(5.5));
        assertEquals(1, list.size());
        assertEquals("[5.3]", list.toString());
    }
    
    @Test
    public void remove1TrueTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        assertEquals(true, list.remove(5.5));
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }
    
    @Test
    public void remove2Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.4);
        list.add(5.5);
        assertEquals(true, list.remove(5.5));
        assertEquals(1, list.size());
        assertEquals("[5.4]", list.toString());
    }
    
    @Test
    public void removeEndTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.4);
        list.add(5.5);
        list.add(5.6);
        list.add(5.7);
        list.add(5.8);
        assertEquals(true, list.remove(5.5));
        assertEquals(4, list.size());
        assertEquals("[5.4, 5.6, 5.7, 5.8]", list.toString());
    }
    
    @Test
    public void removeIndexErrorTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        boolean success = false;
        try {
            list.remove(5);
        }
        catch (IndexOutOfBoundsException exc) {
            success = true;
        }
        
        assertEquals(true, success);
    }
    
    @Test
    public void removeIndex0ErrorTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        boolean success = false;
        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException exc) {
            success = true;
        }
        
        assertEquals(true, success);
    }
    
    @Test
    public void removeIndex1Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        Object removed = list.remove(0);
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
        assertEquals(5.5, removed);
    }
    
    @Test
    public void removeIndex2Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        list.add(5.6);
        Object removed = list.remove(0);
        assertEquals(1, list.size());
        assertEquals("[5.6]", list.toString());
        assertEquals(5.5, removed);
    }
    
    @Test
    public void removeIndexEndTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.4);
        list.add(5.5);
        list.add(5.6);
        list.add(5.7);
        list.add(5.8);
        Object removed = list.remove(1);
        assertEquals(4, list.size());
        assertEquals("[5.4, 5.6, 5.7, 5.8]", list.toString());
        assertEquals(5.5, removed);
    }
    
    @Test
    public void setErrorTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        boolean success = false;
        try {
            list.set(0, 5.5);
        }
        catch (IndexOutOfBoundsException exc) {
            success = true;
        }
        assertEquals(true, success);
    }
    
    @Test
    public void set1Test()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.5);
        Object removed = list.set(0, 5.6);
        assertEquals(5.5, removed);
        assertEquals(1, list.size());
        assertEquals("[5.6]", list.toString());
    }
    
    @Test
    public void setEndTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(5.4);
        list.add(5.5);
        list.add(5.6);
        list.add(5.7);
        Object removed = list.set(1, 5.6);
        assertEquals(5.5, removed);
        assertEquals(4, list.size());
        assertEquals("[5.4, 5.6, 5.6, 5.7]", list.toString());
    }
    
    @Test
    public void stressTest()
    {
        SingleLinkedList list = new SingleLinkedList();
        ArrayList<Integer> myArray1 = new ArrayList<Integer>();
        for (int i=0; i<1000; i++) {
            list.add(i); // new Double(i)
            myArray1.add(i);
        }
        //System.out.println("finished contructing");
        
        for (int i=1; i<1000; i*=2) {
            //System.out.println(i);
            list.set(i, 0);
            myArray1.set(i, 0);
        }
        //System.out.println("finished setting");
        
        for (int i=0; i<list.size(); i*=3) {
            list.remove(i);
            myArray1.remove(i);
        }
        
        boolean success = true;
        for (int i=0; i<list.size(); i++) {
            if (!list.get(i).equals(myArray1.get(i))) {
                success = false;
                break;
            }
        }
        //System.out.println("finished searching");
        
        assertEquals(list.size(), myArray1.size());
        assertEquals(true, success);
    }
}








