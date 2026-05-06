////////////////////////////////////////////////////////////////////
// Alessandro Monni 2138005
// Filippo Lissandrin 2137980
////////////////////////////////////////////////////////////////////


package it.unipd.mtss;
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



    public static String print(int num) {
        return printAsciiArt(IntegerToRoman.convert(num));
    }

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

