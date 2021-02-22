public class DataProcessor {

	private Sorter sorter;

	public DataProcessor(Sorter desiredSorter) {
		sorter = desiredSorter;
	}

	public void arraySort(byte[] array) {
		sorter.sort(array);
	}
}
