import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Homework 26 Methods.
 *
 * @author Tory Yang
 *
 */
public final class Homework26 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework26() {
    }

    /**
     * Definition of whitespace separators.
     */
    private static final String SEPARATORS = " \t\n\r";

    /**
     * Token to mark the end of the input. This token cannot come from the input
     * stream because it contains whitespace.
     */
    public static final String END_OF_INPUT = "### END OF INPUT ###";

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code SEPARATORS}) or "separator string" (maximal length string of
     * characters in {@code SEPARATORS}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection entries(SEPARATORS) = {}
     * then
     *   entries(nextWordOrSeparator) intersection entries(SEPARATORS) = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection entries(SEPARATORS) /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of entries(SEPARATORS)  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of entries(SEPARATORS))
     * </pre>
     */
    private static String nextWordOrSeparator(String text, int position) {

        Set<Character> sepSet = new Set1L<Character>();

        for (int i = 0; i < SEPARATORS.length(); i++) {
            char c = SEPARATORS.charAt(i);
            if (!sepSet.contains(c)) {
                sepSet.add(c);
            }
        }
        int i = position;

        //if first character is separator, skip it
        if (sepSet.contains(text.charAt(i))) {
            while (i < text.length() && sepSet.contains(text.charAt(i))) {
                i++;
            }
        } else { //if first character is not separator, find first word

            while (i < text.length() && !sepSet.contains(text.charAt(i))) {
                i++;
            }

        }
        //return first word
        return text.substring(position, i);

    }

    /**
     * Tokenizes the entire input getting rid of all whitespace separators and
     * returning the non-separator tokens in a {@code Queue<String>}.
     *
     * @param in
     *            the input stream
     * @return the queue of tokens
     * @updates in.content
     * @requires in.is_open
     * @ensures <pre>
     * tokens =
     *   [the non-whitespace tokens in #in.content] * <END_OF_INPUT>  and
     * in.content = <>
     * </pre>
     */
    public static Queue<String> tokens(SimpleReader in) {

        Queue<String> qTokens = new Queue1L<String>();

        while (!in.atEOS()) {

            int position = 0;
            String line = in.nextLine();

            while (position < line.length()) {

                String word = nextWordOrSeparator(line, position);

                if (!SEPARATORS
                        .contains(line.substring(position, position + 1))) {
                    qTokens.enqueue(word);

                }
                position += word.length();
            }
        }
        qTokens.enqueue(END_OF_INPUT);

        return qTokens;
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
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
