package s1801.lab02.m06.queues;

import s1801.lab02.m06.exceptions.OverflowException;
import s1801.lab02.m06.exceptions.UnderflowException;

public interface Deck<T> extends Queue<T> {

    void insertAtFront(T element) throws OverflowException;

    void insertAtBack(T element) throws OverflowException;

    T removeFromFront() throws UnderflowException;

    T removeFromBack() throws UnderflowException;
}
