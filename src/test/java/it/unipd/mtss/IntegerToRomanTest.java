////////////////////////////////////////////////////////////////////
// Alessandro Monni 2138005
// Filippo Lissandrin 2137980
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IntegerToRomanTest {
    @ParameterizedTest(name = "Test {index}: convert({0}) = {1}")
    @CsvSource({
        "1, I",       
        "2, II",      
        "3, III",     
        "4, IV",
        "5, V",
        "6, VI",
        "7, VII",
        "8, VIII",
        "9, IX",
        "10, X",
        "14, XIV",
        "19, XIX",
        "38, XXXVIII",
        "40, XL",
        "44, XLIV",
        "49, XLIX",
        "50, L",
        "88, LXXXVIII",
        "90, XC",
        "99, XCIX",
        "100, C",
        "144, CXLIV",
        "388, CCCLXXXVIII",
        "399, CCCXCIX",
        "400, CD",
        "444, CDXLIV",
        "499, CDXCIX",
        "887, DCCCLXXXVII",
        "888, DCCCLXXXVIII",
    })
    public void testConvert(int input, String expectedOutput) {
        // AAA: Act
        String actualOutput = IntegerToRoman.convert(input);

        // AAA: Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testNoFourConsecutiveCharacters() {
        int max = IntegerToRoman.MAX_VALUE; 

        for (int i = 1; i <= max; i++) {
            // AAA: Act
            String roman = IntegerToRoman.convert(i);
            
            // AAA: Assert
            assertFalse(roman.matches(".*(.)\\1{3,}.*"), 
                "Il numero " + i + " (" + roman + ") viola la regola delle 3 ripetizioni");
        }
    }

    @Test
    public void testConvert_Zero_ThrowsException() {
        // AAA: Arrange
        int invalidInput = 0;

        // AAA: Act & Assert 
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.convert(invalidInput);
        }, "Dovrebbe lanciare IllegalArgumentException per 0");
    }

    @Test
    public void testConvert_OverMax_ThrowsException() {
        // AAA: Arrange
        int invalidInput = IntegerToRoman.MAX_VALUE + 1; 

        // AAA: Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.convert(invalidInput);
        }, "Dovrebbe lanciare IllegalArgumentException per numeri oltre il limite");
    }

    @Test
    public void testConvert_NegativeNumber_ThrowsException() {
        // AAA: Arrange
        int invalidInput = -5;

        // AAA: Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.convert(invalidInput);
        }, "Dovrebbe lanciare IllegalArgumentException per numeri negativi");
    }

    @Test
    public void testConvert_Performance_AllNumbersConvertedWithinTimeLimit() {
        // AAA: Arrange
        int max = IntegerToRoman.MAX_VALUE;

        // AAA: Act & Assert
        org.junit.jupiter.api.Assertions.assertTimeout(
            java.time.Duration.ofMillis(100), 
            () -> {
                for (int i = 1; i <= max; i++) {
                    IntegerToRoman.convert(i);
                }
            }, 
            "Performance deludente (over 100ms)"
        );
    }


    @Test
    public void testOutputContainsOnlyValidCharacters() {
        // AAA: Arrange
        int max = IntegerToRoman.MAX_VALUE;
        // Solo caratteri ammessi fino a 888 (manca la M)
        String validCharsRegex = "^[IVXLCD]+$";

        for (int i = 1; i <= max; i++) {
            // AAA: Act
            String roman = IntegerToRoman.convert(i);
            
            // AAA: Assert
            org.junit.jupiter.api.Assertions.assertTrue(
                roman.matches(validCharsRegex),
                "Il risultato per " + i + " (" + roman + ") contiene caratteri non ammessi"
            );
        }
    }
}