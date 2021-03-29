import sorters.*;

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
		dp = new DataProcessor(new HeapSorter());
		time = dp.getSortTimeMillis(array.clone());
		System.out.println("HeapSorter time: " + time + "ms");

		dp = new DataProcessor(new ShellSorter());
		time = dp.getSortTimeMillis(array.clone());
		System.out.println("ShellSorter time: " + time + "ms");

		dp = new DataProcessor(new QuickSorter());
		time = dp.getSortTimeMillis(array.clone());
		System.out.println("QuickSorter time: " + time + "ms");

		dp = new DataProcessor(new MergeSorter());
		time = dp.getSortTimeMillis(array.clone());
		System.out.println("MergeSorter time: " + time + "ms");
	}
}
