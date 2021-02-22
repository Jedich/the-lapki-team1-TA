public class Operation {
	public static byte[] randomArray(int size, int min, int max) {
		byte[] array = new byte[size];
		for (int i = 0; i < size; i++) {
			array[i] = (byte)(Math.random()*(max-min+1)+min);
		}
		return array;
	}
}
