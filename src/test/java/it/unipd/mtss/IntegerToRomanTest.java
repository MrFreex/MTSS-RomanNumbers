////////////////////////////////////////////////////////////////////
// Alessandro Monni 2138005
// Filippo Lissandrin 2137980
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        "38, XXXVIII",
        "40, XL",
        "50, L",
        "88, LXXXVIII"
    })
    public void testConvert(int input, String expectedOutput) {
        // AAA: Act (Esecuzione dell'azione)
        String actualOutput = IntegerToRoman.convert(input);

        // AAA: Assert (Verifica del risultato)
        assertEquals(expectedOutput, actualOutput);
    }
}