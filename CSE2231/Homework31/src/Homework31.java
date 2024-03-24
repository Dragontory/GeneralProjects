import components.map.Map;
import components.program.Program.Instruction;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.statement.Statement;
import components.statement.StatementKernel.Condition;

/**
 * Homework 31 Methods.
 *
 * @author Tory Yang
 *
 */
public final class Homework31 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework31() {
    }

    /**
     * Converts {@code Condition} into corresponding conditional jump
     * instruction byte code.
     *
     * @param c
     *            the {@code Condition} to be converted
     * @return the conditional jump instruction byte code corresponding to
     *         {@code c}
     * @ensures <pre>
     * conditionalJump =
     *  [conditional jump instruction byte code corresponding to c]
     * </pre>
     */
    private static Instruction conditionalJump(Condition c) {
        return null;
    }

    /**
     * Generates the sequence of virtual machine instructions ("byte codes")
     * corresponding to {@code s} and appends it at the end of {@code cp}.
     *
     * @param s
     *            the {@code Statement} for which to generate code
     * @param context
     *            the {@code Context} in which to find user defined instructions
     * @param cp
     *            the {@code Sequence} containing the generated code
     * @updates cp
     * @ensures <pre>
     * if [all instructions called in s are either primitive or
     *     defined in context]  and
     *    [context does not include any calling cycles, i.e., recursion] then
     *  cp = #cp * [sequence of virtual machine "byte codes" corresponding to s]
     * else
     *  [reports an appropriate error message to the console and terminates client]
     * </pre>
     */
    private static void generateCodeForStatement(Statement s,
            Map<String, Statement> context, Sequence<Integer> cp) {

        final int dummy = 0;

        switch (s.kind()) {
            case BLOCK: {

                // TODO - fill in case
                Statement b = s.newInstance();
                for (int index = 0; index < s.lengthOfBlock(); index++) {
                    b = s.removeFromBlock(index);
                    generateCodeForStatement(b, context, cp);
                    s.addToBlock(index, b);
                }

                break;
            }
            case IF: {
                Statement b = s.newInstance();
                Condition c = s.disassembleIf(b);
                cp.add(cp.length(), conditionalJump(c).byteCode());
                int jump = cp.length();
                cp.add(cp.length(), dummy);
                generateCodeForStatement(b, context, cp);
                cp.replaceEntry(jump, cp.length());
                s.assembleIf(c, b);
                break;
            }
            case IF_ELSE: {

                // TODO - fill in case
                Statement s1 = s.newInstance();
                Statement s2 = s.newInstance();
                Condition c = s.disassembleIfElse(s1, s2);
                cp.add(cp.length(), conditionalJump(c).byteCode());
                int jump1 = cp.length();
                cp.add(cp.length(), dummy);
                generateCodeForStatement(s1, context, cp);
                cp.add(cp.length(), 6);
                int jump2 = cp.length();
                cp.add(cp.length(), dummy);
                cp.replaceEntry(jump1, cp.length());
                generateCodeForStatement(s2, context, cp);
                cp.replaceEntry(jump2, cp.length());
                s.assembleIfElse(c, s1, s2);

                break;
            }
            case WHILE: {

                // TODO - fill in case
                Statement b = s.newInstance();
                Condition c = s.disassembleWhile(b);
                int k = cp.length();
                cp.add(cp.length(), conditionalJump(c).byteCode());
                int jump = cp.length();
                cp.add(cp.length(), dummy);
                generateCodeForStatement(b, context, cp);
                cp.add(cp.length(), 6);
                cp.add(cp.length(), k);
                cp.replaceEntry(jump, cp.length());
                s.assembleWhile(c, b);

                break;
            }
            case CALL: {

                // TODO - fill in case
                String instr = s.disassembleCall();
                if (instr.equals("move")) {
                    cp.add(cp.length(), 0);
                } else if (instr.equals("turnleft")) {
                    cp.add(cp.length(), 1);
                } else if (instr.equals("turnright")) {
                    cp.add(cp.length(), 2);
                } else if (instr.equals("infect")) {
                    cp.add(cp.length(), 3);
                } else if (instr.equals("skip")) {
                    cp.add(cp.length(), 4);
                } else {
                    Map.Pair<String, Statement> c = context.remove(instr);
                    Statement body = c.value();
                    context.add(instr, body);
                    generateCodeForStatement(c.value(), context, cp);
                }
                s.assembleCall(instr);

                break;
            }
            default: {
                // nothing to do here: this will never happen...
                break;
            }
        }
    }

    /**
     * Generates and returns the sequence of virtual machine instructions ("byte
     * codes") corresponding to {@code this}.
     *
     * @return the compiled program
     * @ensures <pre>
     * if [all instructions called in this are either primitive or
     *     defined in this.context]  and
     *    [this does not include any calling cycles, i.e., recursion] then
     *  generatedCode =
     *   [the sequence of virtual machine "byte codes" corresponding to this]
     * else
     *  [reports an appropriate error message to the console and terminates client]
     * </pre>
     */
    public Sequence<Integer> generatedCode() {
        Sequence<Integer> cp = new Sequence1L<Integer>();
        Map<String, Statement> ctxt = this.newContext();
        this.swapContext(ctxt);
        Statement body = this.newBody();
        this.swapBody(body);
        generateCodeForStatement(body, ctxt, cp);
        cp.add(cp.length(), 5);
        this.swapContext(ctxt);
        this.swapBody(body);
        return cp;
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
