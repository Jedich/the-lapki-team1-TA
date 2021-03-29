package sorters;

public class QuickSorter implements Sorter {
	@Override
	public void sort(int[] array) {
		quickSort(array, 0, array.length-1);
	}

	private void quickSort(int[] array, int begin, int end) {
		if (begin < end) {
			int pivotIndex = partition(array, begin, end);
			quickSort(array, begin, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, end);
		}
	}

	private int partition(int[] arr, int begin, int end) {
		//int pivot = arr[end];
		int pivot = arr[(begin+end)/2];
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;
				swapElements(arr, i, j);
			}
		}
		swapElements(arr, i + 1, end);
		return i + 1;
	}
}
