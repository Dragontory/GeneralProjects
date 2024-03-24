/**
 * Homework 11 hasCode() and Questions at the bottom.
 *
 *
 * @author Tory Yang
 *
 *
 */

/**
 * Simple class representing a 7-digit phone number in the form "XXX-XXXX" for a
 * phone in the immediate OSU area.
 */
public class PhoneNumber {

    /**
     * The phone number representation.
     */
    private String rep;

    /**
     * Constructor. {@code pNum} must be in the form "XXX-XXXX" where each "X"
     * is a digit '0'-'9'.
     */
    public PhoneNumber(String pNum) {
        this.rep = pNum;
    }

    @Override
    public int hashCode() {

        int total = 0;
        int digit = 0;
        for (int i = 0; i < this.rep.length(); i++) {
            if (this.rep.charAt(i) != '-') {
                digit = Character.digit(this.rep.charAt(i), 10);
                total += digit;
            }
        }

        return total;

    }

}

/*
 * 2. i) The problem would be that the characters "O", "H", "I", and "O" might
 * have different character values so summing the digits would give
 * incorrect/different values. In the implementation it says that character
 * values return different values.
 *
 *
 * ii) The hash function can be changed to handle phone numbers like "292-OHIO"
 * and "292-6446" by manipulating/offsetting the values. This can probably be
 * done using some formula involving subtraction and/or division.
 *
 * iii) The hash function can be changed to handle lower case and uppercase by
 * first determining if each character is lower case or upper case and then
 * providing the proper formula/change.
 *
 */
