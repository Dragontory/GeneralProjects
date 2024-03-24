import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program that takes in an input file and counts the number of word
 * occurrences. It then outputs an HTML file with a table of the words and each
 * of their counts in alphabetical order.
 *
 * @author Tory Yang
 *
 */
public final class WordCounter {
    /**
     * No argument constructor--private to prevent instantiation.
     */
    private WordCounter() {
    }

    /**
     * Comparator to sort strings in alphabetical order.
     */
    private static class LTString implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.toLowerCase().compareTo(s2.toLowerCase());
        }
    }

    /**
     * Reads in input file, putting the words and counts into a map.
     *
     * @param input
     *            input text file with words and counts
     * @return a map: <String word, Integer count>
     */
    private static Map<String, Integer> readWordsAndCounts(SimpleReader input) {

        //Creates new Map
        Map<String, Integer> wordCount = new Map1L<>();

        //creates set filled with separators
        Set<String> separators = new Set1L<>();
        separators.add(" ");
        separators.add(".");
        separators.add(",");
        separators.add("/");
        separators.add(":");
        separators.add(";");
        separators.add("\"");
        separators.add("?");
        separators.add("!");
        separators.add("-");
        separators.add("@");
        separators.add("#");
        separators.add("$");
        separators.add("%");
        separators.add("&");
        separators.add("(");
        separators.add(")");

        int pos = 0;
        int length;

        //Loops Through each line of the input
        while (!input.atEOS()) {
            //takes whole line as String
            String line = input.nextLine();
            pos = 0;
            //Goes through each word of each line
            while (pos < line.length()) {
                //Finds the first word/separator
                String wordOrSep = nextWordOrSeparator(line, pos, separators);
                length = wordOrSep.length();

                if (!separators.contains(wordOrSep)
                        && !separators.contains(wordOrSep.substring(0, 1))) {
                    //if word already in map, add 1 to count
                    //counts lower case and upper case words as the same
                    if (wordCount.hasKey(wordOrSep.toLowerCase())) {
                        wordCount.replaceValue(wordOrSep.toLowerCase(),
                                wordCount.value(wordOrSep.toLowerCase()) + 1);
                    } else { //if not, add new pair to map
                        wordCount.add(wordOrSep.toLowerCase(), 1);
                    }
                }

                pos += wordOrSep.length();

            }
        }

        return wordCount;
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires <pre>
     * {@code 0 <= position < |text|}
     * </pre>
     * @ensures <pre>
     * {@code nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)}
     * </pre>
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<String> separators) {
        assert text != null : "Violation of: text is not null";
        assert separators != null : "Violation of: separators is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";

        int i = position;

        //if first character is separator, skip it
        if (separators.contains(text.substring(position, position + 1))) {
            while (i < text.length()
                    && separators.contains(text.substring(i, i + 1))) {
                i++;
            }
        } else { //if first character is not separator, find first word

            while (i < text.length()
                    && !separators.contains(text.substring(i, i + 1))) {
                i++;
            }

        }
        //return first word
        return text.substring(position, i);
    }

    /**
     * Generates output HTML file, where each word is listed with its count in a
     * table.
     *
     * @param wordCount
     *            map: <String word,Integer count>
     * @param output
     *            name of output directory
     * @requires wordCount is not empty and contains the proper format of word
     *           as key and its count as the value and output is a proper
     *           folder/directory.
     *
     * @ensures wordCount is not modified
     */
    private static void generatePage(Map<String, Integer> wordCount,
            String output) {
        SimpleWriter out = new SimpleWriter1L(output);

        //create sorted queue
        Queue<String> words = new Queue1L<>();
        words.append(sortAlpha(wordCount));

        //Outputs header and creates table border style
        out.println("<html>");

        out.println("<style>");
        out.println("table, th, td {");
        out.println("border:1px solid black; }");
        out.println("</style>");

        //header
        out.println("<head>");
        out.println("<title>");
        out.println("Words Counted in " + output + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Word Count</h2>");

        //creates table with each row having a word and its count
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Word</th>");
        out.println("<th>Count</th>");
        out.println("</tr>");

        for (String x : words) {
            out.println("<tr>");
            out.println("<td>" + x + "</td>");
            out.println("<td>" + wordCount.value(x) + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }

    /**
     * Takes in a map of <String, Integer>, adding the words (keys) to a Queue
     * and sorting it into alphabetical order.
     *
     * @param wordCount
     *            input map: <String word, Integer count>
     * @return a Queue of the words sorted in alphabetical order case
     *         insensitive
     * @requires input Map is not empty
     * @ensures wordCount is not modified
     */
    private static Queue<String> sortAlpha(Map<String, Integer> wordCount) {
        //initializes queue and comparator
        Queue<String> sortedTerms = new Queue1L<>();
        Comparator<String> aSort = new LTString();

        //sorts queue alphabetically after inputting all terms into queue
        for (Map.Pair<String, Integer> x : wordCount) {
            sortedTerms.enqueue(x.key());
        }
        sortedTerms.sort(aSort);

        return sortedTerms;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        //opens streams
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //creates new map and Queue
        Map<String, Integer> wordCount = new Map1L<String, Integer>();
        Queue<String> words = new Queue1L<String>();

        //prompts user for input and output files
        out.println("Enter Input File Name: ");
        String input = in.nextLine();

        out.println("Enter Output File Name: ");
        String output = in.nextLine();

        SimpleReader inFile = new SimpleReader1L(input);

        //calls methods to complete task
        wordCount.transferFrom(readWordsAndCounts(inFile));
        words.append(sortAlpha(wordCount));
        generatePage(wordCount, output);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
