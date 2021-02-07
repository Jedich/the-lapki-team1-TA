import java.util.*;

public class Main {
	private static LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		output(input);

	}

	public static void output(String input) {
		map.put("I", 1);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("CD", 400);
		map.put("D", 500);
		map.put("CM", 900);
		map.put("M", 1000);
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
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
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
				if (map.get(inputArr[i]) >= map.get(inputArr[i + 1])) {
					result += map.get(inputArr[i]);
				} else {
					result -= map.get(inputArr[i]);
				}
			}
			else {
				result += map.get(inputArr[i]);
			}
		}
		return result;
	}
}
