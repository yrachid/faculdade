package s1801.lab02.m12.arvores;

import j8spec.junit.J8SpecRunner;
import org.junit.runner.RunWith;

import static j8spec.J8Spec.beforeEach;
import static j8spec.J8Spec.describe;
import static j8spec.J8Spec.it;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static s1801.lab02.m12.arvores.BinarySearchTree.bst;

@RunWith(J8SpecRunner.class)
public class BinarySearchTreeTest {

    {
        describe("A Binary Search Tree", () -> {
            it("organizes the elements at the correct order", () -> {
                BinarySearchTree tree = bst(5, 7, 4, 8, 3);

                assertThat(tree.root().key, is(5));

                assertThat(tree.root().left.key, is(4));
                assertThat(tree.root().left.left.key, is(3));

                assertThat(tree.root().right.key, is(7));
                assertThat(tree.root().right.right.key, is(8));
            });

            it("finds elements correctly", () -> {
                BinarySearchTree tree = bst(5, 7, 4, 8, 3);

                assertThat(tree.search(5).isPresent(), is(true));
                assertThat(tree.search(7).isPresent(), is(true));
                assertThat(tree.search(4).isPresent(), is(true));
                assertThat(tree.search(8).isPresent(), is(true));
                assertThat(tree.search(3).isPresent(), is(true));
                assertThat(tree.search(2).isPresent(), is(false));
            });

            it("will not insert duplicate elements", () -> {
                BinarySearchTree tree = bst(5, 7, 4, 8, 3);

                assertThat(tree.insert(3), is(false));
            });

            it("determines its height correctly", () -> {
                assertThat(bst(5, 7, 4, 8, 3).height(), is(3));
                assertThat(bst(25, 21, 20, 22, 23, 26).height(), is(4));
                assertThat(bst(6, 4, 8, 3, 5, 7, 9).height(), is(3));
            });


            it("counts leaves correctly", () -> {
                BinarySearchTree treeWithThreeLeaves = bst(25, 21, 20, 22, 23, 26, 29, 28, 30);

                assertThat(treeWithThreeLeaves.countLeafNodes(), is(4));
            });

            it("counts nodes correctly", () -> {
                BinarySearchTree tree = bst(5, 7, 4, 8, 3);

                assertThat(tree.countNodes(), is(5));
            });

            it("correctly classifies itself as a full tree", () -> {
                assertThat(bst(2, 1, 3).isFull(), is(true));
                assertThat(bst(6, 4, 8, 3, 5, 7, 9).isFull(), is(true));
                assertThat(bst(25, 21, 20, 22, 23, 26, 29, 28, 30).isFull(), is(false));
            });
        });
    }
}