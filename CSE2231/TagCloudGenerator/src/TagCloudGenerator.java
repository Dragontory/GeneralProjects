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
import components.sortingmachine.SortingMachine;
import components.sortingmachine.SortingMachine1L;

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
            implements Comparator<Map.Pair<String, Integer>> {
        @Override
        public int compare(Map.Pair<String, Integer> o1,
                Map.Pair<String, Integer> o2) {
            return o1.key().compareTo(o2.key()); // sort a-z, 'A' is first
        }
    }

    /**
     * Compare {@code Integer}s in lexicographic order.
     */
    private static class IntegerLT
            implements Comparator<Map.Pair<String, Integer>> {
        @Override
        public int compare(Map.Pair<String, Integer> o1,
                Map.Pair<String, Integer> o2) {
            return o2.value().compareTo(o1.value()); // sort highest quantity first
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
    private static void printIndexHeader(SimpleWriter fout, String file,
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
    private static void getWordsFromInput(SimpleReader in, Queue<String> words,
            Set<Character> separators) {
        assert in != null : "Violation of: in is not null";
        assert words != null : "Violation of: words is not null";
        assert in.isOpen() : "Violation of: in.is_open";

        int position = 0;
        String str;
        while (!in.atEOS()) { // keep scanning until end of file
            str = in.nextLine();
            str = str.toLowerCase();
            position = 0;
            /*
             * this actually adds the words to the queue
             */
            while (position < str.length()) {
                String token = nextWordOrSeparator(str, position, separators);
                if (!separators.contains(token.charAt(0))) {
                    words.enqueue(token);
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
        while (words.length() > 0) {
            String word = words.dequeue();
            int quantity = 1;
            while (words.length() > 0 && word.equals(words.front())) {
                words.dequeue();
                quantity++;
            }

            if (map.hasKey(word)) {
                map.replaceValue(word, map.value(word) + quantity);
            } else {
                map.add(word, quantity);
            }
        }

    }

    /**
     * Sorts the top number of words of the user's choosing alphabetically.
     * Prints out the body of the table and counts into @code fout.
     *
     * @param fout
     *            the index html file that is being written to
     * @param ssm
     *            the sorting machine containing the words
     * @param numWords
     *            the top number of words to print out
     * @param maxCt
     *            the count of the word that appears the most
     * @param minCt
     *            the count of the word that appears the least
     *
     * @updates ssm
     */
    private static void generateBody(SimpleWriter fout,
            SortingMachine<Map.Pair<String, Integer>> ssm, int numWords,
            int maxCt, int minCt) {
        // max count and min count for the tag cloud

        ssm.changeToExtractionMode();
        int j = 0;
        double maxValue = maxCt - minCt;
        final int num1 = 37, num2 = 11;

        while (j < numWords) {
            Map.Pair<String, Integer> mp = ssm.removeFirst();

            // first part will be decimal 0 to 1, so multiply by 37 and shift 11
            // to get f11-f48 from stylesheet css (cast to int)
            int fontSize = (int) ((mp.value() - minCt) / maxValue * num1
                    + num2);
            fout.print("<span style=\"cursor:default\" class = \"f" + fontSize
                    + "\" ");
            fout.println(
                    "title = \"" + mp.value() + "\">" + mp.key() + "</span>");
            j++;
        }

        fout.println("</p>");
        fout.println("</div>");
        fout.println("</body>");
        fout.println("</html>");

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {

        /*
         * Define separator characters for test
         */
        final String separatorStr = " \t\n\r,-.!?[]';:/()";
        Set<Character> separatorSet = new Set1L<>();
        generateElements(separatorStr, separatorSet);

        /*
         * Open input and output streams
         */
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        /*
         * Request file names to output and input to, unedited
         */
        out.print(
                "Enter the file name to output to, including the .html extension: ");
        String fileName = in.nextLine();
        SimpleWriter fout = new SimpleWriter1L(fileName);

        out.print(
                "Enter the file name to read input from, including the extension: ");
        fileName = in.nextLine();
        SimpleReader fin = new SimpleReader1L(fileName);

        Queue<String> lines = new Queue1L<>(); // new queue for words of input file
        getWordsFromInput(fin, lines, separatorSet); // call method to add words

        // checks for proper input
        out.print("Enter the top __ words to register: ");
        int numWords = in.nextInteger();
        while (numWords < 0 || numWords > lines.length()) {
            out.println("Invalid Input (input cannot be negative or "
                    + "greater than the word count).");
            out.print("Please enter a valid input");
            numWords = in.nextInteger();
        }

        printIndexHeader(fout, fileName, numWords); // print the header of the html file

        Map<String, Integer> map1 = new Map1L<>();
        createMap(map1, lines); // words with quantity
        Comparator<Map.Pair<String, Integer>> ci = new IntegerLT();
        SortingMachine<Map.Pair<String, Integer>> si = new SortingMachine1L<>(
                ci);
        while (map1.size() > 0) {
            si.add(map1.removeAny());
        }
        si.changeToExtractionMode();
        int i = 0;
        int minCount = 0;
        int maxCount = 0;
        while (i < numWords) {

            Map.Pair<String, Integer> mp = si.removeFirst();
            map1.add(mp.key(), mp.value());

            if (i == 0) {
                maxCount = mp.value();
            } else if (i == numWords - 1) {
                minCount = mp.value();
            }
            i++;
        }

        // comparator string map, sorting machine string map
        Comparator<Map.Pair<String, Integer>> csm = new StringLTM();
        SortingMachine<Map.Pair<String, Integer>> ssm = new SortingMachine1L<>(
                csm);
        fout.println("<div class = \"cdiv\">");
        fout.println("<p class = \"cbox\">");

        while (map1.size() > 0) {
            ssm.add(map1.removeAny());
        }
        generateBody(fout, ssm, numWords, maxCount, minCount);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
        fin.close();
        fout.close();
    }
}
