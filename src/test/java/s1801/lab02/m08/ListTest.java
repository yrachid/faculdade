package s1801.lab02.m08;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class ListTest {

    @Ignore
    public static abstract class SetUp {

        List list;

        abstract void configure();

        @Before
        public void setUp() {
            list = new List();
            configure();
        }
    }

    public static class WhenListIsEmpty extends SetUp {

        @Override
        void configure() { }

        @Test
        public void it_starts_empty() {
            assertThat(list.isEmpty(), is(true));
        }

        @Test
        public void has_null_first_node() {
            assertThat(list.getFirst(), is(nullValue()));
        }

        @Test
        public void has_null_last_node() {
            assertThat(list.getLast(), is(nullValue()));
        }

    }

    public static class WhenInsertingAtFront extends SetUp {

        @Override
        void configure() {
            list.insertAtFront(1);
        }

        @Test
        public void first_insertion_sets_both_first_and_last_as_same_node() {
            assertThat(list.getFirst().getData(), is(1));
            assertThat(list.getLast().getData(), is(1));
        }

        @Test
        public void following_insertions_push_older_elements_to_the_tail_of_the_list() {
            list.insertAtFront(2);

            assertThat(list.getFirst().getData(), is(2));
            assertThat(list.getLast().getData(), is(1));
        }

        @Test
        public void following_insertion_sets_the_next_node_of_the_first_node() {
            list.insertAtFront(2);

            assertThat(list.getFirst().getNext().getData(), is(1));
        }
    }

    public static class WhenInsertingAtBack extends SetUp {

        @Override
        void configure() {
            list.insertAtBack(1);
        }

        @Test
        public void first_insertion_sets_both_first_and_last_as_same_node() {
            assertThat(list.getFirst().getData(), is(1));
            assertThat(list.getLast().getData(), is(1));
        }

        @Test
        public void following_insertions_push_older_elements_to_the_head_of_the_list() {
            list.insertAtBack(2);

            assertThat(list.getFirst().getData(), is(1));
            assertThat(list.getLast().getData(), is(2));
        }

        @Test
        public void following_insertion_sets_the_next_node_of_the_first_node() {
            list.insertAtBack(2);

            assertThat(list.getFirst().getNext().getData(), is(2));
        }
    }

    public static class WhenInsertingAtFrontAndThenAtBack extends SetUp {

        @Override
        void configure() {
            list.insertAtFront(1);
            list.insertAtBack(2);
        }

        @Test
        public void first_element_is_the_one_inserted_at_front() {
            assertThat(list.getFirst().getData(), is(1));
        }

        @Test
        public void last_element_is_the_one_inserted_at_back() {
            assertThat(list.getLast().getData(), is(2));
        }

        @Test
        public void next_element_after_first_node_is_set_correctly() {
            assertThat(list.getLast().getData(), is(2));
        }
    }

}