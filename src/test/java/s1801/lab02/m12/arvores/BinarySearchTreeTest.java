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

        describe("A Binary Search Tree", () -> {
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

            it("determines its height correctly", () -> {
                assertThat(tree.height(), is(2));
            });

            it("determines its height correctly on tricky cases", () -> {
                BinarySearchTree trickyHeightTree = new BinarySearchTree();

                trickyHeightTree.insert(25);
                trickyHeightTree.insert(21);
                trickyHeightTree.insert(20);
                trickyHeightTree.insert(22);
                trickyHeightTree.insert(23);
                trickyHeightTree.insert(26);

                assertThat(trickyHeightTree.height(), is(3));
            });

            it("counts leaves correctly", () -> {
                BinarySearchTree treeWithThreeLeaves = new BinarySearchTree();

                treeWithThreeLeaves.insert(25);
                treeWithThreeLeaves.insert(21);
                treeWithThreeLeaves.insert(20);
                treeWithThreeLeaves.insert(22);
                treeWithThreeLeaves.insert(23);
                treeWithThreeLeaves.insert(26);
                treeWithThreeLeaves.insert(29);
                treeWithThreeLeaves.insert(28);
                treeWithThreeLeaves.insert(30);

                assertThat(treeWithThreeLeaves.countLeafNodes(), is(4));
            });

            it("counts nodes correctly", () -> {
                assertThat(tree.countNodes(), is(5));
            });
        });
    }

}