import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krell on 2015-11-17.
 */
public class OccurrenceSetTest {

    @Test
    public void testSize() throws Exception {
        OccurrenceSet<Integer> intSet = new OccurrenceSet<>();
        intSet.add(1);
        intSet.add(3);
        intSet.add(5);
        intSet.add(5);
        intSet.add(3);
        intSet.add(3);
        intSet.add(3);

        assertEquals(3, intSet.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        OccurrenceSet<Integer> intSet = new OccurrenceSet<>();

        assertTrue(intSet.isEmpty());

//        intSet.add(1);
//
//        assertFalse(intSet.isEmpty());
    }

    @Test
    public void testContains() throws Exception {
        OccurrenceSet<Integer> intSet = new OccurrenceSet<>();

        assertFalse(intSet.contains(1));

//        intSet.add(1);
//
//        assertTrue(intSet.contains(1));
    }

    @Test
    public void testIterator() throws Exception {

    }

    @Test
    public void testToArray() throws Exception {

    }

    @Test
    public void testToArray1() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testContainsAll() throws Exception {

    }

    @Test
    public void testAddAll() throws Exception {

    }

    @Test
    public void testRetainAll() throws Exception {

    }

    @Test
    public void testRemoveAll() throws Exception {

    }

    @Test
    public void testClear() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {

    }

    @Test
    public void testHashCode() throws Exception {

    }
}