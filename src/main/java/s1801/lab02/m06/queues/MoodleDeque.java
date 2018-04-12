package s1801.lab02.m06.queues;

import s1801.lab02.m06.exceptions.OverflowException;
import s1801.lab02.m06.exceptions.UnderflowException;

public class MoodleDeque extends MoodleQueue {

    public MoodleDeque(int size) {
        super(size);
    }

    public void insertAtFront(Object o) throws OverflowException {
        if (isFull()) {
            throw new OverflowException();
        }

    }

    public void insertAtBack(Object o) throws OverflowException {
        //?????????
    }

    public Object removeFromFront() throws UnderflowException {
        //???????????
        return null;
    }

    public Object removeFromBack() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        else
            return null;
        //???????????
    }

    public static void main(String args[]) {
        MoodleDeque d = new MoodleDeque(5);
        try {
            d.insertAtBack("1");
            d.insertAtBack("2");
            d.insertAtBack("3");
        } catch (OverflowException e) {
            System.out.println(e.toString());
        }

        try {
            System.out.println(d.removeFromFront());
            System.out.println(d.removeFromBack());

        } catch (UnderflowException e) {
            System.out.println(e.toString());
        }

    }
}
