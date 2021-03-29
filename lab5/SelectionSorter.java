public class SelectionSorter implements Sorter {
	@Override
	public void sort(int[] array) {
		for(int i = 0; i < array.length-1; i++) {
			int jMin = i;
			for(int j = i+1; j < array.length; j++) {
				if(array[j] < array[jMin]) {
					jMin = j;
				}
			}
			if(jMin != i) {
				swapElements(array, i, jMin);
			}
		}
	}
}
