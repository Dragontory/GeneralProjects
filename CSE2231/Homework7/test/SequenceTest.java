import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code Sequence<String>}'s constructor and kernel
 * methods.
 *
 * @author Tory Yang
 *
 */
public abstract class SequenceTest {

    /**
     * Invokes the appropriate {@code Sequence} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new sequence
     * @ensures constructorTest = <>
     */
    protected abstract Sequence<String> constructorTest();

    /**
     * Invokes the appropriate {@code Sequence} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new sequence
     * @ensures constructorRef = <>
     */
    protected abstract Sequence<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsTest = [entries in args]
     */
    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> sequence = this.constructorTest();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsRef = [entries in args]
     */
    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> sequence = this.constructorRef();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    // TODO - add test cases for constructor, add, remove, and length

    @Test
    public void testConstructor() {
        Sequence<String> sequence = this.constructorTest();
        Sequence<String> expected = this.constructorRef();
        assertEquals(sequence, expected);

    }

    /**
     * test for add.
     */
    @Test
    public void testadd() {
        Sequence<String> s = this.createFromArgsTest("one", "three");
        Sequence<String> sExpected = this.createFromArgsRef("one", "two",
                "three");

        s.add(1, "two");

        assertEquals(sExpected, s);
    }

    @Test
    public void testadd2() {
        Sequence<String> s = this.createFromArgsTest("one", "two");
        Sequence<String> sExpected = this.createFromArgsRef("one", "two",
                "three");

        s.add(2, "three");

        assertEquals(sExpected, s);
    }

    /**
     * test for length empty.
     */
    @Test
    public final void testLengthEmpty() {
        /*
         * Set up variables
         */
        Sequence<String> q = this.createFromArgsTest();
        Sequence<String> qExpected = this.createFromArgsRef();

        int length = q.length();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(qExpected, q);
        assertEquals(0, length);
    }

    /**
     * test for length not empty.
     */
    @Test
    public final void testLengthNonEmptyOne() {
        /*
         * Set up variables.
         */
        Sequence<String> q = this.createFromArgsTest("one", "two");
        Sequence<String> qExpected = this.createFromArgsRef("one", "two");

        int length = q.length();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(qExpected, q);
        assertEquals(2, length);
    }

    /**
     * test for remove.
     *
     */
    @Test
    public final void testRemoveNonEmpty() {
        Sequence<String> q = this.createFromArgsTest("one", "two", "three");
        Sequence<String> qExpected = this.createFromArgsRef("two", "three");
        String removed = q.remove(0);
        assertEquals(qExpected, q);
        assertEquals(removed, "red");
    }

    /**
     * test for remove.
     *
     */
    @Test
    public final void testRemoveEmpty() {
        Sequence<String> q = this.createFromArgsTest("one");
        Sequence<String> qExpected = this.createFromArgsRef();
        String removed = q.remove(0);
        assertEquals(qExpected, q);
        assertEquals(removed, "one");
    }

}
