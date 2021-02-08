import interfaces.DecimalToRoman;


public class DecToRomanRecursion implements DecimalToRoman {


    @Override
    public String toRoman(int number) {
        var map = RomanValues.decimalRoman;

        int floorKey =  map.floorKey(number);

        if ( number == floorKey ) {
            return map.get(number);
        }
        return map.get(floorKey) + toRoman(number-floorKey);
    }
}
