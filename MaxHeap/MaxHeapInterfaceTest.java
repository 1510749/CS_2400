import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapInterfaceTest {
    MaxHeapInterface<Integer> maxHeap;
    @BeforeEach
    void setUp() {
        maxHeap = new ArrayMaxHeap<>();
        //I also tested the following constructors:
        Comparable[] testArray = {1,2,3,4,7,8,9,10,14,16};
//        maxHeap = new ArrayMaxHeap<>(9990); //Can replace the number inside
//        maxHeap = new ArrayMaxHeap<>(testArray);

        /*
         Note When testing the different constructors, I had commented out some code and changed numbers.
         So if you use this file to test the different constructors, you might have to edit some things as well
         because I didn't make a new test for every single thing and just reused the same tests with tweaks.
        */
    }

    @AfterEach
    void tearDown() {
        maxHeap = null;
    }

    @Test
    void add() {
        maxHeap.add(50);
        maxHeap.add(65);
        maxHeap.add(10);
        maxHeap.add(25);
        maxHeap.add(90);
        assertEquals(5,maxHeap.getSize());
        assertFalse(maxHeap.isEmpty());
    }
    @Test
    void addMore() {//Tests what happens when whatever capacity is reached
        for (int i = 0; i < 2468; i++) {
            maxHeap.add(i);
        }
        assertEquals(2468,maxHeap.getSize());
        System.out.println(maxHeap.getMax());
    }

    @Test
    void removeMax() {
        maxHeap.add(50);
        maxHeap.add(65);
        maxHeap.add(10);
        maxHeap.add(25);
        maxHeap.add(91);
        assertEquals(91,maxHeap.removeMax());
        System.out.println(maxHeap.getMax());
    }

    @Test
    void getMax() {
        maxHeap.add(50);
        maxHeap.add(65);
        maxHeap.add(10);
        maxHeap.add(25);
        maxHeap.add(91);
        assertEquals(91, maxHeap.getMax());//also used to test buildMaxHeap()
    }

    @Test
    void isEmpty() {
        maxHeap.add(50);
        maxHeap.add(65);
        maxHeap.add(10);
        maxHeap.add(25);
        maxHeap.add(90);
        assertFalse(maxHeap.isEmpty());
        System.out.println(maxHeap.getSize());
    }

    @Test
    void getSize() {
        maxHeap.add(50);
        maxHeap.add(65);
        maxHeap.add(10);
        maxHeap.add(25);
        maxHeap.add(90);
        maxHeap.add(9);
        maxHeap.add(55);
        maxHeap.add(66);
        maxHeap.add(2);
        maxHeap.add(27);
        assertEquals(10,maxHeap.getSize());
    }

    @Test
    void clear() {
        maxHeap.add(50);
        maxHeap.add(65);
        maxHeap.add(10);
        maxHeap.add(25);
        maxHeap.add(90);
        maxHeap.add(9);
        maxHeap.add(55);
        maxHeap.add(66);
        maxHeap.add(2);
        maxHeap.add(27);
        maxHeap.clear();
        assertTrue(maxHeap.isEmpty());
        System.out.print(maxHeap.getSize());
    }
}