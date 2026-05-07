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
     * Metodo di supporto che usa la Reflection per testare il metodo privato.
     */
    private String invokePrintAsciiArt(String input) throws Exception {
        Method method = RomanPrinter.class.getDeclaredMethod("printAsciiArt", String.class);
        method.setAccessible(true);
        return (String) method.invoke(null, input);
    }

    @Test
    public void testStampaAsciiArt_ConUnSingoloCarattereValido_DeveRestituireLaRappresentazioneCorretta() 
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
    public void testStampaAsciiArt_ConPiuCaratteriValidi_DeveAffiancarliCorrettamente() throws Exception {
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
    public void testStampaAsciiArt_ConCaratteriRipetuti_DeveStamparliTuttiCorrettamente() throws Exception {
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
    public void testStampaAsciiArt_ConStringaVuota_DeveRestituireSoloRitorniACapo() throws Exception {
        // Arrange
        String input = "";
        String expected = "\n\n\n\n\n"; 
        
        // Act
        String actual = invokePrintAsciiArt(input);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStampaAsciiArt_ConCaratteriNonValidi_DeveIgnorarli() throws Exception {
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
    public void testStampaAsciiArt_ConCaratteriMinuscoli_DeveIgnorarliTrattandoliComeNonValidi() throws Exception {
        // Arrange
        String input = "iv";
        String expected = "\n\n\n\n\n"; 
        
        // Act
        String actual = invokePrintAsciiArt(input);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStampaAsciiArt_ConTuttiICaratteriValidi_DeveElaborareSeiRighe() throws Exception {
        // Arrange
        String input = "IVXLCDM";
        int righeAttese = 6;
        
        // Act
        String actual = invokePrintAsciiArt(input);
        String[] lineeGenerate = actual.split("\n");
        
        // Assert
        assertEquals(righeAttese, lineeGenerate.length);
    }

    @Test
    public void testStampaAsciiArt_ConInputNullo_DeveLanciareEccezione() throws Exception {
        // Arrange
        String input = null;
        
        // Act & Assert
        assertThrows(InvocationTargetException.class, () -> invokePrintAsciiArt(input));
    }
}