public class DataProcessor {

	private Sorter sorter;

	public DataProcessor(Sorter desiredSorter) {
		sorter = desiredSorter;
	}

	public void arraySort(int[] array) {
		sorter.sort(array);
	}

	public long getSortTimeMillis(int[] array) {
		long startTime = System.nanoTime();
		sorter.sort(array);
		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000;
	}
}
