import interfaces.RomanToDecimal;

public class RomanToDecSimple implements RomanToDecimal {


    @Override
    public int toDecimal(String input) {

        var map = RomanValues.romanDecimal;
        int result = 0;
        String[] inputArr = input.split("");

        for (int i = 0; i < input.length()-1; i++) {
            if (map.get(inputArr[i]) >= map.get(inputArr[i + 1])) {
                result += map.get(inputArr[i]);
            } else {
                result -= map.get(inputArr[i]);
            }
        }
        result += map.get(inputArr[input.length()-1]);
        return result;
    }
}
