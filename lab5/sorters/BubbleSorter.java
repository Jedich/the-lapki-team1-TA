package sorters;

public class BubbleSorter implements Sorter {
	@Override
	public void sort(int[] array) {
		boolean swapped;
		do {
			swapped = false;
			for(int i = 1; i < array.length; i++) {
				if(array[i-1] > array[i]) {
					swapElements(array, i, i-1);
					swapped = true;
				}
			}
		} while (swapped);
	}
}
