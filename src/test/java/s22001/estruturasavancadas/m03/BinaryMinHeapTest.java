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
                heap.add(9);
                System.out.println(heap);
                heap.add(8);
                System.out.println(heap);
                heap.add(6);
                System.out.println(heap);
                heap.add(5);
                System.out.println(heap);
                heap.add(1);
                System.out.println(heap);
                heap.add(3);
                System.out.println(heap);
            });

        });
    }

}