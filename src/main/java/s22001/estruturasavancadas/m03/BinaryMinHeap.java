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

    public void add(int value) {
    }

    private void rotateWithParent(int nodeIndex) {
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
        heap.add(9);
        heap.add(8);
        heap.add(6);
        heap.add(5);
        heap.add(1);
        heap.add(3);
    }
}
