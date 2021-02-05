package labka1;

import java.util.*;

public class Main {
    private static TreeMap<Integer, String> map = new TreeMap<>(new MyComp());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        output(input);

    }

    public static void output(String input) {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
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

    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static StringBuffer intToRomanNumeral (int input) {
        Map<Integer, String> reversemap = map.descendingMap();
        StringBuffer result = new StringBuffer();
        if (input < 1 | input > 3000) {
            throw new IllegalArgumentException("Number must be greater than 1 and less than 3000.");
        } else {
            for (Map.Entry<Integer, String> entry : reversemap.entrySet()) {
                for (int i = 1; i <= input/entry.getKey(); i++) {
                    result.append(entry.getValue());
                }
                input %= entry.getKey();
            }
        }
        return result;
    }
    public static int romanNumeralToInt(String input) {
        int result = 0;
        for (char element : input.toCharArray()) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (entry.getValue().equals(Character.toString(element))) {
                    result += entry.getKey();
                }
                if (!map.containsValue(Character.toString(element)) && !input.equals("N")) {
                    throw new IllegalArgumentException("Enter a roman numeral.");
                }
            }
        }
        if (input.contains("IV") | input.contains("IX")) result -=2;
        if (input.contains("XL") | input.contains("XC")) result -=20;
        if (input.contains("CD") | input.contains("CM")) result -=200;
        if (input.equals("N")) result = 0;
        return result;
    }
}
