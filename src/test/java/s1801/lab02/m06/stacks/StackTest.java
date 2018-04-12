package s1801.lab02.m06.stacks;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import s1801.lab02.m06.exceptions.OverflowException;
import s1801.lab02.m06.exceptions.UnderflowException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest {

    private Stack<Integer> stack;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        stack = new Stack<>(2);
    }

    @Test
    public void it_starts_empty() {
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void it_underflows_when_popped_empty() throws UnderflowException {
        expectedException.expect(UnderflowException.class);

        stack.pop();
    }

    @Test
    public void it_is_not_empty_when_pushed() throws OverflowException {
        stack.push(1);

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void it_gets_full_when_pushed_to_its_maximum_size() throws OverflowException {
        stack.push(1);
        stack.push(2);

        assertThat(stack.isFull(), is(true));
    }

    @Test
    public void it_overflows_when_pushed_beyond_its_maximum_size() throws OverflowException {
        expectedException.expect(OverflowException.class);

        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void it_pops_in_the_right_order() throws UnderflowException, OverflowException {
        stack.push(1);
        stack.push(2);

        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void it_gets_empty_when_all_elements_are_popped() throws OverflowException, UnderflowException {
        stack.push(1);
        stack.push(2);

        stack.pop();
        stack.pop();

        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void it_allows_pushing_new_elements_after_being_fully_popped() throws UnderflowException, OverflowException {
        stack.push(1);
        stack.push(2);

        stack.pop();
        stack.pop();

        stack.push(3);
        stack.push(4);

        assertThat(stack.pop(), is(4));
        assertThat(stack.pop(), is(3));
    }

    @Test
    public void it_creates_a_reverse_stack_correctly() throws OverflowException, UnderflowException {
        stack.push(1);
        stack.push(2);

        Stack<Integer> reversed = stack.reverse();

        assertThat(reversed.pop(), is(1));
        assertThat(reversed.pop(), is(2));
    }
}