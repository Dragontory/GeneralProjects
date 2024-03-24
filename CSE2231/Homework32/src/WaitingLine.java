/**
 * Waiting Line Methods.
 *
 * @author Tory Yang
 *
 */

public interface WaitingLine<T> extends WaitingLineKernel<T> {
    /**
     * Find the position of x in this, if not, returns -1.
     *
     * @param x
     *            the entry being looked for
     * @return the position of x in this
     * @requires this is not empty
     */
    int positionOf(T x);

    /**
     * Reports the front of.
     *
     * @return the front entry of this
     * @requires this is not empty
     */
    T front();

    /**
     * Replaces the entry of {@code this} with {@code x}, and returns the old
     * value.
     *
     * @param pos
     *            the position of the entry to be replaced
     * @param x
     *            the new front entry
     * @return the old entry
     * @aliases reference {@code x}
     * @updates this
     * @requires {@code this /= <>}
     *
     */
    T replaceEntry(int pos, T x);

}
