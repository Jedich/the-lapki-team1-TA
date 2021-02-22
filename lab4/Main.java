public class Main {
	public static void main(String[] args) {
		System.out.println("==================1k elements==================");
		int[] array = Operation.randomArray(1000,0,10000);
		testSorters(array);

		System.out.println("=================10k elements==================");
		array = Operation.randomArray(10000,0,10000);
		testSorters(array);

		System.out.println("================100k elements==================");
		array = Operation.randomArray(100000,0,10000);
		testSorters(array);

		System.out.println("===============1k elements sorted==============");
		array = Operation.orderedArray(1000, Operation.Order.Asc);
		testSorters(array);

		System.out.println("==============10k elements sorted==============");
		array = Operation.orderedArray(10000, Operation.Order.Asc);
		testSorters(array);

		System.out.println("=============100k elements sorted==============");
		array = Operation.orderedArray(100000, Operation.Order.Asc);
		testSorters(array);

	}

	private static void testSorters(int[] array) {
		DataProcessor dp;
		long time;
		System.out.print("working...");
		Thread thread = new Thread(new HeartbeatThread());
		thread.start();
		dp = new DataProcessor(new BubbleSorter());
		time = dp.getSortTimeMillis(array.clone());
		System.out.println("\nBubbleSorter time: " + time + "ms");
		thread.stop();
		dp = new DataProcessor(new SelectionSorter());
		time = dp.getSortTimeMillis(array.clone());
		System.out.println("SelectionSorter time: " + time + "ms");

		dp = new DataProcessor(new InsertionSorter());
		time = dp.getSortTimeMillis(array.clone());
		System.out.println("InsertionSorter time: " + time + "ms");

		dp = new DataProcessor(new MergeSorter());
		time = dp.getSortTimeMillis(array.clone());
		System.out.println("MergeSorter time: " + time + "ms");
	}
}