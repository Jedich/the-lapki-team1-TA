import sorters.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Main {
	public static void main(String[] args) {

		System.out.println("================100k elements==================");
		int[] array = Operation.randomArray(100000,0,10000);
		testSorters(array);

		System.out.println("================1m elements==================");
		array = Operation.randomArray(1_000_000,0,10000);
		testSorters(array);

		System.out.println("=============100k elements sorted==============");
		array = Operation.orderedArray(100000, Operation.Order.Asc);
		testSorters(array);

		System.out.println("=============1m elements sorted==============");
		array = Operation.orderedArray(1_000_000, Operation.Order.Asc);
		testSorters(array);

	}

	private static void testSorters(int[] array) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
		otherSymbols.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.###", otherSymbols);
		DataProcessor dp;
		double time;
		dp = new DataProcessor(new HeapSorter());
		time = dp.getSortTimeMillis(array.clone());
		System.out.println("HeapSorter time: " + df.format(time) + "ms");

		dp = new DataProcessor(new ShellSorter());
		time = dp.getSortTimeMillis(array.clone());
		System.out.println("ShellSorter time: " + df.format(time) + "ms");

		dp = new DataProcessor(new QuickSorter());
		time = dp.getSortTimeMillis(array.clone());
		System.out.println("QuickSorter time: " + df.format(time) + "ms");

		dp = new DataProcessor(new MergeSorter());
		time = dp.getSortTimeMillis(array.clone());
		System.out.println("MergeSorter time: " + df.format(time) + "ms");
	}
}
