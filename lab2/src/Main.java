import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		ArrayInverseStrategy<Integer> invertor =
				new ArrayInverseStrategy<>(new ArrayList<>(Arrays.asList(45, 67, 12)),
						new ArrayInverseIterative());
		System.out.println(invertor.performInversion());

		Binomial binomial = new Binomial();
		System.out.println(binomial.findCoefficient(7,10));
	}

	public static ArrayList<Integer> readData() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		System.out.println("Enter numbers one by one:");
		Scanner scanner = new Scanner(System.in);
		while(true){
			int myVar =  scanner.nextInt();
			if (myVar == 0) {
				return arrayList;
			}else {
				arrayList.add(myVar);
			}
		}
	}
}
