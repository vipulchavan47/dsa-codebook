package trees.learning;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(scanner);
//        tree.display();

        BST bst = new BST();
        bst.insert(15);
        bst.insert(11);
        bst.insert(10);
        bst.insert(13);
        bst.insert(20);
        bst.insert(17);

        bst.display();
        System.out.println(bst.balanced());
        bst.preOrder();
        System.out.println("\n");
        bst.inOrder();
        System.out.println("\n");
        bst.postOrder();

    }
}
