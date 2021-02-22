public class Operation {
	public static int[] randomArray(int size, int min, int max) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = (int)(Math.random()*(max-min+1)+min);
		}
		return array;
	}
}
