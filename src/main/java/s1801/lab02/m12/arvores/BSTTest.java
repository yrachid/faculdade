package s1801.lab02.m12.arvores;

public class BSTTest {

    public static void original() {
        BST a = new BST();

        a.insert(15);
        a.insert(12);
        a.insert(20);
        a.insert(7);
        a.insert(14);
        a.insert(31);
        a.insert(19);

        a.inorder();
        System.out.println();

        a.preorder();
        System.out.println();

        a.postorder();
        System.out.println();

        a.delete(7);

        System.out.println();
        System.out.println("Delete 7");
        System.out.println();

        a.inorder();
        System.out.println();

        a.preorder();
        System.out.println();

        a.postorder();
        System.out.println();

    }

    public static void main(String[] args) {
        original();
    }
}
