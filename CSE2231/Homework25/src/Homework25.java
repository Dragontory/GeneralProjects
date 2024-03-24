import components.map.Map;
import components.program.Program;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.statement.Statement;
import components.statement.StatementKernel.Condition;

/**
 * Homework 25 Methods.
 *
 * @author Tory Yang
 *
 */
public final class Homework25 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework25() {
    }

    /**
     * Refactors the given {@code Statement} by renaming every occurrence of
     * instruction {@code oldName} to {@code newName}. Every other statement is
     * left unmodified.
     *
     * @param s
     *            the {@code Statement}
     * @param oldName
     *            the name of the instruction to be renamed
     * @param newName
     *            the new name of the renamed instruction
     * @updates s
     * @requires [newName is a valid IDENTIFIER]
     * @ensures <pre>
     * s = [#s refactored so that every occurrence of instruction oldName
     *   is replaced by newName]
     * </pre>
     */
    public static void renameInstruction(Statement s, String oldName,
            String newName) {
        switch (s.kind()) {
            case BLOCK: {

                for (int i = 0; i < s.lengthOfBlock(); i++) {

                    Statement s1 = s.removeFromBlock(i);

                    renameInstruction(s1, oldName, newName);

                    s.addToBlock(i, s1);

                }

                break;
            }
            case IF: {

                Statement s1 = s.newInstance();

                Condition c = s.disassembleIf(s1);

                renameInstruction(s1, oldName, newName);

                s.assembleIf(c, s1);

            }
            case IF_ELSE: {

                Statement sIf = s.newInstance();
                Statement sElse = s.newInstance();

                Condition c = s.disassembleIfElse(sIf, sElse);

                renameInstruction(sIf, oldName, newName);
                renameInstruction(sElse, oldName, newName);

                s.assembleIfElse(c, sIf, sElse);

            }
            case WHILE: {

                Statement s1 = s.newInstance();

                Condition c = s.disassembleWhile(s1);

                renameInstruction(s1, oldName, newName);

                s.assembleWhile(c, s1);

            }

            case CALL: {

                String method = s.disassembleCall();

                if (method.equals(oldName)) {

                    s.assembleCall(newName);

                } else {

                    s.assembleCall(method);

                }
            }

            default:
                //this will never happen
                break;
        }
    }

    /**
     * Refactors the given {@code Program} by renaming instruction
     * {@code oldName}, and every call to it, to {@code newName}. Everything
     * else is left unmodified.
     *
     * @param p
     *            the {@code Program}
     * @param oldName
     *            the name of the instruction to be renamed
     * @param newName
     *            the new name of the renamed instruction
     * @updates p
     * @requires <pre>
     * oldName is in DOMAIN(p.context)  and
     * [newName is a valid IDENTIFIER]  and
     * newName is not in DOMAIN(p.context)
     * </pre>
     * @ensures <pre>
     * p = [#p refactored so that instruction oldName and every call
     *   to it are replaced by newName]
     * </pre>
     */
    public static void renameInstruction(Program p, String oldName,
            String newName) {
        Map<String, Statement> c = p.newContext();
        Map<String, Statement> ctxt = p.newContext();

        p.swapContext(ctxt);
        while (ctxt.size() > 0) {
            Map.Pair<String, Statement> instr = ctxt.removeAny();

            String key = instr.key();
            if (key.equals(oldName)) {
                key = newName;
            }

            renameInstruction(instr.value(), oldName, newName);

            c.add(key, instr.value());
        }

        p.swapContext(c);
        Statement pBody = p.newBody();

        p.swapBody(pBody);

        renameInstruction(pBody, oldName, newName);

        p.swapBody(pBody);
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
