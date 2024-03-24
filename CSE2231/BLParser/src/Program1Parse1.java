import components.map.Map;
import components.program.Program;
import components.program.Program1;
import components.queue.Queue;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.statement.Statement;
import components.utilities.Reporter;
import components.utilities.Tokenizer;

/**
 * Layered implementation of secondary method {@code parse} for {@code Program}.
 *
 * @author Ryan Liu, Tory Yang
 *
 */
public final class Program1Parse1 extends Program1 {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Parses a single BL instruction from {@code tokens} returning the
     * instruction name as the value of the function and the body of the
     * instruction in {@code body}.
     *
     * @param tokens
     *            the input tokens
     * @param body
     *            the instruction body
     * @return the instruction name
     * @replaces body
     * @updates tokens
     * @requires <pre>
     * [<"INSTRUCTION"> is a prefix of tokens]  and
     *  [<Tokenizer.END_OF_INPUT> is a suffix of tokens]
     * </pre>
     * @ensures <pre>
     * if [an instruction string is a proper prefix of #tokens]  and
     *    [the beginning name of this instruction equals its ending name]  and
     *    [the name of this instruction does not equal the name of a primitive
     *     instruction in the BL language] then
     *  parseInstruction = [name of instruction at start of #tokens]  and
     *  body = [Statement corresponding to the block string that is the body of
     *          the instruction string at start of #tokens]  and
     *  #tokens = [instruction string at start of #tokens] * tokens
     * else
     *  [report an appropriate error message to the console and terminate client]
     * </pre>
     */
    private static String parseInstruction(Queue<String> tokens,
            Statement body) {
        assert tokens != null : "Violation of: tokens is not null";
        assert body != null : "Violation of: body is not null";
        assert tokens.length() > 0 && tokens.front().equals("INSTRUCTION") : ""
                + "Violation of: <\"INSTRUCTION\"> is proper prefix of tokens";

        // TODO - fill in body
        String instr = tokens.dequeue();
        Reporter.assertElseFatalError(instr.equals("INSTRUCTION"),
                "Invalid token");

        String name1 = tokens.dequeue();
        Reporter.assertElseFatalError(Tokenizer.isIdentifier(name1),
                "Invalid identifier");

        String var = tokens.dequeue();
        Reporter.assertElseFatalError(var.equals("IS"), "Invalid token");

        body.parseBlock(tokens);

        String last = tokens.dequeue();
        Reporter.assertElseFatalError(last.equals("END"), "Invalid token");

        String name2 = tokens.dequeue();
        Reporter.assertElseFatalError(Tokenizer.isIdentifier(name2),
                "Invalid identifier");

        Reporter.assertElseFatalError(name1.equals(name2),
                "More than one identifier used as instruction name.");

        return name2;
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Program1Parse1() {
        super();
    }

    /*
     * Public methods ---------------------------------------------------------
     */

    @Override
    public void parse(SimpleReader in) {
        assert in != null : "Violation of: in is not null";
        assert in.isOpen() : "Violation of: in.is_open";
        Queue<String> tokens = Tokenizer.tokens(in);
        this.parse(tokens);
    }

    @Override
    public void parse(Queue<String> tokens) {
        assert tokens != null : "Violation of: tokens is not null";
        assert tokens.length() > 0 : ""
                + "Violation of: Tokenizer.END_OF_INPUT is a suffix of tokens";

        // TODO - fill in body
        String token1 = tokens.dequeue();
        Reporter.assertElseFatalError(token1.equals("PROGRAM"),
                "Invalid token");

        String sName = tokens.dequeue();
        Reporter.assertElseFatalError(Tokenizer.isIdentifier(sName),
                "Invalid identifier");

        String token2 = tokens.dequeue();
        Reporter.assertElseFatalError(token2.equals("IS"), "Invalid token");

        Map<String, Statement> ctxt = this.newContext();
        while (!tokens.front().equals("BEGIN")) {
            Statement body = this.newBody();
            String instr = parseInstruction(tokens, body);
            Reporter.assertElseFatalError(!Tokenizer.isKeyword(instr),
                    "Identifier cannot be a keyword.");
            Reporter.assertElseFatalError(!ctxt.hasKey(instr),
                    "Duplicate identifier.");
            ctxt.add(instr, body);
        }

        String temp = tokens.dequeue();
        Reporter.assertElseFatalError(temp.equals("BEGIN"), "Invalid token");

        Statement block = this.newBody();
        block.parseBlock(tokens);

        Reporter.assertElseFatalError(tokens.dequeue().equals("END"),
                "Invalid token");

        String eName = tokens.dequeue();
        Reporter.assertElseFatalError(Tokenizer.isIdentifier(eName),
                "Invalid identifier");

        Reporter.assertElseFatalError(sName.equals(eName),
                "More than one identifier.");

        String end = tokens.dequeue();
        Reporter.assertElseFatalError(end.equals(Tokenizer.END_OF_INPUT),
                "Program doesn't terminate.");

        this.swapContext(ctxt);
        this.swapBody(block);
        this.setName(sName);

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
         * Parse input file
         */
        out.println("*** Parsing input file ***");
        Program p = new Program1Parse1();
        SimpleReader file = new SimpleReader1L(fileName);
        Queue<String> tokens = Tokenizer.tokens(file);
        file.close();
        p.parse(tokens);
        /*
         * Pretty print the program
         */
        out.println("*** Pretty print of parsed program ***");
        p.prettyPrint(out);

        in.close();
        out.close();
    }

}
