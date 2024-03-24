import components.program.Program;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.statement.Statement;
import components.statement.StatementKernel.Condition;

/**
 * Method for Homework 24
 *
 * @author Tory Yang
 *
 */
public final class Homework24 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework24() {
    }

    /**
     * Pretty prints {@code this} to the given stream {@code out} {@code offset}
     * spaces from the left margin using
     * {@link components.program.Program#INDENT_SIZE Program.INDENT_SIZE} spaces
     * for each indentation level.
     *
     * @param out
     *            the output stream
     * @param offset
     *            the number of spaces to be placed before every nonempty line
     *            of output; nonempty lines of output that are indented further
     *            will, of course, continue with even more spaces
     * @updates out.content
     * @requires out.is_open and 0 <= offset
     * @ensures <pre>
     * out.content =
     *   #out.content * [this pretty printed offset spaces from the left margin
     *                   using Program.INDENT_SIZE spaces for indentation]
     * </pre>
     */
    public void prettyPrint(SimpleWriter out, int offset) {
        switch (this.kind()) {
            case BLOCK: {

                // TODO - fill in case
                for (int i = 0; i < this.lengthOfBlock(); i++) {
                    Statement s = this.removeFromBlock(i);
                    s.prettyPrint(out, offset);
                    this.addToBlock(i, s);
                }

                break;
            }
            case IF: {

                // TODO - fill in case
                Statement s = this.newInstance();
                Condition c = this.disassembleIf(s);

                printSpaces(out, offset);

                out.println("IF " + toStringCondition(c) + " THEN");

                s.prettyPrint(out, offset + Program.INDENT_SIZE);

                printSpaces(out, offset);

                out.println("END IF");

                this.assembleIf(c, s);

                break;
            }
            case IF_ELSE: {

                // TODO - fill in case

                Statement s1 = this.newInstance();
                Statement s2 = this.newInstance();
                Condition c = this.disassembleIfElse(s1, s2);

                printSpaces(out, offset);

                out.println("IF " + toStringCondition(c));
                s1.prettyPrint(out, offset + Program.INDENT_SIZE);

                printSpaces(out, offset);

                out.println("ELSE");

                s2.prettyPrint(out, offset + Program.INDENT_SIZE);

                this.assembleIfElse(c, s1, s2);
                break;

                break;
            }
            case WHILE: {

                // TODO - fill in case
                Statement s = this.newInstance();
                Condition c = this.disassembleWhile(s);

                printSpaces(out, offset);

                out.println("WHILE " + toStringCondition(c) + " DO");
                s.prettyPrint(out, offset + Program.INDENT_SIZE);

                printSpaces(out, offset);
                out.println("END WHILE");
                this.assembleWhile(c, s);

                break;
            }
            case CALL: {

                // TODO - fill in case
                String call = this.disassembleCall();

                printSpaces(out, offset);
                out.println(call);

                this.assembleCall(call);

                break;
            }
            default: {
                // this will never happen...
                break;
            }
        }
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
