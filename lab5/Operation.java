public class Operation {

	public enum Order {Desc, Asc}

	public static int[] randomArray(int size, int min, int max) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = (int)(Math.random()*(max-min+1)+min);
		}
		return array;
	}

	public static int[] orderedArray(int size, Order order) {
		int[] arr = new int[size];
		switch (order) {
			case Asc:
				for (int i = 0; i < size; i++) {
					arr[i] = i;
				}
				break;
			case Desc:
				for (int i = 0; i < size; i++) {
					arr[(size-1) - i] = i;
				}
				break;
		}
		return arr;
	}
}
