public class Main {
	public static void main(String[] args) {
		DataProcessor dp = new DataProcessor(new BubbleSorter());
		long time = dp.getSortTimeMillis(Operation.randomArray(10000,0,10000));
		System.out.println("BubbleSorter time: " + time);

		dp = new DataProcessor(new SelectionSorter());
		time = dp.getSortTimeMillis(new int[] {0, 3, 3, 6, 1, 9});
		System.out.println("SelectionSorter time: " + time);

		dp = new DataProcessor(new MergeSorter());
		time = dp.getSortTimeMillis(Operation.randomArray(25, -10, 50));
		System.out.println("MergeSorter time: " + time);
	}
}
