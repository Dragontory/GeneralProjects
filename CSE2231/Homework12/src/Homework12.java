import components.binarytree.BinaryTree;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Homework12 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework12() {
    }

    /**
     * Returns the size of the given {@code BinaryTree<T>}.
     *
     * @param <T>
     *            the type of the {@code BinaryTree} node labels
     * @param t
     *            the {@code BinaryTree} whose size to return
     * @return the size of the given {@code BinaryTree}
     * @ensures size = |t|
     */
    public static <T> int sizeRecursive(BinaryTree<T> t) {
        int totalSize = 0;

        if (t.height() == 0) {
            return 0;
        } else {
            BinaryTree<T> leftTree = t.newInstance();
            BinaryTree<T> rightTree = t.newInstance();

            T root = t.disassemble(leftTree, rightTree);
            totalSize = 1 + sizeRecursive(leftTree) + sizeRecursive(rightTree);

            //puts tree back together
            t.assemble(root, leftTree, rightTree);
        }

        return totalSize;
    }

    /**
     * Returns the size of the given {@code BinaryTree<T>}.
     *
     * @param <T>
     *            the type of the {@code BinaryTree} node labels
     * @param t
     *            the {@code BinaryTree} whose size to return
     * @return the size of the given {@code BinaryTree}
     * @ensures size = |t|
     */
    public static <T> int sizeNonRecursive(BinaryTree<T> t) {

//        int totalSize = 0;
//        BinaryTree<T> leftTree = t.newInstance();
//        BinaryTree<T> rightTree = t.newInstance();
//
//        if(t.height() > 2) {
//            T root = t.disassemble(leftTree, rightTree);
//            t.assemble(root, leftTree, rightTree);
//        } else if(t.height() == 1) {
//            totalSize = 1;
//        } else {
//            totalSize = 0;
//        }
//
//        while(leftTree.height() > 0) {
//            BinaryTree<T> left2 = t.newInstance();
//            BinaryTree<T> right2 = t.newInstance();
//
//            T leftRoot = leftTree.disassemble(left2, right2);
//
//            leftTree =
//
//        }

        int totalSize = 0;

        for (T x : t) {
            totalSize++;
        }

        return totalSize;
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
        myMethod();
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
