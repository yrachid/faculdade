package s1801.lab02.m12.arvores;

import j8spec.junit.J8SpecRunner;
import org.junit.runner.RunWith;

import static j8spec.J8Spec.beforeEach;
import static j8spec.J8Spec.describe;
import static j8spec.J8Spec.it;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(J8SpecRunner.class)
public class BinarySearchTreeTest {

    private BinarySearchTree tree;

    {
        beforeEach(() -> {
            tree = new BinarySearchTree();
            tree.insert(5);
            tree.insert(7);
            tree.insert(4);
            tree.insert(8);
            tree.insert(3);
        });

        describe("A Binary Search Trees", () -> {
            it("Organizes the elements at the correct order", () -> {

                assertThat(tree.root().key, is(5));

                assertThat(tree.root().left.key, is(4));
                assertThat(tree.root().left.left.key, is(3));

                assertThat(tree.root().right.key, is(7));
                assertThat(tree.root().right.right.key, is(8));
            });

            it("Finds elements correctly", () -> {
                assertThat(tree.search(5).isPresent(), is(true));
                assertThat(tree.search(7).isPresent(), is(true));
                assertThat(tree.search(4).isPresent(), is(true));
                assertThat(tree.search(8).isPresent(), is(true));
                assertThat(tree.search(3).isPresent(), is(true));
                assertThat(tree.search(2).isPresent(), is(false));
            });

            it("Will not insert duplicate elements", () -> {
                assertThat(tree.insert(3), is(false));
            });
        });
    }

}