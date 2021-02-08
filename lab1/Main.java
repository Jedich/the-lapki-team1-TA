import interfaces.DecimalToRoman;
import interfaces.RomanToDecimal;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Consider input is correct
        String input = getInput();
        String result = processInput(input, new DecToRomanRecursion(), new RomanToDecSimple());
        System.out.println(result);

    }

    private static String getInput() {
        System.out.println("Enter decimal or roman number(e.g. 123, XV):");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String processInput(String input, DecimalToRoman decToRom, RomanToDecimal romToDec) {
        try {
            if (isNumeric(input)) {
				int numInput = Integer.parseInt(input);
                return decToRom.toRoman(numInput);
            } else {
				return Integer.toString(romToDec.toDecimal(input));
            }
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}
