import interfaces.Inversable;

import java.util.ArrayList;

public class ArrayInverseRecursive implements Inversable<Integer> {
	@Override
	public ArrayList<Integer> inverse(ArrayList<Integer> inputArray) {
		return null;
	}
	public static void output(String input) {
		System.out.println(Arrays.toString(reverseIterative(input)));
		System.out.println(Arrays.toString(reverseRecursive(input, 0, new String[input.split(" ").length])));
	}
	public static String[] reverseRecursive(String input, int index, String[] resultArr) {
		String[] inputArr = input.split(" ");
		if (index < inputArr.length) {
			resultArr[inputArr.length - index - 1] = inputArr[index];
			reverseRecursive(input, index + 1, resultArr);
		}
		return resultArr;
	}

	public static String[] reverseIterative(String input) {

	}
}
