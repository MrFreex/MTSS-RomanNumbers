package it.unipd.mtss;

import it.unipd.mtss.IntegerToRoman;
import static org.junit.Assert.*;
import org.junit.Test;

public class IntegerToRomanTest {
    @Test
    public void testOneToThree() {
        int[] test = { 1, 2, 3 };
        String[] output = { "I", "II", "III" };

        for (int i = 0; i < test.length; i++) {
            assertEquals(output[i], IntegerToRoman.convert(test[i]));
        }
    }
}
