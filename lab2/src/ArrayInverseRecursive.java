import interfaces.Inversable;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayInverseRecursive implements Inversable {
	@Override
	public ArrayList<Integer> inverse(ArrayList<Integer> inputArray) {
		return inverseRecursive(inputArray, 0, new ArrayList<>());
	}

	public static ArrayList<Integer> inverseRecursive(ArrayList<Integer> inputArray, int index, ArrayList resultArray) {
		if (index < inputArray.size()) {
			resultArray.add(inputArray.get(inputArray.size() - index - 1));
			inverseRecursive(inputArray, index + 1, resultArray);
		}
		return resultArray;
	}
}
