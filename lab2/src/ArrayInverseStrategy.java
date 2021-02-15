import interfaces.Inversable;

import java.util.ArrayList;
import java.util.List;

public class ArrayInverseStrategy<T> {
	private ArrayList<Integer> inputArray;
	private Inversable inverter;

	public ArrayInverseStrategy(ArrayList<Integer> inputArray, Inversable inverter) {
		this.inputArray = inputArray;
		this.inverter = inverter;
	}

	public ArrayList<Integer> performInversion() {
		return inverter.inverse(inputArray);
	}
}
