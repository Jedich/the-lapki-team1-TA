import interfaces.Inversable;

import java.util.ArrayList;

public class ArrayInverseIterative implements Inversable {
	@Override
	public ArrayList<Integer> inverse(ArrayList<Integer> inputArray) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < inputArray.size(); i++) {
			result.add(inputArray.get(inputArray.size() - i - 1));
		}
		return result;
	}
}
