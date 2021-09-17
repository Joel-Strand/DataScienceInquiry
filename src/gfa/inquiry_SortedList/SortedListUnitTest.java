package gfa.inquiry_SortedList;

import static org.junit.jupiter.api.Assertions.*;

class SortedListUnitTest {

    @org.junit.jupiter.api.Test
    void addOneItem() {
        SortedList sl = new SortedList();
        sl.add("Joel");

        int size = sl.size();
        String s = sl.toString();
        assertEquals(1, size);
        assertEquals("[Joel]", s);
    }

    @org.junit.jupiter.api.Test
    void addTwelveItemsInLexicographicalOrder() {
        SortedList sl = new SortedList();
        sl.add("12345");
        sl.add("6789");
        sl.add("Alice");
        sl.add("Ben");
        sl.add("Chris");
        sl.add("David");
        sl.add("Ethan");
        sl.add("Fiona");
        sl.add("George");
        sl.add("Hammond");
        sl.add("Ingrid");
        sl.add("Joel");

        int size = sl.size();
        String s = sl.toString();
        assertEquals(12, size);
        assertEquals("[12345, 6789, Alice, Ben, Chris, David, Ethan, Fiona, George, Hammond, Ingrid, Joel]", s);
    }

    @org.junit.jupiter.api.Test
    void addTwelveItemsOutOfLexicographicalOrder() {
        SortedList sl = new SortedList();
        sl.add("Alice");
        sl.add("Zeke");
        sl.add("12345");
        sl.add("Ben");
        sl.add("David");
        sl.add("Ethan");
        sl.add("Fiona");
        sl.add("Hammond");
        sl.add("6789");
        sl.add("Maria");
        sl.add("Chris");
        sl.add("Ingrid");

        int size = sl.size();
        String s = sl.toString();
        assertEquals(12, size);
        assertEquals("[12345, 6789, Alice, Ben, Chris, David, Ethan, Fiona, Hammond, Ingrid, Maria, Zeke]", s);
    }

    @org.junit.jupiter.api.Test
    void addTwelveItemsInLexicographicalOrderWithDuplicates() {
        SortedList sl = new SortedList();
        sl.add("12345");
        sl.add("6789");
        sl.add("Alice");
        sl.add("Ben");
        sl.add("Chris");
        sl.add("David");
        sl.add("Ethan");
        sl.add("Fiona");
        sl.add("George");
        sl.add("Hammond");
        sl.add("Ingrid");
        sl.add("Joel");
        sl.add("12345");
        sl.add("6789");
        sl.add("Alice");
        sl.add("Ben");
        sl.add("Chris");
        sl.add("David");
        sl.add("Ethan");
        sl.add("Fiona");
        sl.add("George");
        sl.add("Hammond");
        sl.add("Ingrid");
        sl.add("Joel");

        int size = sl.size();
        String s = sl.toString();
        assertEquals(12, size);
        assertEquals("[12345, 6789, Alice, Ben, Chris, David, Ethan, Fiona, George, Hammond, Ingrid, Joel]", s);
    }

    @org.junit.jupiter.api.Test
    void addTwelveItemsOutOfLexicographicalOrderWithDuplicates() {
        SortedList sl = new SortedList();
        sl.add("Alice");
        sl.add("Zeke");
        sl.add("12345");
        sl.add("Ben");
        sl.add("David");
        sl.add("Ethan");
        sl.add("Fiona");
        sl.add("Hammond");
        sl.add("6789");
        sl.add("Maria");
        sl.add("Chris");
        sl.add("Ingrid");
        sl.add("Alice");
        sl.add("Zeke");
        sl.add("12345");
        sl.add("Ben");
        sl.add("David");
        sl.add("Ethan");
        sl.add("Fiona");
        sl.add("Hammond");
        sl.add("6789");
        sl.add("Maria");
        sl.add("Chris");
        sl.add("Ingrid");

        int size = sl.size();
        String s = sl.toString();
        assertEquals(12, size);
        assertEquals("[12345, 6789, Alice, Ben, Chris, David, Ethan, Fiona, Hammond, Ingrid, Maria, Zeke]", s);
    }

    @org.junit.jupiter.api.Test
    void add50Items() {

    }

    @org.junit.jupiter.api.Test
    void add500Items() {

    }

    @org.junit.jupiter.api.Test
    void add1000Items() {

    }


    @org.junit.jupiter.api.Test
    void testAdd() {

    }

    @org.junit.jupiter.api.Test
    void clear() {
        SortedList sl = new SortedList();
        sl.add("Alice");
        sl.add("Zeke");
        sl.add("12345");
        sl.add("Ben");
        sl.add("David");
        sl.add("Ethan");
        sl.add("Fiona");
        sl.add("Hammond");
        sl.add("6789");
        sl.add("Maria");
        sl.add("Chris");
        sl.add("Ingrid");

        int sizeBeforeClear = sl.size();
        String toStringBeforeClear = sl.toString();

        sl.clear();

        int sizeAfterClear = sl.size();
        String toStringAfterClear = sl.toString();

        assertEquals(12, sizeBeforeClear);
        assertEquals("[12345, 6789, Alice, Ben, Chris, David, Ethan, Fiona, Hammond, Ingrid, Maria, Zeke]", toStringBeforeClear);
        assertEquals(0, sizeAfterClear);
        assertEquals("[]", toStringAfterClear);
    }

    @org.junit.jupiter.api.Test
    void contains() {

    }

    @org.junit.jupiter.api.Test
    void get() {

    }

    @org.junit.jupiter.api.Test
    void indexOf() {

    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {

    }

    @org.junit.jupiter.api.Test
    void remove() {

    }

    @org.junit.jupiter.api.Test
    void testRemove() {

    }

    @org.junit.jupiter.api.Test
    void set() {
        // Use try & catch
    }

    @org.junit.jupiter.api.Test
    void size() {
        SortedList sl = new SortedList();
        int size = sl.size();
        assertEquals(0, size);
    }

    @org.junit.jupiter.api.Test
    void size10() {
        SortedList sl = new SortedList();
        sl.add("Alice");
        sl.add("Ben");
        sl.add("Chris");
        sl.add("David");
        sl.add("Ethan");
        sl.add("Fiona");
        sl.add("George");
        sl.add("Hammond");
        sl.add("Ingrid");
        sl.add("Joel");
        int size = sl.size();
        assertEquals(10, size);
    }

    @org.junit.jupiter.api.Test
    void size10DuplicateItemsInOrder() {
        SortedList sl = new SortedList();
        sl.add("Alice");
        sl.add("Ben");
        sl.add("Chris");
        sl.add("David");
        sl.add("Ethan");
        sl.add("Fiona");
        sl.add("George");
        sl.add("Hammond");
        sl.add("Ingrid");
        sl.add("Joel");
        sl.add("Alice");
        sl.add("Ben");
        sl.add("Chris");
        sl.add("David");
        sl.add("Ethan");
        sl.add("Fiona");
        sl.add("George");
        sl.add("Hammond");
        sl.add("Ingrid");
        sl.add("Joel");
        int size = sl.size();
        assertEquals(10, size);
    }

    @org.junit.jupiter.api.Test
    void size10DuplicateItemsOutOfOrder() {
        SortedList sl = new SortedList();
        sl.add("Joel");
        sl.add("David");
        sl.add("Alice");
        sl.add("Chris");
        sl.add("Hammond");
        sl.add("Ben");
        sl.add("Ethan");
        sl.add("George");
        sl.add("Fiona");
        sl.add("Ingrid");
        sl.add("Joel");
        sl.add("David");
        sl.add("Alice");
        sl.add("Chris");
        sl.add("Hammond");
        sl.add("Ben");
        sl.add("Ethan");
        sl.add("George");
        sl.add("Fiona");
        sl.add("Ingrid");
        int size = sl.size();
        assertEquals(10, size);
    }

    @org.junit.jupiter.api.Test
    void testToStringSize0() {
        SortedList sl = new SortedList();
        String s = sl.toString();
        assertEquals("[]", s);
    }

    @org.junit.jupiter.api.Test
    void testToStringSize1() {
        SortedList sl = new SortedList();
        sl.add("Abby");
        String s = sl.toString();
        assertEquals("[Abby]", s);
    }

    @org.junit.jupiter.api.Test
    void testToStringSize10InOrder() {
        SortedList sl = new SortedList();
        sl.add("Alice");
        sl.add("Ben");
        sl.add("Chris");
        sl.add("David");
        sl.add("Ethan");
        sl.add("Fiona");
        sl.add("George");
        sl.add("Hammond");
        sl.add("Ingrid");
        sl.add("Joel");
        String s = sl.toString();
        assertEquals("[Alice, Ben, Chris, David, Ethan, Fiona, George, Hammond, Ingrid, Joel]", s);
    }

    @org.junit.jupiter.api.Test
    void testToStringSize10OutOfOrder() {
        SortedList sl = new SortedList();
        sl.add("Joel");
        sl.add("David");
        sl.add("Alice");
        sl.add("Chris");
        sl.add("Hammond");
        sl.add("Ben");
        sl.add("Ethan");
        sl.add("George");
        sl.add("Fiona");
        sl.add("Ingrid");
        String s = sl.toString();
        assertEquals("[Alice, Ben, Chris, David, Ethan, Fiona, George, Hammond, Ingrid, Joel]", s);
    }
}