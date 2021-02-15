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

	public static ArrayList<Integer> readData(String input) {
	}
}
