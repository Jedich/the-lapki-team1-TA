import java.util.LinkedHashMap;

public class RomanValues {
	public static RomanValues singleton;
	public LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
	private RomanValues() {
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
	}

	public static RomanValues instance()
	{
		if (singleton == null)
			singleton = new RomanValues();

		return singleton;
	}
}
