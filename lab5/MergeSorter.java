public class MergeSorter implements Sorter {
	@Override
	public void sort(int[] array) {
		sortParts(array, 0, array.length - 1);
	}

	void merge(int[] arr, int left, int middle, int right) {
		int n1 = middle - left + 1;
		int n2 = right - middle;
		int[] leftPart = new int[n1];
		int[] rightPart = new int[n2];

		if (n1 >= 0) {
			System.arraycopy(arr, left, leftPart, 0, n1);
		}
		for (int j = 0; j < n2; ++j) {
			rightPart[j] = arr[middle + 1 + j];
		}

		int i = 0, j = 0;
		int k = left;

		while (i < n1 && j < n2) {
			if (leftPart[i] <= rightPart[j]) {
				arr[k] = leftPart[i];
				i++;
			}
			else {
				arr[k] = rightPart[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = leftPart[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = rightPart[j];
			j++;
			k++;
		}
	}

	void sortParts(int[] arr, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			sortParts(arr, left, middle);
			sortParts(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}
}
