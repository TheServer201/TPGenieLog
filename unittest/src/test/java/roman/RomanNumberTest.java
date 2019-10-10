package roman;

import static roman.RomanNumber.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.*;

public class RomanNumberTest {
	private static final Map<Integer, String> map = Map.ofEntries(
			Map.entry(1, "I"),
		    Map.entry(2, "II"),
		    Map.entry(3, "III"),
		    Map.entry(4, "IV"),
		    Map.entry(5, "V"),
		    Map.entry(6, "VI"),
		    Map.entry(7, "VII"),
		    Map.entry(8, "VIII"),
		    Map.entry(9, "IX"),
		    Map.entry(10, "X"),
		    Map.entry(50, "L"),
		    Map.entry(100, "C"),
		    Map.entry(500, "D"),
		    Map.entry(1000, "M"),
		    Map.entry(31, "XXXI"),
		    Map.entry(148, "CXLVIII"),
		    Map.entry(294, "CCXCIV"),
		    Map.entry(312, "CCCXII"),
		    Map.entry(421, "CDXXI"),
		    Map.entry(528, "DXXVIII"),
		    Map.entry(621, "DCXXI"),
		    Map.entry(782, "DCCLXXXII"),
		    Map.entry(870, "DCCCLXX"),
		    Map.entry(941, "CMXLI"),
		    Map.entry(1043, "MXLIII"),
		    Map.entry(1110, "MCX"),
		    Map.entry(1226, "MCCXXVI"),
		    Map.entry(1301, "MCCCI"),
		    Map.entry(1485, "MCDLXXXV"),
		    Map.entry(1509, "MDIX"),
		    Map.entry(1607, "MDCVII"),
		    Map.entry(1754, "MDCCLIV"),
		    Map.entry(1832, "MDCCCXXXII"),
		    Map.entry(1993, "MCMXCIII"),
		    Map.entry(2074, "MMLXXIV"),
		    Map.entry(2152, "MMCLII"),
		    Map.entry(2212, "MMCCXII"),
		    Map.entry(2343, "MMCCCXLIII"),
		    Map.entry(2499, "MMCDXCIX"),
		    Map.entry(2574, "MMDLXXIV"),
		    Map.entry(2646, "MMDCXLVI"),
		    Map.entry(2723, "MMDCCXXIII"),
		    Map.entry(2892, "MMDCCCXCII"),
		    Map.entry(2975, "MMCMLXXV"),
		    Map.entry(3051, "MMMLI"),
		    Map.entry(3185, "MMMCLXXXV"),
		    Map.entry(3250, "MMMCCL"),
		    Map.entry(3313, "MMMCCCXIII"),
		    Map.entry(3408, "MMMCDVIII"),
		    Map.entry(3501, "MMMDI"),
		    Map.entry(3610, "MMMDCX"),
		    Map.entry(3743, "MMMDCCXLIII"),
		    Map.entry(3844, "MMMDCCCXLIV"),
		    Map.entry(3888, "MMMDCCCLXXXVIII"),
		    Map.entry(3940, "MMMCMXL"),
		    Map.entry(3999, "MMMCMXCIX")
	);
	
	@Test
	public void allKnowValuesForward() {
		assertTrue(
				map
				.entrySet()
				.stream()
				.allMatch(entry -> toRoman(entry.getKey()).equals(entry.getValue()))
		);
	}
	
	@Test
	public void allKnowValuesBackward() {
		assertTrue(
				map
				.entrySet()
				.stream()
				.allMatch(entry -> fromRoman(entry.getValue()) == entry.getKey())
		);
	}
	
	@Test
	public void allForwardBackward() {
		assertTrue(
				IntStream
				.range(1, 3999)
				.allMatch(value -> fromRoman(toRoman(value)) == value)
		);
	}
	
	@Test
	public void allOutputUppercase() {
		assertTrue(
				IntStream
				.range(1, 3999)
				.allMatch(value -> 
						toRoman(value)
						.chars()
						.allMatch(Character::isUpperCase)
				)
		);
	}
	
	@Test
	public void oneLowercaseInput() {
		assertThrows(IllegalArgumentException.class, () -> fromRoman("i"));
	}
	
	@Test
	public void oneNegativeValue() {
		assertThrows(IllegalArgumentException.class, () -> toRoman(-1));
	}
	
	@Test
	public void twoRepeatedGroup() {
		assertThrows(IllegalArgumentException.class, () -> fromRoman("IVIV"));
	}
	
	@Test
	public void fourRepeatedSymbol() {
		assertThrows(IllegalArgumentException.class, () -> fromRoman("IIII"));
	}
	
	@Test
	public void oneBelowRange() {
		assertThrows(IllegalArgumentException.class, () -> toRoman(0));
	}
	
	@Test
	public void oneAboveRange() {
		assertThrows(IllegalArgumentException.class, () -> toRoman(4000));
	}
	
	@Test
	public void oneUnknownGroup() {
		assertThrows(IllegalArgumentException.class, () -> fromRoman("VX"));
	}
}
