import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void given2018Roman_WhenConvertingToArabic_ThenReturn2018() {
        String roman2018 = "MMXVIII";

        int result = Main.RomanNumeral.romanToArabic(roman2018);
        assertEquals(2018, result);
    }

    @Test
    public void given1999Arabic_WhenConvertingToRoman_ThenReturnMCMXCIX() {
        int arabic1999 = 1999;
        String result = Main.RomanNumeral.arabicToRoman(arabic1999);
        assertEquals("MCMXCIX", result);
    }

    @Test(expected = Exception.class)
    public void calcTests() throws Exception {
            assertEquals("3", Main.calc("1 + 2"));
            assertEquals("II", Main.calc("VI / III"));
            assertEquals(Exception.class, Main.calc("I - II"));
            assertEquals(Exception.class, Main.calc("I + 1"));
            assertEquals(Exception.class, Main.calc("1"));
            assertEquals(Exception.class, Main.calc("1 + 2 + 3"));
    }
}