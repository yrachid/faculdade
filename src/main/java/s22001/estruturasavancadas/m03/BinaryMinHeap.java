package s22001.estruturasavancadas.m03;

import java.util.Arrays;

public class BinaryMinHeap {
    private int[] data;
    private int heapSize;

    public BinaryMinHeap(int size) {
        data = new int[size];
        heapSize = 0;
    }

    public int getMinimum() {
        if (isEmpty()) {
            throw new HeapException("Heap is empty");
        }

        return data[0];
    }

    public void insert(int value) {
        if (heapSize == data.length) {
            throw new HeapException("Internal data structure overflow");
        }
        heapSize++;
        data[heapSize - 1] = value;
        rotateParent(heapSize - 1);
    }

    private void rotateParent(int nodeIndex) {
        if (nodeIndex != 0) {
            int parentIndex = getParentIndex(nodeIndex);
            if (data[parentIndex] > data[nodeIndex]) {
                int placeholder = data[nodeIndex];
                data[nodeIndex] = data[parentIndex];
                data[parentIndex] = placeholder;

                rotateParent(parentIndex);
            }
        }
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    private int getLeftChildIndex(int nodeIndex) {
        return 2 * nodeIndex + 1;
    }

    private int getRightChildIndex(int nodeIndex) {
        return 2 * nodeIndex + 2;
    }

    private int getParentIndex(int nodeIndex) {
        return (nodeIndex - 1) / 2;
    }

    @Override
    public String toString() {
        return String.format("BinaryMinHeap{data=%s, heapSize=%d}", Arrays.toString(data), heapSize);
    }

    public static class HeapException extends RuntimeException {
        public HeapException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        BinaryMinHeap heap = new BinaryMinHeap(10);
        heap.insert(1);
        heap.insert(3);
        heap.insert(6);
        heap.insert(5);
        heap.insert(9);
        heap.insert(8);

        System.out.println("Antes da insercao: ");
        System.out.println(heap);

        System.out.println();

        System.out.println("Insert -1");
        heap.insert(-1);
        System.out.println("Apos a insercao: ");
        System.out.println(heap);

        try {
            System.out.println("Teste de overflow:");
            heap.insert(7);
            heap.insert(7);
            heap.insert(7);
            heap.insert(7);
        }catch (HeapException ex) {
            ex.printStackTrace();
        }
    }
}
