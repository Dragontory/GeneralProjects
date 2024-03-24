import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.statement.Statement;

/**
 * Homework 22 Method
 *
 * @author Tory Yang
 *
 */
public final class Homework22 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework22() {
    }

    /**
     * Reports the number of calls to primitive instructions (move, turnleft,
     * turnright, infect, skip) in a given {@code Statement}.
     *
     * @param s
     *            the {@code Statement}
     * @return the number of calls to primitive instructions in {@code s}
     * @ensures <pre>
     * countOfPrimitiveCalls =
     *  [number of calls to primitive instructions in s]
     * </pre>
     */
    public static int countOfPrimitiveCalls(Statement s) {
        int count = 0;
        switch (s.kind()) {
            case BLOCK: {
                /*
                 * Add up the number of calls to primitive instructions in each
                 * nested statement in the BLOCK.
                 */

                // TODO - fill in case
                for (int i = 0; i < s.lengthOfBlock(); i++) {
                    Statement temp = s.removeFromBlock(i);
                    count = count + countOfPrimitiveCalls(temp);
                    s.addToBlock(i, temp);

                }

                break;
            }
            case IF: {
                /*
                 * Find the number of calls to primitive instructions in the
                 * body of the IF.
                 */

                // TODO - fill in case

                Statement temp = s.newInstance();

                Statement.Condition temp2 = s.disassembleIf(temp);

                count = count + countOfPrimitiveCalls(temp);

                s.assembleIf(temp2, temp);

                break;
            }
            case IF_ELSE: {
                /*
                 * Add up the number of calls to primitive instructions in the
                 * "then" and "else" bodies of the IF_ELSE.
                 */

                // TODO - fill in case

                Statement tempIf = s.newInstance();
                Statement tempElse = s.newInstance();
                Statement.Condition temp = s.disassembleIfElse(tempIf,
                        tempElse);
                count = count + countOfPrimitiveCalls(tempIf)
                        + countOfPrimitiveCalls(tempElse);
                s.assembleIfElse(temp, tempIf, tempElse);

                break;
            }
            case WHILE: {
                /*
                 * Find the number of calls to primitive instructions in the
                 * body of the WHILE.
                 */

                // TODO - fill in case
                Statement temp = s.newInstance();
                Statement.Condition temp2 = s.disassembleWhile(temp);
                count = count + countOfPrimitiveCalls(temp);
                s.assembleWhile(temp2, temp);

                break;
            }
            case CALL: {
                /*
                 * This is a leaf: the count can only be 1 or 0. Determine
                 * whether this is a call to a primitive instruction or not.
                 */

                // TODO - fill in case
                String method = s.disassembleCall();
                if (method.equals("turnright") || method.equals("turnleft")
                        || method.equals("move") || method.equals("infect")
                        || method.equals("skip")) {
                    count++;
                }
                s.assembleCall(method);

                break;
            }
            default: {
                // this will never happen...can you explain why?
                break;
            }
        }
        return count;
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
