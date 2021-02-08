import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		output(input);

	}

	public static void output(String input) {
		if (isNumeric(input)) {
			try {
				System.out.println(intToRomanNumeral(Integer.parseInt(input)));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			try {
				System.out.println(romanNumeralToInt(input));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c)) return false;
		}
		return true;
	}

	public static String intToRomanNumeral (int input) {
		//Map<String, Integer> reversemap = map.descendingMap();
		String result = new String();
		if (input < 1 | input > 3000) {
			throw new IllegalArgumentException("Number must be greater than 1 and less than 3000.");
		} else {
			int remainder = input;
			while(remainder > 0) {
				Map.Entry<String, Integer> bestBase = findBest(remainder);
				for(int i = 0; i < remainder/bestBase.getValue(); i++) {
					result += bestBase.getKey();
				}
				remainder %= bestBase.getValue();
			}
		}
		return result;
	}

	public static Map.Entry<String, Integer> findBest(int input) {
		Map.Entry<String, Integer> bestBase = null;
		for (Map.Entry<String, Integer> entry : RomanValues.instance().map.entrySet()) {
			if(bestBase == null) bestBase = entry;
			if(entry.getValue() > bestBase.getValue() && entry.getValue() <= input) {
				bestBase = entry;
			}
		}
		return bestBase;
	}

	public static int romanNumeralToInt(String input) {
		int result = 0;
		String[] inputArr = input.split("");
		for (int i = 0; i < input.length(); i++) {
			if (i != input.length()-1) {
				if (RomanValues.instance().map.get(inputArr[i]) >= RomanValues.instance().map.get(inputArr[i + 1])) {
					result += RomanValues.instance().map.get(inputArr[i]);
				} else {
					result -= RomanValues.instance().map.get(inputArr[i]);
				}
			}
			else {
				result += RomanValues.instance().map.get(inputArr[i]);
			}
		}
		return result;
	}
}
