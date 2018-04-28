
package s1801.lab02.m08;

public class Deque extends Queue {

    public void enqueueHead(Object o) {
        l.insertAtFront(o);
    }

    public void enqueueTail(Object object) {
        l.insertAtBack(object);
    }

    // remove object from queue
    public Object dequeueHead() throws EmptyListException {
        return l.removeFromFront();
    }

    public Object dequeueTail() throws EmptyListException {
        return l.removeFromBack();
    }

} // end class Dequeue

