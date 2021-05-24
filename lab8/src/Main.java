import hashtable.HashMapType;
import hashtable.HashTable;
import hashtable.LinkedListContainer;
import hashtable.TreeContainer;
import tree.BinarySearchTree;


class Main {
    public static void main(String[] args) {
        task1();

        System.out.println("---------------------Task 2-----------------------");
        HashTable<Integer> treeMap = new HashTable<>(HashMapType.Tree);
        HashTable<Integer> linkedMap = new HashTable<>(HashMapType.LinkedList);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        int[] iterations = new int[] {1000, 10000, 100_000, 200_000};
        for(int iter: iterations) {
            System.out.println("\n" + iter + " iterations: ");
            Timer timer = new Timer(treeMap);

            System.out.println("Inserting elements(treeMap):" + timer.randomTimer(treeMap::add, iter) + "ms");

            System.out.println("Search elements(treeMap):" + timer.randomTimer(treeMap::get, iter) + "ms");

            treeMap = new HashTable<>(HashMapType.Tree);

            System.out.println("Inserting elements(linkedMap): " + timer.randomTimer(linkedMap::add, iter) + "ms");

            System.out.println("Search elements(linkedMap):" + timer.randomTimer(linkedMap::get, iter) + "ms");

            linkedMap = new HashTable<>(HashMapType.LinkedList);

            System.out.println("Inserting elements(tree): " + timer.randomTimer(tree::add, iter) + "ms");

            System.out.println("Search elements(tree): " + timer.randomTimer(tree::get, iter) + "ms");

            tree = new BinarySearchTree<>();
        }


    }



    public static void task1() {
        System.out.println("---------------------Task 1-----------------------");
        Person telenik = new Person("Sergiy",50,false);
        System.out.println("Telenik's hashcode: " + telenik.hashCode());
        Person babaValya = new Person("BabaValya",100,true);
        System.out.println("BabaValya's hashcode: " + babaValya.hashCode());

    }

}
