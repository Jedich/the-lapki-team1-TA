import interfaces.Inversable;

import java.util.ArrayList;

public class ArrayInverseIterative implements Inversable {
	@Override
	public ArrayList<Integer> inverse(ArrayList<Integer> inputArray) {
		String[] inputArr = input.split(" ");
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < inputArr.length; i++) {
			result[i] = inputArr[inputArr.length - i - 1];
		}
		return result;
	}
}
