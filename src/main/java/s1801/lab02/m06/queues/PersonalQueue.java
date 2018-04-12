package s1801.lab02.m06.queues;

import s1801.lab02.m06.exceptions.OverflowException;
import s1801.lab02.m06.exceptions.UnderflowException;
import s1801.lab02.m06.stacks.Stack;

public class PersonalQueue<T> implements Queue<T> {

    private T[] items;

    private int enqueueIndex = -1;
    private int dequeueIndex = 0;

    PersonalQueue(int size) {
        items = (T[]) new Object[size];
    }

    private PersonalQueue(T[] items) {
        enqueueIndex = items.length - 1;
        this.items = items;
    }

    @Override
    public boolean isEmpty() {
        return enqueueIndex == dequeueIndex - 1;
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

        return dequeueItemFromInternalQueue();
    }

    private T dequeueItemFromInternalQueue() {
        T item = items[dequeueIndex];
        items[dequeueIndex] = null;
        dequeueIndex++;

        return item;
    }

    public static <R> Queue<R> fromStack(Stack<R> stack) {

        Stack<R> reversedStack = stack.reverse();

        try {
            R[] reversedStackItems = (R[]) new Object[reversedStack.size()];

            for (int i = 0; !reversedStack.isEmpty(); i++) {
                reversedStackItems[i] = reversedStack.pop();
            }

            return new PersonalQueue<>(reversedStackItems);

        } catch (UnderflowException e) {
            throw new RuntimeException("Stack underflowed while being converted to queue");
        }
    }
}