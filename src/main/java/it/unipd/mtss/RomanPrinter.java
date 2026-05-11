////////////////////////////////////////////////////////////////////
// Alessandro Monni 2138005
// Filippo Lissandrin 2137980
////////////////////////////////////////////////////////////////////


package it.unipd.mtss;

/**
 * Utility class for printing Roman numbers as ASCII art.
 * It takes an integer, converts it to a Roman numeral string, 
 * and then generates a multi-line ASCII representation.
 * @author Alessandro Monni
 */
public class RomanPrinter {
  private static final String[] CHAR_I = {
        " _____ ",
        "|_   _|",
        "  | |  ",
        "  | |  ",
        " _| |_ ",
        "|_____|" 
    };

    private static final String[] CHAR_V = {
        "__      __",
        "\\ \\    / /", 
        " \\ \\  / / ", 
        "  \\ \\/ /  ",
        "   \\  /   ",
        "    \\/    "
    };

    private static final String[] CHAR_X = {
        "__   __",
        "\\ \\ / /",
        " \\ V / ",
        "  > <  ",
        " / . \\ ",
        "/_/ \\_\\" 
    };

    private static final String[] CHAR_L = {
        " -      ",
        "| |     ",
        "| |     ",
        "| |     ",
        "| |___  ",
        "|_____| "
    };

    private static final String[] CHAR_C = {
        "  ----   ",
        " / ___\\  ",
        "| |      ",
        "| |      ",
        "| |___   ",
        " \\____|  "
    };

    private static final String[] CHAR_D = {
        " _____  ",
        "|  __ \\ ",
        "| |  | |",
        "| |  | |",
        "| |__| |",
        "|_____/ "
    };

    private static final String[] CHAR_M = {
        " --  --  ",
        "|  \\/  | ",
        "|      | ",
        "| |\\/| | ",
        "| |  | | ",
        "|_|  |_| "
    };


    /**
     * Converts an integer to its Roman numeral representation 
     * and returns it as an ASCII art string.
     *
     * @param num the integer to be converted
     * @return a multi-line string containing the ASCII art of the Roman numeral
     */
    public static String print(int num) {
        return printAsciiArt(IntegerToRoman.convert(num));
    }

    /**
     * Generates the complete ASCII art for a given Roman numeral string.
     * The output is built row by row based on the 6-line height of the characters.
     *
     * @param romanNumber the string of Roman characters to be converted
     * @return the constructed multi-line ASCII art string
     */
    private static String printAsciiArt(String romanNumber) {
        StringBuilder result = new StringBuilder();

        for (int row = 0; row < 6; row++) {
            for (char c : romanNumber.toCharArray()) {
                result.append(getCharRow(c, row));
            }
            if (row < 5) {
                result.append("\n");
            }
        }

        return result.toString();
    }

    /**
     * Retrieves a specific row of the ASCII art matrix for a given character.
     *
     * @param c the Roman numeral character 
     * @param row the index of the row to retrieve (from 0 to 5)
     * @return the string corresponding to the specified row of the character, 
     * or an empty string if the character is not recognized
     */
    private static String getCharRow(char c, int row) {
        return switch (c) {
            case 'I' -> CHAR_I[row];
            case 'V' -> CHAR_V[row];
            case 'X' -> CHAR_X[row];
            case 'L' -> CHAR_L[row];
            case 'C' -> CHAR_C[row];
            case 'D' -> CHAR_D[row];
            case 'M' -> CHAR_M[row];
            default -> "";
        };
    }
}

