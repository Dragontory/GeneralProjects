import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.statement.Statement;

/**
 * Homework 23 Method
 *
 * @author Tory Yang
 *
 */
public final class Homework23 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework23() {
    }

    /**
     * Refactors the given {@code Statement} so that every IF_ELSE statement
     * with a negated condition (NEXT_IS_NOT_EMPTY, NEXT_IS_NOT_ENEMY,
     * NEXT_IS_NOT_FRIEND, NEXT_IS_NOT_WALL) is replaced by an equivalent
     * IF_ELSE with the opposite condition and the "then" and "else" BLOCKs
     * switched. Every other statement is left unmodified.
     *
     * @param s
     *            the {@code Statement}
     * @updates s
     * @ensures <pre>
     * s = [#s refactored so that IF_ELSE statements with "not"
     *   conditions are simplified so the "not" is removed]
     * </pre>
     */
    public static void simplifyIfElse(Statement s) {
        switch (s.kind()) {
            case BLOCK: {

                // TODO - fill in case
                for (int i = 0; i < s.lengthOfBlock(); i++) {
                    Statement temp = s.removeFromBlock(i);

                    simplifyIfElse(temp);

                    s.addToBlock(i, temp);
                }

                break;
            }
            case IF: {

                // TODO - fill in case
                Statement temp = s.newInstance();

                Statement.Condition tempC = s.disassembleIf(temp);

                simplifyIfElse(temp);

                s.assembleIf(tempC, temp);

                break;
            }
            case IF_ELSE: {

                // TODO - fill in case
                Statement ifCondition = s.newInstance();
                Statement elseCondition = s.newInstance();
                Statement.Condition temp = s.disassembleIfElse(ifCondition,
                        elseCondition);
                switch (temp.name()) {
                    case "NEXT_IS_NOT_EMPTY": {
                        temp = temp.NEXT_IS_EMPTY;

                        simplifyIfElse(ifCondition);
                        simplifyIfElse(elseCondition);

                        s.assembleIfElse(temp, elseCondition, ifCondition);
                        break;
                    }
                    case "NEXT_IS_NOT_ENEMY": {
                        temp = temp.NEXT_IS_ENEMY;

                        simplifyIfElse(ifCondition);
                        simplifyIfElse(elseCondition);

                        s.assembleIfElse(temp, elseCondition, ifCondition);
                        break;

                    }
                    case "NEXT_IS_NOT_FRIEND": {
                        temp = temp.NEXT_IS_FRIEND;

                        simplifyIfElse(ifCondition);
                        simplifyIfElse(elseCondition);

                        s.assembleIfElse(temp, elseCondition, ifCondition);
                        break;

                    }
                    case "NEXT_IS_NOT_WALL": {
                        temp = temp.NEXT_IS_WALL;

                        simplifyIfElse(ifCondition);
                        simplifyIfElse(elseCondition);

                        s.assembleIfElse(temp, elseCondition, ifCondition);
                        break;

                    }
                    default: {
                        // this will never happen...can you explain why?
                        break;
                    }
                }
                break;
            }

            case WHILE: {

                // TODO - fill in case
                Statement temp = s.newInstance();

                Statement.Condition tempC = s.disassembleWhile(temp);

                simplifyIfElse(temp);

                s.assembleWhile(tempC, temp);

                break;
            }
            case CALL: {
                // nothing to do here...can you explain why?
                break;
            }
            default: {
                // this will never happen...can you explain why?
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
