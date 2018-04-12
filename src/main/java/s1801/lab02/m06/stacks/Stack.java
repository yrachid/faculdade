package s1801.lab02.m06.stacks;

import s1801.lab02.m06.exceptions.OverflowException;
import s1801.lab02.m06.exceptions.UnderflowException;

public class Stack<T> {
    private T[] items;

    private int top = -1;

    public Stack(int size) {
        items = (T[]) new Object[size];
    }

    private Stack(T[] items, int top) {
        this.items = items;
        this.top = top;
    }

    public int size() {
        return items.length;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == items.length - 1;
    }

    public void push(T obj) throws OverflowException {
        if (isFull()) {
            throw new OverflowException();
        }

        items[++top] = obj;
    }

    public T pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        Object o = items[top];
        items[top] = null;
        top--;
        return (T) o;
    }

    public Stack<T> reverse() {
        T[] reversedItems = (T[]) new Object[items.length];

        for (int progression = 0; progression < items.length; progression++) {
            reversedItems[progression] = items[regressiveIndexFor(progression)];
        }

        return new Stack<>(reversedItems, top);
    }

    private int regressiveIndexFor(int progressiveIndex) {
        return items.length - (progressiveIndex + 1);
    }
}
