import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Homework 10 Methods.
 *
 * @author Tory Yang
 *
 */
public final class Homework10 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework10() {
    }

    /**
     * Computes {@code a} mod {@code b} as % should have been defined to work.
     *
     * @param a
     *            the number being reduced
     * @param b
     *            the modulus
     * @return the result of a mod b, which satisfies 0 <= {@code mod} < b
     * @requires b > 0
     * @ensures <pre>
     * 0 <= mod  and  mod < b  and
     * there exists k: integer (a = k * b + mod)
     * </pre>
     */
    public static int mod(int a, int b) {
        int remainder = a % b;

        if (remainder < 0) {
            remainder += b;
        }

        return remainder;
    }

    /**
     * Hashing function that computes the mod of the sum of the positive digits
     * of a and b.
     *
     * @param a
     *            the number being reduced
     * @param b
     *            the modulus
     * @return the result of sum of positive digits of a mod b
     *
     **/
    public static int mod2(int a, int b) {
        int sum = 0;

        if (a < 0) {
            a *= -1;
        }

        while (a != 0) {
            sum = sum + a % 10;
            a /= 10;
        }

        return sum % b;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        myMethod();
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
