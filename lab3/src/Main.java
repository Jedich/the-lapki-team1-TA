import Lists.CircularLinkedList;
import Lists.DoublyLinkedList;
import Lists.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		CircularLinkedList<Integer> list2 = new CircularLinkedList<>();
		DoublyLinkedList<Integer> list3 = new DoublyLinkedList<>();
		for(int i = 0; i < 3; i++) {
			list.add(i);
			list2.add(i);
			list3.add(i);
		}



		for(int i = 0; i < 3; i++) {
			System.out.println(list3.get(i));
			System.out.println(list2.get(i));
			System.out.println(list.get(i));
		}
	}


}
