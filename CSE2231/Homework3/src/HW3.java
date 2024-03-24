import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class HW3 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HW3() {
    }

    /**
     * Smooths a given {@code Sequence<Integer>}.
     *
     * @param s1
     *            the sequence to smooth
     *
     * @return s2
     * @requires |s1| >= 1
     * @ensures <pre>
     * |s2| = |s1| - 1  and
     *  for all i, j: integer, a, b: string of integer
     *      where (s1 = a * <i> * <j> * b)
     *    (there exists c, d: string of integer
     *       (|c| = |a|  and
     *        s2 = c * <(i+j)/2> * d))
     * </pre>
     */
    public static Sequence<Integer> smooth(Sequence<Integer> s1) {

        Sequence<Integer> s2 = new Sequence1L<>();

        if (!(s1.length() == 1)) {

            int k = 0;
            int j = 0;
            while (k + 1 < s1.length()) {

                int num1 = s1.remove(0);
                s1.add(s1.length(), num1);
                k++;

                int num2 = s1.remove(0);
                s1.add(0, num2);

                s2.add(j, (num1 + num2) / 2);

                j++;
            }

            int num = s1.remove(0);
            s1.add(s1.length(), num);
        }

        return s2;
    }

    /**
     * Smooths a given {@code Sequence<Integer>}.
     *
     * @param s1
     *            the sequence to smooth
     *
     * @return s2
     * @requires |s1| >= 1
     * @ensures <pre>
     * |s2| = |s1| - 1  and
     *  for all i, j: integer, a, b: string of integer
     *      where (s1 = a * <i> * <j> * b)
     *    (there exists c, d: string of integer
     *       (|c| = |a|  and
     *        s2 = c * <(i+j)/2> * d))
     * </pre>
     */
    public static Sequence<Integer> smoothRecursive(Sequence<Integer> s1) {

        Sequence<Integer> s2 = new Sequence1L<>();

        if (!(s1.length() == 1)) {

            int num1 = s1.remove(0);
            int num2 = s1.remove(0);

            s1.add(0, num2);

            s2.transferFrom(smoothRecursive(s1));

            s2.add(0, (num1 + num2) / 2);

            s1.add(s1.length(), num1);

        }
        return s2;

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
        Sequence<Integer> test = new Sequence1L<>();
        test.add(0, 6);
        test.add(0, 4);
        test.add(0, 2);

        out.println(smooth(test));

        out.println(smoothRecursive(test));

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
