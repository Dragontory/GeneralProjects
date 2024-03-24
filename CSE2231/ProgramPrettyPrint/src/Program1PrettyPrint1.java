import components.map.Map;
import components.program.Program;
import components.program.Program1;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.statement.Statement;

/**
 * Layered implementation of secondary method {@code prettyPrint} for
 * {@code Program}.
 */
public final class Program1PrettyPrint1 extends Program1 {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Constructs into the given {@code Program} the program read from the given
     * input file.
     *
     * @param fileName
     *            the name of the file containing the program
     * @param p
     *            the constructed program
     * @replaces p
     * @requires [fileName is the name of a file containing a valid BL program]
     * @ensures p = [program from file fileName]
     */
    private static void loadProgram(String fileName, Program p) {
        SimpleReader in = new SimpleReader1L(fileName);
        p.parse(in);
        in.close();
    }

    /**
     * Prints the given number of spaces to the given output stream.
     *
     * @param out
     *            the output stream
     * @param numSpaces
     *            the number of spaces to print
     * @updates out.content
     * @requires out.is_open and spaces >= 0
     * @ensures out.content = #out.content * [numSpaces spaces]
     */
    private static void printSpaces(SimpleWriter out, int numSpaces) {
        for (int i = 0; i < numSpaces; i++) {
            out.print(' ');
        }
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Program1PrettyPrint1() {
        super();
    }

    /*
     * Secondary methods ------------------------------------------------------
     */

    @Override
    public void prettyPrint(SimpleWriter out) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        // TODO - fill in body
        String name = this.name();
        out.println("PROGRAM" + name + "IS");

        Map<String, Statement> context = this.newContext();
        this.swapContext(context);

        for (Map.Pair<String, Statement> x : context) {
            printSpaces(out, INDENT_SIZE);
            out.println("INSTRUCTION " + x.key() + " IS");
            //printSpaces(out, 2 * INDENT_SIZE);
            //out.println(x.value());
            x.value().prettyPrint(out, 2 * INDENT_SIZE);
            printSpaces(out, INDENT_SIZE);
            out.println("END" + x.key() + "\n");
        }
        this.swapContext(context);

        Statement body = this.newBody();
        this.swapBody(body);
        out.println("BEGIN");
        //printSpaces(out, INDENT_SIZE);
        body.prettyPrint(out, INDENT_SIZE);
        this.swapBody(body);

        out.println("END " + name);

    }

    void renameInstruction(Statement s, String oldName, String newName) {

    }

    void renameInstruction(Program p, String oldName, String newName) {
        Map<String, Statement> context = p.newContext();
        p.swapContext(context);

        for (Map.Pair<String, Statement> x : context) {
            this.renameInstruction(x.value(), oldName, newName);
        }
        p.swapContext(context);

        Statement body = p.newBody();
        this.swapBody(body);
        this.renameInstruction(body, oldName, newName);
        p.swapBody(body);
    }

    /*
     * Main test method -------------------------------------------------------
     */

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
         * Get input file name
         */
        out.print("Enter valid BL program file name: ");
        String fileName = in.nextLine();
        /*
         * Generate expected output in file "data/expected-output.txt"
         */
        out.println("*** Generating expected output ***");
        Program p1 = new Program1();
        loadProgram(fileName, p1);
        SimpleWriter ppOut = new SimpleWriter1L("data/expected-output.txt");
        p1.prettyPrint(ppOut);
        ppOut.close();
        /*
         * Generate actual output in file "data/actual-output.txt"
         */
        out.println("*** Generating actual output ***");
        Program p2 = new Program1PrettyPrint1();
        loadProgram(fileName, p2);
        ppOut = new SimpleWriter1L("data/actual-output.txt");
        p2.prettyPrint(ppOut);
        ppOut.close();
        /*
         * Check that prettyPrint restored the value of the program
         */
        if (p2.equals(p1)) {
            out.println("Program value restored correctly.");
        } else {
            out.println("Error: program value was not restored.");
        }

        in.close();
        out.close();
    }

}
