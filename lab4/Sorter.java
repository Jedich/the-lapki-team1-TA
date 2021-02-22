public interface Sorter {

	void sort(byte[] array);

	default void swapElements(byte[] array, int i, int j) {
		byte temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
