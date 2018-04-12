package s1801.lab02.m06.queues;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import s1801.lab02.m06.exceptions.OverflowException;
import s1801.lab02.m06.exceptions.UnderflowException;
import s1801.lab02.m06.stacks.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonalQueueTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Queue<Integer> queue;

    @Before
    public void setUp() {
        queue = new PersonalQueue<>(2);
    }

    @Test
    public void it_starts_empty() {
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void it_is_not_empty_when_something_is_enqueued() throws OverflowException {
        queue.enqueue(1);

        assertThat(queue.isEmpty(), is(false));
    }

    @Test
    public void it_can_dequeue_an_item() throws OverflowException, UnderflowException {
        queue.enqueue(1);

        Integer dequeuedItem = queue.dequeue();

        assertThat(dequeuedItem, is(1));
    }

    @Test
    public void it_underflows_when_dequeued_without_items() throws UnderflowException {
        expectedException.expect(UnderflowException.class);
        queue.dequeue();
    }

    @Test
    public void it_gets_full_when_enqueued_items_to_its_maximum_size() throws OverflowException {
        queue.enqueue(1);
        queue.enqueue(2);

        assertThat(queue.isFull(), is(true));
    }

    @Test
    public void it_overflows_when_enqueued_with_too_many_items() throws OverflowException {
        expectedException.expect(OverflowException.class);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }

    @Test
    public void it_dequeues_in_the_correct_order() throws OverflowException, UnderflowException {
        queue.enqueue(1);
        queue.enqueue(2);

        assertThat(queue.dequeue(), is(1));
        assertThat(queue.dequeue(), is(2));
    }

    @Test
    public void it_overflows_when_enqueued_after_being_full() throws UnderflowException, OverflowException {
        expectedException.expect(OverflowException.class);

        queue.enqueue(1);
        queue.enqueue(2);

        queue.dequeue();
        queue.dequeue();

        queue.enqueue(3);
    }

    @Test
    public void it_creates_a_queue_from_a_stack_having_items_correctly_sorted() throws OverflowException, UnderflowException {
        Stack<Integer> stack = new Stack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Queue<Integer> queueFromStack = PersonalQueue.fromStack(stack);

        assertThat(queueFromStack.dequeue(), is(1));
        assertThat(queueFromStack.dequeue(), is(2));
        assertThat(queueFromStack.dequeue(), is(3));
    }
}