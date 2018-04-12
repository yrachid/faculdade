package s1801.lab02.m06.queues;

import s1801.lab02.m06.exceptions.OverflowException;
import s1801.lab02.m06.exceptions.UnderflowException;

public class MoodleQueue<T> implements MergeableQueue<T> {

    private int currentDequeingIndex = 0;
    private int lastInsertionIndex = -1;

    private Object queuedItems[];

    MoodleQueue(int size) {
        queuedItems = new Object[size];
    }

    public boolean isEmpty() {
        return lastInsertionIndex == currentDequeingIndex - 1;
    }

    public boolean isFull() {
        return lastInsertionIndex == queuedItems.length - 1;
    }

    public void enqueue(Object element) throws OverflowException {

        if (isFull()) {
            throw new OverflowException();
        }

        queuedItems[++lastInsertionIndex] = element;
    }

    public T dequeue() throws UnderflowException {

        if (isEmpty()) {
            throw new UnderflowException();
        }

        Object o = queuedItems[currentDequeingIndex];

        queuedItems[currentDequeingIndex] = null;

        currentDequeingIndex++;

        return (T) o;
    }

    @Override
    public MergeableQueue<T> merge(Mergeable<T> q1, Mergeable<T> q12) {
        MoodleQueue q3 = new MoodleQueue<T>(30);
        return q3;
    }
}
