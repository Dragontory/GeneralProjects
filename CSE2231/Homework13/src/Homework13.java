import components.binarytree.BinaryTree;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Homework 13 BinaryTree and Recursion II.
 *
 * @author Tory Yang
 *
 */
public final class Homework13 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework13() {
    }

    /**
     * Returns the {@code String} prefix representation of the given
     * {@code BinaryTree<T>}.
     *
     * @param <T>
     *            the type of the {@code BinaryTree} node labels
     * @param t
     *            the {@code BinaryTree} to convert to a {@code String}
     * @return the prefix representation of {@code t}
     * @ensures treeToString = [the String prefix representation of t]
     */
    public static <T> String treeToString(BinaryTree<T> t) {
        String tree = "";
        BinaryTree<T> leftTree = t.newInstance();
        BinaryTree<T> rightTree = t.newInstance();

        if (t.height() == 0) {
            tree = tree + "()";
        } else {
            T root = t.disassemble(leftTree, rightTree);

            tree = tree + root + "(" + treeToString(leftTree)
                    + treeToString(rightTree) + ")";

            t.assemble(root, leftTree, rightTree);
        }

        return tree;
    }

    /**
     * Returns a copy of the the given {@code BinaryTree}.
     *
     * @param t
     *            the {@code BinaryTree} to copy
     * @return a copy of the given {@code BinaryTree}
     * @ensures copy = t
     */
    public static BinaryTree<Integer> copy(BinaryTree<Integer> t) {
        BinaryTree<Integer> leftTree = t.newInstance();
        BinaryTree<Integer> rightTree = t.newInstance();
        BinaryTree<Integer> copyTree = t.newInstance();

        if (t.height() != 0) {
            int root = t.disassemble(leftTree, rightTree);

            copyTree.assemble(root, copy(leftTree), copy(rightTree));

            t.assemble(root, leftTree, rightTree);

        }

        return copyTree;
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
