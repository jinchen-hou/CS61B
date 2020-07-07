package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertEquals(10, arb.capacity());
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(5);
        arb.enqueue(6);
        arb.enqueue(7);
//        arb.enqueue(5);
//        arb.enqueue(6);
//        arb.enqueue(7);
//        arb.enqueue(5);
//        arb.enqueue(6);
//        arb.enqueue(7);
        assertEquals(5, arb.fillCount());
        arb.dequeue();
        arb.dequeue();
        assertEquals(3, arb.fillCount());
    }
}
