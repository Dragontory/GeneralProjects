import components.binarytree.BinaryTree;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Homework 14 Binary Search Tree Methods.
 *
 * @author Tory Yang
 *
 */
public final class Homework14 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework14() {
    }

    /**
     * Returns whether {@code x} is in {@code t}.
     *
     * @param <T>
     *            type of {@code BinaryTree} labels
     * @param t
     *            the {@code BinaryTree} to be searched
     * @param x
     *            the label to be searched for
     * @return true if t contains x, false otherwise
     * @requires IS_BST(t)
     * @ensures isInTree = (x is in labels(t))
     */
    public static <T extends Comparable<T>> boolean isInTree(BinaryTree<T> t,
            T x) {
        boolean flag = false;
        BinaryTree<T> leftTree = t.newInstance();
        BinaryTree<T> rightTree = t.newInstance();

        if (t.height() > 0) {
            T root = t.disassemble(leftTree, rightTree);

            if (root.compareTo(x) > 0) {
                isInTree(leftTree, x);
            } else if (root.compareTo(x) < 0) {
                isInTree(rightTree, x);
            } else {
                flag = true;
            }
            t.assemble(root, leftTree, rightTree);
        }

        return flag;
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
