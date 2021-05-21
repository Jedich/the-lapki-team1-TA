import hashtable.HashMapType;
import hashtable.HashTable;
import hashtable.LinkedListContainer;
import hashtable.TreeContainer;


class Main {
    public static void main(String[] args) {
        task1();

        System.out.println("---------------------Task 2-----------------------");
        HashTable<Integer> treeMap = new HashTable<Integer>(HashMapType.Tree);
        HashTable<Integer> linkedMap = new HashTable<Integer>(HashMapType.LinkedList);

        int[] iterations = new int[] {1000, 10000, 100_000, 200_000};
        for(int iter: iterations) {
            System.out.println("\n" + iter + " iterations: ");
            Timer timer = new Timer(treeMap);

            System.out.println("Inserting elements(treeMap):" + timer.sortedTimer(treeMap::add, iter));

            System.out.println("Search elements(treeMap):" + timer.sortedTimer(treeMap::get, iter));
            timer = new Timer(linkedMap);
            System.out.println("Inserting elements(linkedMap): " + timer.sortedTimer(linkedMap::add, iter));

            System.out.println("Search elements(treeMap):" + timer.sortedTimer(treeMap::get, iter));
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
