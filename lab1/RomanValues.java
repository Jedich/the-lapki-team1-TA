import java.util.TreeMap;

public final class RomanValues {

    public final static TreeMap<Integer, String> decimalRoman = new TreeMap<>();
    public final static TreeMap<String, Integer> romanDecimal = new TreeMap<>();

    static {
        decimalRoman.put(1000, "M");
        decimalRoman.put(900, "CM");
        decimalRoman.put(500, "D");
        decimalRoman.put(400, "CD");
        decimalRoman.put(100, "C");
        decimalRoman.put(90, "XC");
        decimalRoman.put(50, "L");
        decimalRoman.put(40, "XL");
        decimalRoman.put(10, "X");
        decimalRoman.put(9, "IX");
        decimalRoman.put(5, "V");
        decimalRoman.put(4, "IV");
        decimalRoman.put(1, "I");

        romanDecimal.put("I", 1);
        romanDecimal.put("IV", 4);
        romanDecimal.put("V", 5);
        romanDecimal.put("IX", 9);
        romanDecimal.put("X", 10);
        romanDecimal.put("XL", 40);
        romanDecimal.put("L", 50);
        romanDecimal.put("XC", 90);
        romanDecimal.put("C", 100);
        romanDecimal.put("CD", 400);
        romanDecimal.put("D", 500);
        romanDecimal.put("CM", 900);
        romanDecimal.put("M", 1000);

    }

}
