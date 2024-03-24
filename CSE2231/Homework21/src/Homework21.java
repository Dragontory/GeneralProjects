import java.util.Iterator;

import components.sequence.Sequence;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.tree.Tree;

/**
 * Methods for Homework 21.
 *
 * @author Tory Yang
 *
 */
public final class Homework21 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework21() {
    }

    /**
     * Returns the size of the given {@code Tree<T>}.
     *
     * @param <T>
     *            the type of the {@code Tree} node labels
     * @param t
     *            the {@code Tree} whose size to return
     * @return the size of the given {@code Tree}
     * @ensures size = |t|
     */
    public static <T> int size(Tree<T> t) {

        int size = 0;

        Sequence<Tree<T>> subTree = t.newSequenceOfTree();

        if (t.height() > 0) {

            T root = t.disassemble(subTree);

            for (int i = 0; i < subTree.length(); i++) {
                size = size + size(subTree.entry(i));
                size++;
            }

            t.assemble(root, subTree);

        }

        return size;
    }

    /**
     * Returns the size of the given {@code Tree<T>}.
     *
     * @param <T>
     *            the type of the {@code Tree} node labels
     * @param t
     *            the {@code Tree} whose size to return
     * @return the size of the given {@code Tree}
     * @ensures size = |t|
     */
    public static <T> int size2(Tree<T> t) {

        int size = 0;

        Iterator<T> temp = t.iterator();

        while (temp.hasNext()) {
            size++;
        }

        return size;
    }

    /**
     * Returns the height of the given {@code Tree<T>}.
     *
     * @param <T>
     *            the type of the {@code Tree} node labels
     * @param t
     *            the {@code Tree} whose height to return
     * @return the height of the given {@code Tree}
     * @ensures height = ht(t)
     */
    public static <T> int height(Tree<T> t) {
        int height = 0;
        int maxHeight = 0;

        Sequence<Tree<T>> subTree = t.newSequenceOfTree();

        if (t.size() > 0) {

            T root = t.disassemble(subTree);

            for (int i = 0; i < subTree.length(); i++) {
                if (height(subTree.entry(i)) > maxHeight) {
                    maxHeight = height(subTree.entry(i));
                }
            }

            maxHeight++;
            height = maxHeight;

            t.assemble(root, subTree);

        }

        return height;
    }

    /**
     * Returns the largest integer in the given {@code Tree<Integer>}.
     *
     * @param t
     *            the {@code Tree<Integer>} whose largest integer to return
     * @return the largest integer in the given {@code Tree<Integer>}
     * @requires |t| > 0
     * @ensures <pre>
     * max is in labels(t)  and
     * for all i: integer where (i is in labels(t)) (i <= max)
     * </pre>
     */
    public static int max(Tree<Integer> t) {
        int max = 0;

        Sequence<Tree<Integer>> subTree = t.newSequenceOfTree();

        if (t.height() != 0) {

            int root = t.disassemble(subTree);

            for (int i = 0; i < subTree.length(); i++) {
                max = max(subTree.entry(i));
                if (root > max) {
                    max = root;
                }
            }

            t.assemble(root, subTree);
        }

        return max;
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
