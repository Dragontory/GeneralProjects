import components.map.Map.Pair;
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
public final class MapOnQueue {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private MapOnQueue() {
    }

    /**
     * Finds pair with first component {@code key} and, if such exists, moves it
     * to the front of {@code q}.
     *
     * @param <K>
     *            type of {@code Pair} key
     * @param <V>
     *            type of {@code Pair} value
     * @param q
     *            the {@code Queue} to be searched
     * @param key
     *            the key to be searched for
     * @updates q
     * @ensures <pre>
     * perms(q, #q)  and
     * if there exists value: V (<(key, value)> is substring of q)
     *  then there exists value: V (<(key, value)> is prefix of q)
     * </pre>
     */
    private static <K, V> void moveToFront(Queue<Pair<K, V>> q, K key) {
        Pair<K, V> found = null;
        int count = 0;
        for (Pair<K, V> element : q) {
            if (!element.key().equals(key)) {
                q.enqueue(q.dequeue());
            } else {
                found = q.dequeue();
                count++;
            }
        }

        if (count > 0) {
            q.enqueue(found);
            q.rotate(q.length() - 1);
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
