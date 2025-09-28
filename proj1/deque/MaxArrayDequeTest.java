package deque;


import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    @Test

    /** Creat a MaxArraryDequeTest.
     * Return the biggest item.
     */
    public void returnMax()
    {
        MaxArrayDeque<Integer> test = new MaxArrayDeque(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 -o2;
            }
        });
        test.addFirst(1);
        test.addLast(2);
        test.addFirst(3);
        test.addLast(8);


        assertEquals(8,(long)test.max());
    }


    public void returnNull()
    {
        MaxArrayDeque<Integer> test1 = new MaxArrayDeque<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });



        assertNull(test1.max());

    }
}
