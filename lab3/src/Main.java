import Lists.CircularLinkedList;
import Lists.DoublyLinkedList;
import Lists.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		CircularLinkedList<Integer> list2 = new CircularLinkedList<>();
		Queue<Integer> queue = new Queue<>();
		Stack<Integer> stack = new Stack<>();

		for(int i = 0; i < 10000; i++) {
			list1.add(i);
			list2.add(i);
		}

		for (int i = 1; i < 6; i++) {
			queue.add(i);
			stack.add(i);
		}

		long time;
		long start;
		long stop;

		System.out.println("===================Singly linked list===================");
		System.out.println("INSERTION");

		start = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			list1.addToStart(i);
		}
		stop = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list1.removeFirst();
		}
		time = stop - start;
		System.out.println("Front insertion: " + time / 1000 + " ms");


		start = System.nanoTime();
		for(int i = 5000; i < 6000; i++) {
			list1.addTo(i, i);
		}
		stop = System.nanoTime();
		for (int i = 5000; i < 6000; i++) {
			list1.removeFrom(i);
		}
		time = (stop - start)  / 1000;
		System.out.println("A. G. N. insertion: " + time + " ms");


		start = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			list1.add(i);
		}
		stop = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list1.removeLast();
		}
		time = (stop - start)  / 1000;
		System.out.println("End insertion: " + time + " ms");

		System.out.println("DELETION");

		start = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			list1.removeFirst();
		}
		stop = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list1.addToStart(i);
		}
		time = (stop - start)  / 1000;
		System.out.println("Front deletion: " + time + " ms");


		start = System.nanoTime();
		for(int i = 5000; i < 6000; i++) {
			list1.removeFrom(i);
		}
		stop = System.nanoTime();
		for (int i = 5000; i < 6000; i++) {
			list1.addTo(i, i);
		}
		time = (stop - start)  / 1000;
		System.out.println("A. G. N. deletion: " + time + " ms");


		start = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			list1.removeLast();
		}
		stop = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list1.add(i);
		}
		time = (stop - start)  / 1000;
		System.out.println("End deletion: " + time + " ms");

		System.out.println("INDEXING");

		start = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			list1.getIndexByValue(i);
		}
		stop = System.nanoTime();
		time = (stop - start)  / 1000;
		System.out.println("Indexing: " + time + " ms");

		System.out.println("==================Circular linked list==================");

		start = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			list2.addToStart(i);
		}
		stop = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list2.removeFirst();
		}
		time = stop - start;
		System.out.println("Front insertion: " + time / 1000 + " ms");


		start = System.nanoTime();
		for(int i = 5000; i < 6000; i++) {
			list2.addTo(i, i);
		}
		stop = System.nanoTime();
		for (int i = 5000; i < 6000; i++) {
			list2.removeFrom(i);
		}
		time = (stop - start)  / 1000;
		System.out.println("A. G. N. insertion: " + time + " ms");


		start = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			list2.add(i);
		}
		stop = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list2.removeLast();
		}
		time = (stop - start)  / 1000;
		System.out.println("End insertion: " + time + " ms");

		System.out.println("DELETION");

		start = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			list2.removeFirst();
		}
		stop = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list2.addToStart(i);
		}
		time = (stop - start)  / 1000;
		System.out.println("Front deletion: " + time + " ms");


		start = System.nanoTime();
		for(int i = 5000; i < 6000; i++) {
			list2.removeFrom(i);
		}
		stop = System.nanoTime();
		for (int i = 5000; i < 6000; i++) {
			list2.addTo(i, i);
		}
		time = (stop - start)  / 1000;
		System.out.println("A. G. N. deletion: " + time + " ms");


		start = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			list2.removeLast();
		}
		stop = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list2.add(i);
		}
		time = (stop - start)  / 1000;
		System.out.println("End deletion: " + time + " ms");

		System.out.println("INDEXING");

		start = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			list2.getIndexByValue(i);
		}
		stop = System.nanoTime();
		time = (stop - start)  / 1000;
		System.out.println("Indexing: " + time + " ms");

		System.out.println("===================QUEUE===================");
		for (int i = 0; i < queue.size; i++) {
			System.out.print(queue.get(i) + " ");
		}
		System.out.println("\nAddition:");
		for (int i = 6; i < 11; i++) {
			queue.add(i);
			for (int j = 0; j < queue.size; j++) {
				System.out.print(queue.get(j) + " ");
			}
			System.out.print("\n");
		}
		System.out.println("Deletion:");
		for (int i = 6; i < 10; i++) {
			queue.remove();
			for (int j = 0; j < queue.size; j++) {
				System.out.print(queue.get(j) + " ");
			}
			System.out.print("\n");
		}

		System.out.println("===================STACK===================");
		for (int i = 0; i < stack.size; i++) {
			System.out.print(stack.get(i) + " ");
		}
		System.out.println("\nAddition:");
		for (int i = 6; i < 10; i++) {
			stack.push(i);
			for (int j = 0; j < stack.size; j++) {
				System.out.print(stack.get(j) + " ");
			}
			System.out.print("\n");
		}
		System.out.println("Deletion:");
		for (int i = 6; i < 10; i++) {
			stack.pop();
			for (int j = 0; j < stack.size; j++) {
				System.out.print(stack.get(j) + " ");
			}
			System.out.print("\n");
		}
	}


}
