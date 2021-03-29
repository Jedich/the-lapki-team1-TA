import sorters.Sorter;

public class DataProcessor {

	private Sorter sorter;

	public DataProcessor(Sorter desiredSorter) {
		sorter = desiredSorter;
	}

	public void arraySort(int[] array) {
		sorter.sort(array);
	}

	public double getSortTimeMillis(int[] array) {
		long startTime = System.nanoTime();
		sorter.sort(array);
		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000.0;
	}
}
