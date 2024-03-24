import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Homework 36.
 *
 * @author Tory Yang
 */
public final class Homework36 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Homework36() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments;
     */
    public static void main(String[] args) {

        SimpleReader inFile = new SimpleReader1L(args[0]);
        SimpleWriter outFile = new SimpleWriter1L(args[1]);

        while (!inFile.atEOS()) {
            String line = inFile.nextLine();
            outFile.println();
        }

        inFile.close();
        outFile.close();
    }

    /**
     * Main method 2.
     *
     * @param args
     *            the command line arguments;
     */
    public static void main2(String[] args)

            throws IOException {

        BufferedReader input = new BufferedReader(new FileReader(args[0]));
        PrintWriter output = new PrintWriter(
                new BufferedWriter(new FileWriter(args[1])));

        String s = input.readLine();

        while (s != null) {
            output.println(s);
            s = input.readLine();
        }

        input.close();
        output.close();

    }

    /**
     * Main method 3.
     *
     * @param args
     *            the command line arguments;
     */
    public static void main3(String[] args) {

        String inFile = args[0];
        String outFile = args[1];
        BufferedReader input;
        PrintWriter output;

        try {
            input = new BufferedReader(new FileReader(inFile));
            output = new PrintWriter(
                    new BufferedWriter(new FileWriter(outFile)));
        } catch (IOException e) {
            System.err.println("Error opening file.");
            return;
        }
        try {
            String s = input.readLine();
            while (s != null) {
                output.println(s);
                s = input.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing to file.");
        }
        try {
            input.close();
            output.close();
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }
    }

}
