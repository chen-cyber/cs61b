package deque;


import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    /** Create a full array.
     * size = 8
     * Check the size is equal to 8.
     */
    public void addFullSizeArray()
    {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(3);
        ad.addFirst(4);
        ad.addFirst(5);
        ad.addFirst(6);
        ad.addFirst(7);
        ad.addFirst(8);
        ad.addFirst(9);
        ad.addLast(2);
        ad.removeFirst();
        ad.removeLast();
        ad.removeFirst();
        ad.removeLast();
        ad.addFirst(1);
        ad.addLast(2);
        ad.addLast(6);
        ad.addLast(7);

        ad.printDeque();
        assertEquals(8,ad.size());
        assertTrue("Ad should be full.",ad.isFull());
    }
    @Test
    /** resize a full array.
     * fixedSize = 2 * size
     *
     */
    public void resizeArray1()
    {
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        ad2.addFirst(3);
        ad2.addFirst(4);
        ad2.addFirst(5);
        ad2.addFirst(6);
        ad2.addFirst(7);
        ad2.addFirst(8);
        ad2.addFirst(9);
        ad2.addLast(2);
        ad2.removeFirst();
        ad2.removeLast();
        ad2.removeFirst();
        ad2.removeLast();
        ad2.addFirst(1);
        ad2.addLast(2);
        ad2.addLast(6);
        ad2.addLast(7);
        ad2.addLast(8);
        ad2.addFirst(9);


        assertEquals(10,ad2.size());
        assertFalse("Ad should be not full.",ad2.isFull());
    }
    @Test
    /** Create an array that the size of which is less than the quater of the fixedSize.
     * Needed to resize the fixed of the array
     *
     */
    public void resizeArray2()
    {
        ArrayDeque<Integer> ad3 = new ArrayDeque<>();
        ad3.addFirst(1);
        ad3.addFirst(2);
        ad3.removeLast();

        ad3.printDeque();
        assertEquals(4,ad3.fixedSize());

    }
    @Test
    public void chectGetIndex()
    {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(3);
        ad.addFirst(4);
        ad.addFirst(5);
        ad.addFirst(6);
        ad.addFirst(7);
        ad.addFirst(8);
        ad.addFirst(9);
        ad.addLast(2);
        ad.removeFirst();
        ad.removeLast();
        ad.removeFirst();
        ad.removeLast();
        ad.addFirst(1);
        ad.addLast(2);
        ad.addLast(6);
        ad.addLast(7);

        assertEquals(1,(int)ad.get(0));
        assertEquals(7,(int)ad.get(7));
    }
}
