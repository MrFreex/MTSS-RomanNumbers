////////////////////////////////////////////////////////////////////
// Alessandro Monni 2138005
// Filippo Lissandrin 2137980
////////////////////////////////////////////////////////////////////


package it.unipd.mtss;
/**
 * Class that converts an integer number to a roman number
 * @author Filippo Lissandrin
 */
public class IntegerToRoman {
  static final String[] UNITS = {"C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};
  static final int[] UNIT_VALUES = {100, 90, 50, 40, 10, 9, 5, 4, 1};
  static final int MAX_VALUE = 388;
  /**
   * Method that converts an integer number to a roman number
   * @param number the integer number to convert
   * @return the roman number as a string
   * @throws IllegalArgumentException if the number is less than 1 or greater than 8 
   * (bigger numbers not implemented yet)
   */
  public static String convert(int number){
    if (number < 1 || number > MAX_VALUE) {
      throw new IllegalArgumentException("Number must be between 1 and " + MAX_VALUE);
    }

    String s = "";
    
    for (int i = 0; i < UNITS.length; i++) {
      while (number >= UNIT_VALUES[i]) {
        s += UNITS[i];
        number -= UNIT_VALUES[i];
      }
    }

    return s;
  }
}
