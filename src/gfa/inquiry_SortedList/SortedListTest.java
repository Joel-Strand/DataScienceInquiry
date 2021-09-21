package gfa.inquiry_SortedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class SortedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SortedListTest
{
    /**
     * Default constructor for test class SortedListTest
     */
    public SortedListTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
//    @Before
//    public void setUp()
//    {
//    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
//    @After
//    public void tearDown()
//    {
//    }

    @Test
    public void constructorTest()
    {
        SortedList mySortedList = new SortedList();
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }

    @Test
    public void add1ErrorTest()
    {
        SortedList mySortedList = new SortedList();
        boolean success = false;
        try {
            mySortedList.add(1);
        }
        catch (ClassCastException exc) {
            success = true;
        }
        assertEquals(true, success);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }

    @Test
    public void add1Test()
    {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        assertEquals(1, mySortedList.size());
        assertEquals("[Abba]", mySortedList.toString());
    }

    @Test
    public void add2ErrorTest()
    {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        boolean success = false;
        try {
            mySortedList.add(1);
        }
        catch (ClassCastException exc) {
            success = true;
        }
        assertEquals(true, success);
        assertEquals(1, mySortedList.size());
        assertEquals("[Abba]", mySortedList.toString());
    }

    @Test
    public void add2Test()
    {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        assertEquals(2, mySortedList.size());
        assertEquals("[a, Abba]", mySortedList.toString());
    }

    @Test
    public void add3Test()
    {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        mySortedList.add("ab");
        assertEquals(3, mySortedList.size());
        assertEquals("[a, ab, Abba]", mySortedList.toString());
    }

    @Test
    public void addEndTest()
    {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        mySortedList.add("ab");
        boolean addAgain = mySortedList.add("Abba");
        mySortedList.add("zebra");
        assertEquals(false, addAgain);
        assertEquals(4, mySortedList.size());
        assertEquals("[a, ab, Abba, zebra]", mySortedList.toString());
    }

    @Test
    public void addIndexErrorTest()
    {
        SortedList mySortedList = new SortedList();
        boolean success = false;
        try {
            mySortedList.add(4,"Abba");
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }

    @Test
    public void clear0Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.clear();
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }

    @Test
    public void clear1Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.clear();
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }

    @Test
    public void clear2Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("zebra");
        mySortedList.clear();
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }

    @Test
    public void clearEndTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("zebra");
        mySortedList.add("fish");
        mySortedList.clear();
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
        mySortedList.add("fish");
        assertEquals(1, mySortedList.size());
        assertEquals("[fish]", mySortedList.toString());
    }

    @Test
    public void contains0FalseTest() {
        SortedList mySortedList = new SortedList();
        boolean contains = mySortedList.contains("Abba");
        assertEquals(false, contains);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }

    @Test
    public void contains1FalseTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abb");
        boolean contains = mySortedList.contains("Abba");
        assertEquals(false, contains);
        assertEquals(1, mySortedList.size());
        assertEquals("[Abb]", mySortedList.toString());
    }

    @Test
    public void contains1TrueTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        boolean contains = mySortedList.contains("Abba");
        assertEquals(true, contains);
        assertEquals(1, mySortedList.size());
        assertEquals("[Abba]", mySortedList.toString());
    }

    @Test
    public void contains2FalseTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("zebra");
        boolean contains = mySortedList.contains("Abb");
        assertEquals(false, contains);
        assertEquals(2, mySortedList.size());
        assertEquals("[Abba, zebra]", mySortedList.toString());
    }

    @Test
    public void contains2TrueTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("zebra");
        boolean contains = mySortedList.contains("Abba");
        assertEquals(true, contains);
        assertEquals(2, mySortedList.size());
        assertEquals("[Abba, zebra]", mySortedList.toString());
    }

    @Test
    public void containsEndTrueTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("bat");
        mySortedList.add("fish");
        mySortedList.add("Zebra");
        mySortedList.add("zebra");
        boolean contains = mySortedList.contains("zebra");
        assertEquals(true, contains);
        assertEquals(4, mySortedList.size());
        assertEquals("[Abba, bat, fish, Zebra]", mySortedList.toString());
        //assertEquals(5, mySortedList.size());
        //assertEquals("[Abba, bat, fish, zebra, Zebra]", mySortedList.toString());
    }

    @Test
    public void containsEndFalseTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("bat");
        mySortedList.add("fish");
        mySortedList.add("Zebra");
        mySortedList.add("zebra");
        boolean contains = mySortedList.contains("zebr");
        assertEquals(false, contains);
        assertEquals(4, mySortedList.size());
        assertEquals("[Abba, bat, fish, Zebra]", mySortedList.toString());
        //assertEquals(5, mySortedList.size());
        //assertEquals("[Abba, bat, fish, zebra, Zebra]", mySortedList.toString());
    }

    @Test
    public void get0ErrorTest() {
        SortedList mySortedList = new SortedList();
        boolean success = false;
        try {
            mySortedList.get(0);
        }
        catch (ArrayIndexOutOfBoundsException exc) {
            success = true;
        }
        assertEquals(true, success);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }
    
    @Test
    public void get1ErrorTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        boolean success = false;
        try {
            mySortedList.get(1);
        }
        catch (ArrayIndexOutOfBoundsException exc) {
            success = true;
        }
        assertEquals(true, success);
        assertEquals(1, mySortedList.size());
        assertEquals("[Abba]", mySortedList.toString());
    }
    
    @Test
    public void get1Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        String index1 = (String)mySortedList.get(0);
        assertEquals("Abba", index1);
        assertEquals(1, mySortedList.size());
        assertEquals("[Abba]", mySortedList.toString());
    }
    
    @Test
    public void get2Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("zebra");
        String index1 = (String)mySortedList.get(0);
        assertEquals("Abba", index1);
        assertEquals(2, mySortedList.size());
        assertEquals("[Abba, zebra]", mySortedList.toString());
    }
    
    @Test
    public void getEndTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("bat");
        mySortedList.add("fish");
        mySortedList.add("Zebra");
        mySortedList.add("zebra");
        String index1 = (String)mySortedList.get(1);
        assertEquals("bat", index1);
        assertEquals(4, mySortedList.size());
        assertEquals("[Abba, bat, fish, Zebra]", mySortedList.toString());
        //assertEquals(5, mySortedList.size());
        //assertEquals("[Abba, bat, fish, zebra, Zebra]", mySortedList.toString());
    }
    
    @Test
    public void indexOf0ErrorTest() {
        SortedList mySortedList = new SortedList();
        boolean success = false;
        try {
            mySortedList.indexOf(1);
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }
    
    @Test
    public void indexOf0Test() {
        SortedList mySortedList = new SortedList();
        int index = mySortedList.indexOf("Abba");
        assertEquals(-1, index);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }
    
    @Test
    public void indexOf1ErrorTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        int index = mySortedList.indexOf("Abb");
        assertEquals(-1, index);
        assertEquals(1, mySortedList.size());
        assertEquals("[Abba]", mySortedList.toString());
    }
    
    @Test
    public void indexOf1Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        int index = mySortedList.indexOf("Abba");
        assertEquals(0, index);
        assertEquals(1, mySortedList.size());
        assertEquals("[Abba]", mySortedList.toString());
    }
    
    @Test
    public void indexOf2ErrorTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("fish");
        mySortedList.add("Abba");
        int index = mySortedList.indexOf("Abb");
        assertEquals(-1, index);
        assertEquals(2, mySortedList.size());
        assertEquals("[Abba, fish]", mySortedList.toString());
    }
    
    @Test
    public void indexOf2Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("fish");
        mySortedList.add("Abba");
        int index = mySortedList.indexOf("Abba");
        assertEquals(0, index);
        assertEquals(2, mySortedList.size());
        assertEquals("[Abba, fish]", mySortedList.toString());
    }
    
    @Test
    public void indexOfEndTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("bat");
        mySortedList.add("fish");
        mySortedList.add("Zebra");
        mySortedList.add("a");
        int index = mySortedList.indexOf("Abba");
        assertEquals(1, index);
        assertEquals(5, mySortedList.size());
        assertEquals("[a, Abba, bat, fish, Zebra]", mySortedList.toString());
    }
    
    @Test
    public void lastIndexOf0Test() {
        SortedList mySortedList = new SortedList();
        int index = mySortedList.lastIndexOf("Abba");
        assertEquals(-1, index);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }
    
    @Test
    public void lastIndexOf0ErrorTest() {
        SortedList mySortedList = new SortedList();
        boolean success = false;
        try {
            mySortedList.lastIndexOf(1);
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }
    
    @Test
    public void lastIndexOf1Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        int index = mySortedList.indexOf("Abba");
        assertEquals(0, index);
        assertEquals(1, mySortedList.size());
        assertEquals("[Abba]", mySortedList.toString());
    }
    
    @Test
    public void lastIndexOf1ErrorTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        int index = mySortedList.indexOf("Abb");
        assertEquals(-1, index);
        assertEquals(1, mySortedList.size());
        assertEquals("[Abba]", mySortedList.toString());
    }
    
    @Test
    public void lastIndexOf2Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("fish");
        mySortedList.add("Abba");
        int index = mySortedList.indexOf("Abba");
        assertEquals(0, index);
        assertEquals(2, mySortedList.size());
        assertEquals("[Abba, fish]", mySortedList.toString());
    }
    
    @Test
    public void lastIndexOf2ErrorTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("fish");
        mySortedList.add("Abba");
        int index = mySortedList.indexOf("Abb");
        assertEquals(-1, index);
        assertEquals(2, mySortedList.size());
        assertEquals("[Abba, fish]", mySortedList.toString());
    }
    
    @Test
    public void remove0ErrorTest() {
        SortedList mySortedList = new SortedList();
        boolean success = false;
        try {
            mySortedList.remove(2.2);
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }
    
    @Test
    public void remove0FalseTest() {
        SortedList mySortedList = new SortedList();
        boolean removed = mySortedList.remove("Abba");
        assertEquals(false, removed);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }
    
    @Test
    public void remove1FalseTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("a");
        boolean removed = mySortedList.remove("Abba");
        assertEquals(false, removed);
        assertEquals(1, mySortedList.size());
        assertEquals("[a]", mySortedList.toString());
    }
    
    @Test
    public void remove1TrueTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("a");
        boolean removed = mySortedList.remove("a");
        assertEquals(false, removed);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }
    
    @Test
    public void remove2FalseTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        boolean removed = mySortedList.remove("ab");
        assertEquals(false, removed);
        assertEquals(2, mySortedList.size());
        assertEquals("[a, Abba]", mySortedList.toString());
    }

    // Fix This
    @Test
    public void remove2TrueTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        boolean removed = mySortedList.remove("a");
        assertEquals(true, removed);
        assertEquals(1, mySortedList.size());
        assertEquals("[Abba]", mySortedList.toString());
    }
    
    @Test
    public void removeEndFalseTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        mySortedList.add("zebra");
        mySortedList.add("fish");
        mySortedList.add("bat");
        boolean removed = mySortedList.remove("ab");
        assertEquals(false, removed);
        assertEquals(5, mySortedList.size());
        assertEquals("[a, Abba, bat, fish, zebra]", mySortedList.toString());
    }
    
    @Test
    public void removeEndTrueTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        mySortedList.add("zebra");
        mySortedList.add("fish");
        mySortedList.add("bat");
        boolean removed = mySortedList.remove("a");
        assertEquals(true, removed);
        assertEquals(4, mySortedList.size());
        assertEquals("[Abba, bat, fish, zebra]", mySortedList.toString());
    }
    
    @Test
    public void removeIndex0Test() {
        SortedList mySortedList = new SortedList();
        boolean success = false;
        try {
            mySortedList.remove(0);
        }
        catch (ArrayIndexOutOfBoundsException exc) {
            success = true;
        }
        assertEquals(true, success);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }
    
    @Test
    public void removeIndex1ErrorTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        boolean success = false;
        try {
            mySortedList.remove(1);
        }
        catch (ArrayIndexOutOfBoundsException exc) {
            success = true;
        }
        assertEquals(true, success);
        assertEquals(1, mySortedList.size());
        assertEquals("[Abba]", mySortedList.toString());
    }
    
    @Test
    public void removeIndex1Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        String removed = (String)mySortedList.remove(0);
        assertEquals("Abba", removed);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }

    // Fix This
    @Test
    public void removeIndex2Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        String removed = (String)mySortedList.remove(0);
        assertEquals("a", removed);
        assertEquals(1, mySortedList.size());
        assertEquals("[Abba]", mySortedList.toString());
    }
    
    @Test
    public void removeIndexEndTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        mySortedList.add("zebra");
        mySortedList.add("fish");
        mySortedList.add("bat");
        String removed = (String)mySortedList.remove(0);
        assertEquals("a", removed);
        assertEquals(4, mySortedList.size());
        assertEquals("[Abba, bat, fish, zebra]", mySortedList.toString());
    }
    
    @Test
    public void set0Test() {
        SortedList mySortedList = new SortedList();
        boolean success = false;
        try {
            mySortedList.set(0, "Abba");
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
        assertEquals(0, mySortedList.size());
        assertEquals("[]", mySortedList.toString());
    }
    
    @Test
    public void setEndTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        mySortedList.add("zebra");
        mySortedList.add("fish");
        mySortedList.add("bat");
        boolean success = false;
        try {
            mySortedList.set(0, "Abba");
        }
        catch (IllegalArgumentException exc) {
            success = true;
        }
        assertEquals(true, success);
        assertEquals(5, mySortedList.size());
        assertEquals("[a, Abba, bat, fish, zebra]", mySortedList.toString());
    }
    
    @Test
    public void size0Test() {
        SortedList mySortedList = new SortedList();
        assertEquals(0, mySortedList.size());
    }
    
    @Test
    public void size0ClearTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        mySortedList.add("zebra");
        mySortedList.add("fish");
        mySortedList.add("bat");
        mySortedList.clear();
        assertEquals(0, mySortedList.size());
    }
    
    @Test
    public void size1ClearTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        mySortedList.add("zebra");
        mySortedList.add("fish");
        mySortedList.clear();
        mySortedList.add("bat");
        assertEquals(1, mySortedList.size());
    }
    
    @Test
    public void sizeEndTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        mySortedList.add("zebra");
        mySortedList.add("fish");
        assertEquals(4, mySortedList.size());
        mySortedList.clear();
        mySortedList.add("bat");
        mySortedList.add("Abba");
        assertEquals(2, mySortedList.size());
    }
    
    @Test
    public void toString0Test() {
        SortedList mySortedList = new SortedList();
        assertEquals("[]", mySortedList.toString());
    }
    
    @Test
    public void toString1Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        assertEquals("[Abba]", mySortedList.toString());
    }
    
    @Test
    public void toString2Test() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        assertEquals("[a, Abba]", mySortedList.toString());
    }
    
    @Test
    public void toStringEndTest() {
        SortedList mySortedList = new SortedList();
        mySortedList.add("Abba");
        mySortedList.add("a");
        mySortedList.add("zebra");
        mySortedList.add("fish");
        mySortedList.add("bat");
        assertEquals("[a, Abba, bat, fish, zebra]", mySortedList.toString());
        mySortedList.remove(0);
        assertEquals("[Abba, bat, fish, zebra]", mySortedList.toString());
        mySortedList.add("a");
        assertEquals("[a, Abba, bat, fish, zebra]", mySortedList.toString());
    }
}
