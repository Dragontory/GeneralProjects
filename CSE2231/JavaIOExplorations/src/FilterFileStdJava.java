import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * Program to copy a text file into another file.
 *
 * @author Tory Yang
 *
 */
public final class FilterFileStdJava {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private FilterFileStdJava() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments: input-file-name output-file-name
     */
    public static void main(String[] args) {

        // TODO - fill in body
        String inFile = args[0];
        String outFile = args[1];
        String filterFile = args[2];
        BufferedReader input, filter;
        PrintWriter output;

        try {
            input = new BufferedReader(new FileReader(inFile));
            filter = new BufferedReader(new FileReader(filterFile));
            output = new PrintWriter(
                    new BufferedWriter(new FileWriter(outFile)));
        } catch (IOException e) {
            System.err.println("Error opening file.");
            return;
        }
        try {
            java.util.Set<String> filterString = new HashSet<>();
            String f = filter.readLine();

            while (f != null) {
                filterString.add(f);
                f = filter.readLine();
            }

            String s = input.readLine();
            while (s != null) {
                int count = 0;
                java.util.Iterator<String> iter = filterString.iterator();

                while (iter.hasNext()) {

                    String line = iter.next();

                    if (s.indexOf(line) > -1 && count == 0) {
                        output.println(s);
                        count++;
                    }

                }

                s = input.readLine();
                count = 0;
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing to file.");
        }
        try {
            input.close();
            output.close();
            filter.close();
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }

    }

}
