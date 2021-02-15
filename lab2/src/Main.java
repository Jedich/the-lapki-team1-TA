import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Recursive array inversion example");
		ArrayInverseStrategy<Integer> inverter = new ArrayInverseStrategy<>(readData(), new ArrayInverseRecursive());
		System.out.println(inverter.performInversion());

		System.out.println("Iterative array inversion example");
		inverter = new ArrayInverseStrategy<>(readData(), new ArrayInverseIterative());
		System.out.println(inverter.performInversion());

		System.out.println("Enter m and n for binomial coefficient example(0<m<n):");
		Binomial binomial = new Binomial();
		Scanner scanner = new Scanner(System.in);
		System.out.println(binomial.findCoefficient(scanner.nextInt(), scanner.nextInt()));
	}

	public static ArrayList<Integer> readData() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		System.out.println("Enter numbers one by one, last numbers should be zero:");
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
