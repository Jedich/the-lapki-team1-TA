import tree.AVLTree;
import tree.BinarySearchTree;
import tree.Tree;


class Main {
    public static void main(String[] args) {
        Tree[] trees = new Tree[]{new BinarySearchTree(), new AVLTree()};
        String[] names = new String[]{"Unbalanced", "Balanced"};
        for (int i = 0; i < 2; i++) {
            Tree tree = trees[i];

            Timer timer = new Timer(tree);
            System.out.println("\n" + names[i] + " tree");

            System.out.println("Inserting sorted elements: " + timer.sortedTimer(tree::add));
            System.out.println("Balancing sorted elements: " + timer.balancingTimer());
            System.out.println("Inserting random elements: " + timer.randomTimer(tree::add));
            System.out.println("Balancing random elements: " + timer.balancingTimer());
            System.out.println("Searching: " + timer.sortedTimer(tree::search));
            System.out.println("Deleting: " + timer.sortedTimer(tree::delete));

        }
    }
}
