import components.queue.Queue;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Homework 8.
 *
 * @author Tory Yang
 *
 */
public final class SetOnQueue {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private SetOnQueue() {
    }

    /**
     * Finds {@code x} in {@code q} and, if such exists, moves it to the front
     * of {@code q}.
     *
     * @param <T>
     *            type of {@code Queue} entries
     * @param q
     *            the {@code Queue} to be searched
     * @param x
     *            the entry to be searched for
     * @updates q
     * @ensures <pre>
     * perms(q, #q)  and
     * if <x> is substring of q
     *  then <x> is prefix of q
     * </pre>
     */
    private static <T> void moveToFront(Queue<T> q, T x) {
        T temp = null;
        int position = 0;

        while (position < q.length()) {
            if (q.front().equals(x)) {
                temp = q.dequeue();
            }
            q.rotate(1);
            position++;
        }
        q.rotate(1);

        if (position >= q.length()) {
            q.enqueue(temp);
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
