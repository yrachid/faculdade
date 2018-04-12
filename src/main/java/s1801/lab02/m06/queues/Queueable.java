package s1801.lab02.m06.queues;

import s1801.lab02.m06.exceptions.OverflowException;
import s1801.lab02.m06.exceptions.UnderflowException;

public interface Queueable<T> {

    boolean isEmpty();
    boolean isFull();
    void enqueue(T element) throws OverflowException;
    T dequeue() throws UnderflowException;
}
