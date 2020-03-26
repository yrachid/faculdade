package s22001.estruturasavancadas.m03;

import j8spec.junit.J8SpecRunner;
import org.junit.runner.RunWith;

import static j8spec.J8Spec.describe;
import static j8spec.J8Spec.it;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(J8SpecRunner.class)
public class BinaryMinHeapTest {

    {
        describe("Heap", () -> {

            BinaryMinHeap heap = new BinaryMinHeap(10);

            it("Prints itself", () -> {
                assertThat(heap.toString(), equalTo("BinaryMinHeap{data=[0, 0, 0, 0, 0, 0, 0, 0, 0, 0], heapSize=0}"));
            });

            it("Adds", () -> {
                heap.insert(9);
                heap.insert(8);
                heap.insert(5);
                heap.insert(6);
                heap.insert(1);
                heap.insert(3);

                assertThat(heap.toString(), equalTo("BinaryMinHeap{data=[1, 5, 3, 9, 6, 8, 0, 0, 0, 0], heapSize=6}"));
            });

            it("Overflows", c -> c.expected(BinaryMinHeap.HeapException.class), () -> {
                BinaryMinHeap overflownHeap = new BinaryMinHeap(2);
                overflownHeap.insert(1);
                overflownHeap.insert(2);
                overflownHeap.insert(3);
            });

        });
    }

}