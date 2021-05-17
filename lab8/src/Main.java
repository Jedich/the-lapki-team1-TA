import hashtable.Containerable;
import tree.AVLTree;
import tree.BinarySearchTree;
import tree.Tree;
import hashtable.HashTable;


class Main {
    public static void main(String[] args) {
        Tree tree = new BinarySearchTree();

        Timer timer = new Timer(tree);

        System.out.println("Inserting random elements: " + timer.randomTimer(tree::add));
        System.out.println("Searching: " + timer.sortedTimer(tree::search));



    }

    public static void ma_ks() {
        HashTable<String, Person> table = new HashTable<>();
        Person p = new Person("baba valya", 9999999, true);
        table.add(p.getName(), p);
        p = new Person("telenik", 100500, true);
        table.add(p.getName(), p);
        p = new Person("bogatiy uyobak", -5, true);
        table.add(p.getName(), p);
        p = new Person("USer xexe", 0, false);
        table.add(p.getName(), p);
        p = new Person("mama Vitlica? net tvoya", 10, false);
        table.add(p.getName(), p);


    }

}
