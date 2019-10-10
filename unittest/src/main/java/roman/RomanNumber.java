package roman;

@SuppressWarnings("serial")
public class RomanNumber extends Number implements Comparable<RomanNumber> {
	private static final int keys[] = new int[] {
			1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
	};
	private static final String values[] = new String[] {
			"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
	};
	private int value;
	
	public RomanNumber(int input) {
		value = input;
	}
	
	public RomanNumber(String input) {
		value = fromRoman(input);
	}

	@Override
	public int compareTo(RomanNumber other) {
		return Integer.compare(value, other.value);
	}

	@Override
	public int intValue() {
		return value;
	}

	@Override
	public long longValue() {
		return value;
	}

	@Override
	public float floatValue() {
		return value;
	}

	@Override
	public double doubleValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return toRoman(value);
	}
	
	public static RomanNumber valueOf(String input) {
		return new RomanNumber(input);
	}
	
	public static RomanNumber valueOf(int input) {
		return new RomanNumber(input);
	}
	
	public static int fromRoman(String input) {
		assert(keys.length == 13 && values.length == 13);
		var result = 0;
		var count = 0;
		var inputIndex = 0;
		for (var mapIndex = 0; mapIndex < 13; mapIndex++) {
			boolean modFour = (mapIndex & 3) == 0;
			if (modFour) {
				if (count >= 2) {
					throw new IllegalArgumentException("roman doesn't match the regex");
				}
				count = 0;
			}
			var key = keys[mapIndex];
			var value = values[mapIndex];
			var valueLength = value.length();
			while (input.startsWith(value, inputIndex)) {
				result += key;
				inputIndex += valueLength;
				count++;
			}
			if (modFour) {
				if (count >= 4) {
					throw new IllegalArgumentException("roman doesn't match the regex");
				}
				count = 0;
			}
		}
		if (inputIndex < input.length() || count >= 2) {
			throw new IllegalArgumentException("roman doesn't match the regex");
		}
		return result;
	}
	
	public static String toRoman(int input) {
		if (input <= 0 || input >= 4000) {
			throw new IllegalArgumentException("input must lie between 1 and 3999");
		}
		var builder = new StringBuilder();
		var index = 0;
		do {
			var key = keys[index];
			var value = values[index];
			while (input >= key) {
				builder.append(value);
				input -= key;
			}
			index++;
		} while (input != 0);
		return builder.toString();
	}
}
