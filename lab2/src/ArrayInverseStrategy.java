import interfaces.Inversable;

import java.util.ArrayList;
import java.util.List;

public class ArrayInverseStrategy<T> {
	private ArrayList<T> inputArray;
	private Inversable<T> inverter;

	public ArrayInverseStrategy(ArrayList<T> inputArray, Inversable<T> inverter) {
		this.inputArray = inputArray;
		this.inverter = inverter;
	}

	public ArrayList<T> performInversion() {
		return inverter.inverse(inputArray);
	}
}
