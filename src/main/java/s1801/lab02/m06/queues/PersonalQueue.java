package s1801.lab02.m06.queues;

import s1801.lab02.m06.exceptions.OverflowException;
import s1801.lab02.m06.exceptions.UnderflowException;

public class PersonalQueue<T> implements Queueable<T> {

    private T[] items;

    private int enqueueIndex = -1;
    private int dequeueIndex = -1;

    PersonalQueue(int size) {
        items = (T[]) new Object[size];
    }

    @Override
    public boolean isEmpty() {
        return dequeueIndex == enqueueIndex;
    }

    @Override
    public boolean isFull() {
        return enqueueIndex == items.length - 1;
    }

    @Override
    public void enqueue(T element) throws OverflowException {

        if (isFull()) {
            throw new OverflowException();
        }

        items[++enqueueIndex] = element;
    }

    @Override
    public T dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        return items[++dequeueIndex];
    }
}