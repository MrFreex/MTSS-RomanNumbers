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
        // Just I
        "1, I",       
        "2, II",      
        "3, III",
        // With V     
        "4, IV",
        "5, V",
        "6, VI",
        "7, VII",
        "8, VIII",
        // With X
        "9, IX",
        "10, X",
        "14, XIV",
        "19, XIX",
        "38, XXXVIII",
        "39, XXXIX",
        // With L
        "40, XL",
        "44, XLIV",
        "49, XLIX",
        "50, L",
        "88, LXXXVIII",
        "89, LXXXIX",
        // With C
        "90, XC",
        "99, XCIX",
        "100, C",
        "144, CXLIV",
        "388, CCCLXXXVIII",
        "399, CCCXCIX",
        // With D
        "400, CD",
        "444, CDXLIV",
        "499, CDXCIX",
        "887, DCCCLXXXVII",
        "888, DCCCLXXXVIII",
        "899, DCCCXCIX",
        // With M
        "900, CM",
        "999, CMXCIX",
        "980, CMLXXX",
        "950, CML",
        "930, CMXXX",
        "920, CMXX",
        "910, CMX",
        "990, CMXC",
        "1000, M"
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
                "The number " + i + " (" + roman + ") violates 3-rep rule");
        }
    }

    @Test
    public void testConvert_Zero_ThrowsException() {
        // AAA: Arrange
        int invalidInput = 0;

        // AAA: Act & Assert 
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.convert(invalidInput);
        }, "Should throw IllegalArgumentException for 0");
    }

    @Test
    public void testConvert_OverMax_ThrowsException() {
        // AAA: Arrange
        int invalidInput = IntegerToRoman.MAX_VALUE + 1; 

        // AAA: Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.convert(invalidInput);
        }, "Should throw IllegalArgumentException for numbers above limit");
    }

    @Test
    public void testConvert_NegativeNumber_ThrowsException() {
        // AAA: Arrange
        int invalidInput = -5;

        // AAA: Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.convert(invalidInput);
        }, "Should throw IllegalArgumentException for negative numbers");
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
            "Bad performance (over 100ms)"
        );
    }


    @Test
    public void testOutputContainsOnlyValidCharacters() {
        // AAA: Arrange
        int max = IntegerToRoman.MAX_VALUE;
        // Solo caratteri ammessi fino a 888 (manca la M)
        String validCharsRegex = "^[IVXLCDM]+$";

        for (int i = 1; i <= max; i++) {
            // AAA: Act
            String roman = IntegerToRoman.convert(i);
            
            // AAA: Assert
            org.junit.jupiter.api.Assertions.assertTrue(
                roman.matches(validCharsRegex),
                "The result for input " + i + " (" + roman + ") contains disallowed characters."
            );
        }
    }
}