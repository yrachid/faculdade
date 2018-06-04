package s1801.lab02.m12.arvores;

import java.util.Optional;

import static java.util.Optional.empty;

public class BinarySearchTree {

    private Node<Integer> root;
    private int leaves;
    private int nodes;

    public Node<Integer> root() {
        return root;
    }

    public boolean insert(Integer element) {

        if (isEmpty()) {
            root = new Node<>(element);
            return true;
        }

        if (search(element).isPresent()) {
            return false;
        }

        Node<Integer> traverser = root;
        Node<Integer> insertionSpot = null;

        while (traverser != null) {
            insertionSpot = traverser;

            if (element > traverser.key) {
                traverser = traverser.right;
                continue;
            }

            traverser = traverser.left;
        }

        if (element > insertionSpot.key) {
            insertionSpot.right = new Node<>(element);
            return true;
        }

        insertionSpot.left = new Node<>(element);
        return true;
    }

    public int countLeafNodes() {
        leaves = 0;

        return countLeafNodes(root);
    }

    private int countLeafNodes(Node<Integer> node) {
        if (node != null) {
            if (isLeaf(node)) {
                leaves++;
            }

            countLeafNodes(node.left);
            countLeafNodes(node.right);
        }

        return leaves;
    }

    private boolean isLeaf(Node<Integer> node) {
        return node.left == null && node.right == null;
    }

    public int countNodes() {
        nodes = 0;
        return countNodes(root);
    }

    private int countNodes(Node<Integer> node) {
        if (node != null) {
            nodes++;

            countNodes(node.left);
            countNodes(node.right);
        }

        return nodes;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<Integer> node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        }

        return rightHeight + 1;
    }

    public Optional<Node<Integer>> search(Integer element) {

        if (isEmpty()) {
            return empty();
        }

        return search(root, element);
    }

    private Optional<Node<Integer>> search(Node<Integer> node, Integer element) {

        if (node == null) {
            return empty();
        }

        if (node.key.equals(element)) {
            return Optional.of(node);
        }

        if (node.key < element) {
            return search(node.right, element);
        }

        return search(node.left, element);
    }

    private boolean isEmpty() {
        return root == null;
    }

    public final class Node<T> {
        T key;

        Node<T> right;
        Node<T> left;

        Node(T key) {
            this.key = key;
        }
    }

}
