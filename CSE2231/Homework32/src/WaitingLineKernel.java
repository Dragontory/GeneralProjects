import components.standard.Standard;

/**
 * Waiting Line Kernel Methods.
 *
 * @author Tory Yang
 *
 */
public interface WaitingLineKernel<T>
        extends Standard<WaitingLine<T>>, Iterable<T> {

    /**
     * Adds x to the end of this if this does not contain x.
     *
     * @param x
     *            the entry to be added
     * @updates this
     * @requires x is not in this
     */
    void add(T x);

    /**
     * Removes entry from the front of this.
     *
     * @return the entry removed
     * @updates this
     * @requires this is not empty
     */
    T removeFront();

    /**
     * Reports length of this.
     *
     * @return the length of {@code this}
     */
    int length();

}
