////////////////////////////////////////////////////////////////////
// Alessandro Monni 2138005
// Filippo Lissandrin 2137980
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IntegerToRomanTest {

    // Arrange implicito
    private int input;
    private String expectedOutput;

    public IntegerToRomanTest(int input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters(name = "Test {index}: convert({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 1, "I" },       
            { 2, "II" },      
            { 3, "III" },     
            { 4, "IV" },
            { 5, "V" },
            { 6 , "VI" },
            { 7, "VII" },
            { 8, "VIII" }
        });
    }

    @Test
    public void testConvert() {
        // AAA: Act (Esecuzione dell'azione)
        String actualOutput = IntegerToRoman.convert(input);

        // AAA: Assert (Verifica del risultato)
        assertEquals(expectedOutput, actualOutput);
    }
}