public class Main {
	public static void main(String[] args) {
		DataProcessor dp = new DataProcessor(new BubbleSorter());
		long time = dp.getSortTimeMillis(Operation.orderedArray(10000, Operation.Order.Asc));
		System.out.println("BubbleSorter time: " + time);

		dp = new DataProcessor(new SelectionSorter());
		time = dp.getSortTimeMillis(Operation.randomArray(10000,0,10000));
		System.out.println("SelectionSorter time: " + time);

		dp = new DataProcessor(new InsertionSorter());
		time = dp.getSortTimeMillis(Operation.randomArray(10000,0,10000));
		System.out.println("InsertionSorter time: " + time);

		dp = new DataProcessor(new MergeSorter());
		time = dp.getSortTimeMillis(Operation.orderedArray(10000, Operation.Order.Asc));
		System.out.println("MergeSorter time: " + time);
	}
}
