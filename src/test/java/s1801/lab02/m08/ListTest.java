package s1801.lab02.m08;

import j8spec.junit.J8SpecRunner;
import org.junit.runner.RunWith;

import static j8spec.J8Spec.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(J8SpecRunner.class)
public class ListTest {

    private List list;

    {
        describe("An empty list", () -> {

            beforeEach(() -> {
                list = new List();
            });

            it("starts empty", () -> {
                assertThat(list.isEmpty(), is(true));
            });

            it("has a null first node", () -> {
                assertThat(list.getFirst(), is(nullValue()));
            });

            it("has a null last node", () -> {
                assertThat(list.getLast(), is(nullValue()));
            });

            it("fails when removing from back", c -> c.expected(EmptyListException.class), () -> {
                list.removeFromBack();
            });

            it("fails when removing from front", c -> c.expected(EmptyListException.class), () -> {
                list.removeFromFront();
            });
        });

        describe("When inserting at front", () -> {

            beforeEach(() -> {
                list = new List();
                list.insertAtFront(1);
            });

            it("has first and last nodes pointing to the same reference on first insertion", () -> {
                assertThat(list.getFirst().getData(), is(1));
                assertThat(list.getLast().getData(), is(1));
            });

            it("pushes older elements to the end of the list on subsequent frontal insertions", () -> {
                list.insertAtFront(2);

                assertThat(list.getFirst().getData(), is(2));
                assertThat(list.getLast().getData(), is(1));
            });

            it("Chains nodes correctly on subsequent frontal insertions", () -> {
                list.insertAtFront(2);

                assertThat(list.getFirst().getNext().getData(), is(1));
            });
        });

        describe("When removing from front", () -> {
            beforeEach(() -> {
                list = new List();
                list.insertAtFront(1);
            });

            it("Removes the only element when a list has a single element", () -> {
                Object element = list.removeFromFront();

                assertThat(element, is(1));
                assertThat(list.isEmpty(), is(true));
            });

            it("pulls subsequent elements to the beginning of the list", () -> {
                list.insertAtFront(2);

                Object element = list.removeFromFront();

                assertThat(element, is(2));
                assertThat(list.getFirst().getData(), is(1));
                assertThat(list.getFirst().getNext(), is(nullValue()));
                assertThat(list.getLast().getData(), is(1));
            });
        });

        describe("When removing from back", () -> {
            beforeEach(() -> {
                list = new List();
                list.insertAtFront(1);
            });

            it("Removes the only element when a list has a single element", () -> {

                Object element = list.removeFromBack();

                assertThat(element, is(1));
                assertThat(list.isEmpty(), is(true));
            });

            it("Removes the last element and correctly preserves the remaining ones", () -> {
                list.insertAtFront(2);

                Object element = list.removeFromBack();

                assertThat(element, is(1));
                assertThat(list.getFirst().getData(), is(2));
                assertThat(list.getFirst().getNext(), is(nullValue()));
                assertThat(list.getLast().getData(), is(2));
            });
        });

        describe("When removing the first odd index", () -> {
            beforeEach(() -> {
                list = new List();
                list.insertAtFront(1);
                list.insertAtBack(2);
                list.insertAtBack(3);
            });

            it("Removes the first odd index when it is present", () -> {
                assertThat(list.remove_impar(), is(true));
                assertThat(list.getFirst().getData(), is(1));
                assertThat(list.getLast().getData(), is(3));
            });

            it("Does not remove the element when list is empty", () -> {
                List emptyList = new List();

                assertThat(emptyList.remove_impar(), is(false));
            });

            it("Does not remove the element when list has a single element", () -> {
                List listWithSingleElement = new List();
                listWithSingleElement.insertAtFront(1);

                assertThat(listWithSingleElement.remove_impar(), is(false));
            });

            it("Removes last element when the list has only two elements", () -> {
                List listWithTwoElements = new List();
                listWithTwoElements.insertAtFront(1);
                listWithTwoElements.insertAtBack(2);

                assertThat(listWithTwoElements.remove_impar(), is(true));
                assertThat(listWithTwoElements.getFirst().getData(), is(1));
                assertThat(listWithTwoElements.getLast().getData(), is(1));
            });

            it("Preserves correct node linking after removing the odd element", () -> {
                List list = new List();
                list.insertAtFront(1);
                list.insertAtBack(2);

                list.remove_impar();
                list.insertAtBack(3);

                assertThat(list.getFirst().getData(), is(1));
                assertThat(list.getLast().getData(), is(3));
            });
        });

        describe("When swapping third and fourth elements", () -> {
            beforeEach(() -> {
                list = new List();
                list.insertAtFront(1);
                list.insertAtBack(2);
                list.insertAtBack(3);
                list.insertAtBack(4);
            });

            it("Does not swap elements of an empty list", () -> {
                List anEmptyList = new List();

                assertThat(anEmptyList.troca_ter_quarto(), is(false));
            });

            it("Does not swap when list is too small", () -> {
                List aSmallList = new List();
                aSmallList.insertAtFront(1);
                aSmallList.insertAtBack(2);
                aSmallList.insertAtBack(3);

                assertThat(aSmallList.troca_ter_quarto(), is(false));
            });

            it("Swaps when list is big enough", () -> {
                boolean didSwap = list.troca_ter_quarto();

                assertThat(didSwap, is(true));
                assertThat(list.removeFromFront(), is(1));
                assertThat(list.removeFromFront(), is(2));
                assertThat(list.removeFromFront(), is(4));
                assertThat(list.removeFromFront(), is(3));
            });

            it("Preserves correct linking after swapping", () -> {
                List bigList = new List();
                bigList.insertAtBack(1);
                bigList.insertAtBack(2);
                bigList.insertAtBack(3);
                bigList.insertAtBack(4);
                bigList.insertAtBack(5);

                bigList.troca_ter_quarto();

                assertThat(bigList.removeFromFront(), is(1));
                assertThat(bigList.removeFromFront(), is(2));
                assertThat(bigList.removeFromFront(), is(4));
                assertThat(bigList.removeFromFront(), is(3));
                assertThat(bigList.removeFromFront(), is(5));
            });
        });
    }
}