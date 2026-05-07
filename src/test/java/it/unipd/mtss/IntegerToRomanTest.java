////////////////////////////////////////////////////////////////////
// Alessandro Monni 2138005
// Filippo Lissandrin 2137980
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IntegerToRomanTest {

    @ParameterizedTest
    @CsvSource({
        "1, I",
        "2, II",
        "3, III",
        "4, IV",
        "5, V",
        "6, VI",
        "7, VII",
        "8, VIII"
    })
    public void testConvert_ValidIntegers_ReturnsRoman(int input, String expected) {
        // Il framework gestisce l'Arrange implicitamente tramite i parametri
        // Act
        String actual = IntegerToRoman.convert(input);
        
        // Assert
        assertEquals(expected, actual);
    }
}