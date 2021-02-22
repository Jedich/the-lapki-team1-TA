public class Main {
	public static void main(String[] args) {
		DataProcessor dp = new DataProcessor(new BubbleSorter());
		dp.arraySort(new byte[] {1, 6, 8, 9, 3, 15});

		dp = new DataProcessor(new SelectionSorter());
		dp.arraySort(new byte[] {0, 3, 3, 6, 1, 9});

		dp = new DataProcessor(new MergeSorter());
		dp.arraySort(Operation.randomArray(25, -10, 50));
	}
}
