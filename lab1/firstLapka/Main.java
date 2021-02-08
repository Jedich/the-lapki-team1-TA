package firstLapka;

import firstLapka.interfaces.DecimalToRoman;
import firstLapka.interfaces.RomanToDecimal;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Consider input is correct
        String input = getInput();
        processInput(input, new DecToRomanRecursion(), new RomanToDecSimple());

    }

    private static String getInput() {
        System.out.println("Enter decimal or roman number(e.g. 123, XV):");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void processInput(String input, DecimalToRoman decToRom, RomanToDecimal romToDec) {
        try {
            if (isNumeric(input)) {
				int numInput = Integer.parseInt(input);
				System.out.print(numInput + " is ");
                System.out.println(decToRom.toRoman(numInput));

            } else {
				System.out.print(input + " is ");
				System.out.println(romToDec.toDecimal(input));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
