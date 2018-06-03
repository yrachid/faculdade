package s1801.lab02.m08;

public class List {
    private Node firstNode;
    private Node lastNode;
    private String name;

    public List() {
        this("list");
    }

    public List(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    public Node getFirst() {
        return firstNode;
    }

    public Node getLast() {
        return lastNode;
    }

    public void insertAtFront(Object insertItem) {
        if (isEmpty())
            firstNode = lastNode = new Node(insertItem);

        else
            firstNode = new Node(insertItem, firstNode);
    }

    public void insertAtBack(Object insertItem) {
        if (isEmpty())
            firstNode = lastNode = new Node(insertItem);

        else {
            lastNode.setNext(new Node(insertItem));
            lastNode = lastNode.getNext();
        }
    }

    public Object removeFromFront() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException(name);

        Object removedItem = firstNode.getData();

        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.getNext();

        return removedItem;

    }

    public Object removeFromBack() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException(name);

        Object removedItem = lastNode.getData();

        if (firstNode == lastNode)
            firstNode = lastNode = null;

        else {
            Node current = firstNode;

            while (current.getNext() != lastNode)
                current = current.getNext();

            lastNode = current;
            current.setNext(null);
        }

        return removedItem;

    }

    public boolean troca_ter_quarto() {
        if (isEmpty()) {
            return false;
        }

        if (firstNode == lastNode) {
            return false;
        }

        Node secondNode = firstNode.getNext();

        if (secondNode == lastNode) {
            return false;
        }

        Node thirdNode = secondNode.getNext();

        if (thirdNode == lastNode) {
            return false;
        }

        Node fourthNode = thirdNode.getNext();

        secondNode.setNext(fourthNode);

        if (fourthNode == lastNode) {
            lastNode = thirdNode;
            fourthNode.setNext(lastNode);
            return true;
        }

        Node fifthNode = fourthNode.getNext();

        fourthNode.setNext(thirdNode);

        thirdNode.setNext(fifthNode);

        return true;
    }

    public boolean remove_impar() {
        if (isEmpty()) {
            return false;
        }

        Node firstOddNode = firstNode.getNext();

        if (firstOddNode == null) {
            return false;
        }

        if (firstOddNode == lastNode) {
            lastNode = firstNode;
            return true;
        }

        firstNode.setNext(firstOddNode.getNext());

        return true;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Empty " + name);
            return;
        }

        System.out.print("The " + name + " is: ");
        Node current = firstNode;

        while (current != null) {
            System.out.print(current.getData().toString() + " ");
            current = current.getNext();
        }

        System.out.println("\n");
    }


}
