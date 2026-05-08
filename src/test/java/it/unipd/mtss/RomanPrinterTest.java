////////////////////////////////////////////////////////////////////
// Alessandro Monni 2138005
// Filippo Lissandrin 2137980
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanPrinterTest {

    /**
     * Helper method that uses Reflection to test the private method.
     */
    private String invokePrintAsciiArt(String input) throws Exception {
        Method method = RomanPrinter.class.getDeclaredMethod("printAsciiArt", String.class);
        method.setAccessible(true);
        return (String) method.invoke(null, input);
    }

    @Test
    public void testPrintAsciiArt_WithSingleValidCharacter_ShouldReturnCorrectRepresentation() 
            throws Exception {
        // Arrange
        String input = "I";
        String expected = 
            " _____ \n" +
            "|_   _|\n" +
            "  | |  \n" +
            "  | |  \n" +
            " _| |_ \n" +
            "|_____|";
        
        // Act
        String actual = invokePrintAsciiArt(input);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintAsciiArt_WithMultipleValidCharacters_ShouldPlaceThemCorrectly() throws Exception {
        // Arrange
        String input = "VI";
        String expected = 
            "__      __ _____ \n" +
            "\\ \\    / /|_   _|\n" +
            " \\ \\  / /   | |  \n" +
            "  \\ \\/ /    | |  \n" +
            "   \\  /    _| |_ \n" +
            "    \\/    |_____|";
        
        // Act
        String actual = invokePrintAsciiArt(input);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintAsciiArt_WithRepeatedCharacters_ShouldPrintAllCorrectly() throws Exception {
        // Arrange
        String input = "III";
        String expected = 
            " _____  _____  _____ \n" +
            "|_   _||_   _||_   _|\n" +
            "  | |    | |    | |  \n" +
            "  | |    | |    | |  \n" +
            " _| |_  _| |_  _| |_ \n" +
            "|_____||_____||_____|";
        
        // Act
        String actual = invokePrintAsciiArt(input);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintAsciiArt_WithEmptyString_ShouldReturnOnlyNewlines() throws Exception {
        // Arrange
        String input = "";
        String expected = "\n\n\n\n\n"; 
        
        // Act
        String actual = invokePrintAsciiArt(input);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintAsciiArt_WithInvalidCharacters_ShouldIgnoreThem() throws Exception {
        // Arrange
        String input = "IZ"; 
        String expected = 
            " _____ \n" +
            "|_   _|\n" +
            "  | |  \n" +
            "  | |  \n" +
            " _| |_ \n" +
            "|_____|";
        
        // Act
        String actual = invokePrintAsciiArt(input);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintAsciiArt_WithLowercaseCharacters_ShouldIgnoreThemAsInvalid() throws Exception {
        // Arrange
        String input = "iv";
        String expected = "\n\n\n\n\n"; 
        
        // Act
        String actual = invokePrintAsciiArt(input);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintAsciiArt_WithAllValidCharacters_ShouldProcessSixLines() throws Exception {
        // Arrange
        String input = "IVXLCDM";
        int expectedLines = 6;
        
        // Act
        String actual = invokePrintAsciiArt(input);
        String[] generatedLines = actual.split("\n");
        
        // Assert
        assertEquals(expectedLines, generatedLines.length);
    }

    @Test
    public void testPrintAsciiArt_WithNullInput_ShouldThrowException() throws Exception {
        // Arrange
        String input = null;
        
        // Act & Assert
        assertThrows(InvocationTargetException.class, () -> invokePrintAsciiArt(input));
    }
}