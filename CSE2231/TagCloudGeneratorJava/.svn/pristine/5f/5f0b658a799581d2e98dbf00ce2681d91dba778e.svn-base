import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Tag Cloud Generator.
 *
 * @author Tory Yang, Ryan Liu
 */
public final class TagCloudGenerator {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private TagCloudGenerator() {
        // no code needed here
    }

    /**
     * Compare {@code String}s in lexicographic order.
     */
    private static class StringLTM
            implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1,
                Map.Entry<String, Integer> o2) {
            return o1.getKey().compareTo(o2.getKey()); // sort a-z, 'A' is first
        }
    }

    /**
     * Compare {@code Integer}s in lexicographic order.
     */
    private static class IntegerLT
            implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1,
                Map.Entry<String, Integer> o2) {
            return o2.getValue().compareTo(o1.getValue()); // sort highest quantity first
        }
    }

    /**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param charSet
     *            the {@code Set} to be replaced
     * @replaces charSet
     * @ensures charSet = entries(str)
     */
    private static void generateElements(String str, Set<Character> charSet) {
        assert str != null : "Violation of: str is not null";
        assert charSet != null : "Violation of: charSet is not null";

        int i = 0;
        /*
         * loop around and add characters to the set one by one
         */
        while (i < str.length()) {
            if (!charSet.contains(str.charAt(i))) {
                charSet.add(str.charAt(i));
            }
            i++;

        }
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
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
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
     *      is not subset of separators)
     * </pre>
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        assert text != null : "Violation of: text is not null";
        assert separators != null : "Violation of: separators is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";

        String positionText = text.substring(position);
        char nextChar;
        int i = 0;
        String returnedString = "";
        boolean separator;
        /*
         * check which, either sep or word
         */
        if (separators.contains(positionText.charAt(0))) {
            separator = true;
        } else {
            separator = false;
        }
        if (separator) { // separator
            while (separator && i < positionText.length()) {

                nextChar = positionText.charAt(i);
                separator = separators.contains(nextChar);
                if (separator) {
                    returnedString += nextChar;
                }
                i++;

            }
        } else { // word
            while (!separator && i < positionText.length()) {
                nextChar = positionText.charAt(i);
                separator = separators.contains(nextChar);
                if (!separator) {
                    returnedString += nextChar;
                }
                i++;
            }
        }

        return returnedString;
    }

    /**
     * Prints the index html page's header.
     *
     * @param fout
     *            the index html file that is being written to
     * @param file
     *            the name of the file that is being read
     * @param numWords
     *            the top number of words to print out
     */
    private static void printIndexHeader(PrintWriter fout, String file,
            int numWords) {
        // Print out the headers for the index file
        fout.println("<html>");
        fout.println("<head>");
        fout.println(
                "<title> Top " + numWords + " words in " + file + " </title>");
        fout.print(
                "<link href=\"http://web.cse.ohio-state.edu/software/2231/web-sw2/");
        fout.print(
                "assignments/projects/tag-cloud-generator/data/tagcloud.css\" ");
        fout.println("rel=\"stylesheet\" type=\"text/css\"> ");
        fout.println(
                "<link href=\"tagcloud.css\" rel=\"stylesheet\" type=\"text/css\">");
        fout.println("</head>");
        fout.println("<body>");
        // file name required!
        fout.println("<h2> Top " + numWords + " words in " + file + " </h2>");
        fout.println("<hr>");
    }

    /**
     * Gets one line at a time from {@code in} until end of input, and puts them
     * into the queue {@code words} after changing to lower case and splitting
     * by word.
     *
     * @param in
     *            the source of the lines to be input
     * @param words
     *            the queue words are added to
     * @param separators
     *            the set of characters to be used as separators
     * @throws IOException
     * @updates in
     * @replaces words
     * @requires in.is_open
     * @ensures <pre>
     * in.is_open  and
     * in.ext_name = #in.ext_name  and
     * in.content = ""  and
     * words = WORDS(#in.content)
     * </pre>
     */
    private static void getWordsFromInput(BufferedReader in,
            Queue<String> words, Set<Character> separators) throws IOException {
        assert in != null : "Violation of: in is not null";
        assert words != null : "Violation of: words is not null";
        //assert in.isOpen() : "Violation of: in.is_open";

        int position = 0;
        String str;
        while ((str = in.readLine()) != null) { // keep scanning until end of file

            str = str.toLowerCase();
            position = 0;
            /*
             * this actually adds the words to the queue
             */
            while (position < str.length()) {
                String token = nextWordOrSeparator(str, position, separators);
                if (!separators.contains(token.charAt(0))) {
                    words.add(token);
                }
                position += token.length();
            }

        }
    }

    /**
     * Prints out the body of the table of words and counts into @code fout.
     *
     * @param map
     *            the map to be written to
     * @param words
     *            the queue of words, sorted
     * @requires {@code words} has been sorted properly
     *
     * @replaces words
     */
    private static void createMap(Map<String, Integer> map,
            Queue<String> words) {
        while (words.size() > 0) {
            String word = words.remove();
            int quantity = 1;
            while (words.size() > 0 && word.equals(words.peek())) {
                words.remove();
                quantity++;
            }

            if (map.containsKey(word)) {
                map.replace(word, map.get(word) + quantity);
            } else {
                map.put(word, quantity);
            }
        }

    }

    /**
     * Sorts the top number of words of the user's choosing alphabetically.
     * Prints out the body of the table and counts into @code fout.
     *
     * @param fout
     *            the index html file that is being written to
     * @param sorted
     * @param numWords
     *            the top number of words to print out
     * @param maxCt
     *            the count of the word that appears the most
     * @param minCt
     *            the count of the word that appears the least
     *
     * @updates ssm
     */
    private static void generateBody(PrintWriter fout,
            List<Map.Entry<String, Integer>> sorted, int numWords, int maxCt,
            int minCt) {
        // max count and min count for the tag cloud

        int j = 0;
        double maxValue = maxCt - minCt;
        final int num1 = 37, num2 = 11;

        while (j < numWords) {
            //Map.Entry<String, Integer> mp = sorted.remove(sorted.firstEntry());
            Map.Entry<String, Integer> mp = sorted.remove(0);
            String key = mp.getKey();
            int value = mp.getValue();

            // first part will be decimal 0 to 1, so multiply by 37 and shift 11
            // to get f11-f48 from stylesheet css (cast to int)
            int fontSize = (int) ((value - minCt) / maxValue * num1 + num2);
            fout.print("<span style=\"cursor:default\" class = \"f" + fontSize
                    + "\" ");
            fout.println("title = \"" + value + "\">" + key + "</span>");
            j++;
        }

        fout.println("</p>");
        fout.println("</div>");
        fout.println("</body>");
        fout.println("</html>");

    }

    /**
     * Assign quantities to words in map in alphabetical order + n highest
     * counts.
     *
     * @param m
     *            of the words and quantities
     * @param n
     *            number of words to display
     * @clears n
     * @return list of entries in map with words counts
     * @ensures list returned only contains entries from map
     */
    private static List<Map.Entry<String, Integer>> sortWords(
            Map<String, Integer> m, int n) {
        //Initializes comparators (alphabetical and numerical)
        Comparator<Map.Entry<String, Integer>> ci = new IntegerLT();
        Comparator<Map.Entry<String, Integer>> cs = new StringLTM();

        //Sorts map by word count
        List<Map.Entry<String, Integer>> lsorted;
        lsorted = new LinkedList<Map.Entry<String, Integer>>(m.entrySet());
        Collections.sort(lsorted, ci);

        //Sorts by alphabetical order
        List<Map.Entry<String, Integer>> sublsorted = lsorted.subList(0, n);
        Collections.sort(sublsorted, cs);
        return sublsorted;

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     * @throws IOException
     * @throws NumberFormatException
     */
    public static void main(String[] args)
            throws NumberFormatException, IOException {

        /*
         * Define separator characters for test
         */
        final String separatorStr = " \t\n\r,-.!?[]';:/()_";
        Set<Character> separatorSet = new HashSet<>();
        generateElements(separatorStr, separatorSet);

        /*
         * Open System input stream.
         */
        String inFile = "";
        String outFile = "";
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));

        /*
         * Checks whether output file names are valid.
         */
        try {
            System.out.println(
                    "Enter the file name to output to, including the .html extension: ");
            outFile = in.readLine(); // taking string input
        } catch (Exception e) {
            System.out.println("Error reading output file name");
        }

        try {
            System.out.println(
                    "Enter the file name to read input from, including the extension: ");
            inFile = in.readLine(); // taking string input
        } catch (Exception e) {
            System.out.println("Error reading input file name");
        }

        Queue<String> lines = new LinkedList<>(); // new queue for words of input file

        BufferedReader input;
        PrintWriter output;

        /*
         * Opens input and ouput streams.
         */
        try {
            input = new BufferedReader(new FileReader(inFile));
            output = new PrintWriter(
                    new BufferedWriter(new FileWriter(outFile)));
        } catch (IOException e) {
            System.err.println("Error opening file.");
            return;
        }
        try {

            getWordsFromInput(input, lines, separatorSet); // call method to add words

            // checks for proper input
            System.out.print("Enter the top __ words to register: ");
            int numWords = Integer.parseInt(in.readLine());
            while (numWords < 0 || numWords > lines.size()) {
                System.out.println("Invalid Input (input cannot be negative or "
                        + "greater than the word count).");
                System.out.print("Please enter a valid input");
                numWords = Integer.parseInt(in.readLine());
            }

            // print the header of the html file
            printIndexHeader(output, outFile, numWords);

            //Adds words and word counts to a hash map
            Map<String, Integer> map1 = new HashMap<>();
            createMap(map1, lines); // words with quantity

            //Sorts words
            List<Map.Entry<String, Integer>> listSorted = sortWords(map1,
                    numWords);

            output.println("<div class = \"cdiv\">");
            output.println("<p class = \"cbox\">");

            //Checks minimum count and maximum count
            int minCount = 0;
            int maxCount = 0;

            for (Map.Entry<String, Integer> wordCount : listSorted) {
                int count = wordCount.getValue();

                if (count > maxCount) {
                    maxCount = count;
                } else if (count < minCount) {
                    minCount = count;
                }
            }

            //Generates body of output file
            generateBody(output, listSorted, numWords, maxCount, minCount);

        } catch (IOException e) {
            System.err.println("Error reading or writing to file.");
        }
        try {
            /*
             * Close input and output streams
             */
            in.close();
            System.out.close();
            input.close();
            output.close();
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }

    }
}
