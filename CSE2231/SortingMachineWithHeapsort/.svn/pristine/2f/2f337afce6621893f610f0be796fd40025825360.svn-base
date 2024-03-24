import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

import components.sortingmachine.SortingMachine;

/**
 * JUnit test fixture for {@code SortingMachine<String>}'s constructor and
 * kernel methods.
 *
 * @author Put your name here
 *
 */
public abstract class SortingMachineTest {

    /**
     * Invokes the appropriate {@code SortingMachine} constructor for the
     * implementation under test and returns the result.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @return the new {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures constructorTest = (true, order, {})
     */
    protected abstract SortingMachine<String> constructorTest(
            Comparator<String> order);

    /**
     * Invokes the appropriate {@code SortingMachine} constructor for the
     * reference implementation and returns the result.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @return the new {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures constructorRef = (true, order, {})
     */
    protected abstract SortingMachine<String> constructorRef(
            Comparator<String> order);

    /**
     *
     * Creates and returns a {@code SortingMachine<String>} of the
     * implementation under test type with the given entries and mode.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @param insertionMode
     *            flag indicating the machine mode
     * @param args
     *            the entries for the {@code SortingMachine}
     * @return the constructed {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * createFromArgsTest = (insertionMode, order, [multiset of entries in args])
     * </pre>
     */
    private SortingMachine<String> createFromArgsTest(Comparator<String> order,
            boolean insertionMode, String... args) {
        SortingMachine<String> sm = this.constructorTest(order);
        for (int i = 0; i < args.length; i++) {
            sm.add(args[i]);
        }
        if (!insertionMode) {
            sm.changeToExtractionMode();
        }
        return sm;
    }

    /**
     *
     * Creates and returns a {@code SortingMachine<String>} of the reference
     * implementation type with the given entries and mode.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @param insertionMode
     *            flag indicating the machine mode
     * @param args
     *            the entries for the {@code SortingMachine}
     * @return the constructed {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * createFromArgsRef = (insertionMode, order, [multiset of entries in args])
     * </pre>
     */
    private SortingMachine<String> createFromArgsRef(Comparator<String> order,
            boolean insertionMode, String... args) {
        SortingMachine<String> sm = this.constructorRef(order);
        for (int i = 0; i < args.length; i++) {
            sm.add(args[i]);
        }
        if (!insertionMode) {
            sm.changeToExtractionMode();
        }
        return sm;
    }

    /**
     * Comparator<String> implementation to be used in all test cases. Compare
     * {@code String}s in lexicographic order.
     */
    private static class StringLT implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return s1.compareToIgnoreCase(s2);
        }

    }

    /**
     * Comparator instance to be used in all test cases.
     */
    private static final StringLT ORDER = new StringLT();

    /*
     * Sample test cases.
     */

    /**
     * Test constructor.
     */
    @Test
    public final void testConstructor() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.constructorTest(ORDER);
        SortingMachine<String> mExpected = this.constructorRef(ORDER);

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(mExpected, m);
    }

    /**
     * Test adding into an empty heap.
     */
    @Test
    public final void testAddEmpty() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "green");
        m.add("green");

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(mExpected, m);
    }

    // TODO - add test cases for add, changeToExtractionMode, removeFirst,
    // isInInsertionMode, order, and size

    /**
     * Test adding into a non empty heap.
     */
    @Test
    public final void testAddNonEmpty1() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "blue");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "blue", "green");
        m.add("green");

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(mExpected, m);
    }

    /**
     * Test adding into a non empty heap.
     */
    @Test
    public final void testAddNonEmpty2() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "blue",
                "green", "red", "aqua");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "blue", "green", "red", "aqua", "orange");
        m.add("orange");

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(mExpected, m);
    }

    /**
     * Test adding into a non empty heap.
     */
    @Test
    public final void testAddNonEmpty3() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "red",
                "green", "blue", "black");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "red", "green", "blue", "black", "aqua");
        m.add("aqua");

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(mExpected, m);
    }

    /**
     * Test changeToExtractionMode on empty heap.
     */
    @Test
    public final void testChangeToExtractionModeEmpty() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false);

        m.changeToExtractionMode();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(mExpected, m);
    }

    /**
     * Test changeToExtractionMode on non empty heap.
     */
    @Test
    public final void testChangeToExtractionModeNonEmpty1() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true,
                "green");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "green");

        m.changeToExtractionMode();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(mExpected, m);
    }

    /**
     * Test changeToExtractionMode on non empty heap.
     */
    @Test
    public final void testChangeToExtractionModeNonEmpty2() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "green",
                "orange", "red", "purple");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "green", "orange", "red", "purple");

        m.changeToExtractionMode();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(mExpected, m);
    }

    /**
     * Test changeToExtractionMode on non empty heap.
     */
    @Test
    public final void testChangeToExtractionModeNonEmpty3() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true,
                "purple", "red", "orange", "green");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "purple", "red", "orange", "green");

        m.changeToExtractionMode();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(mExpected, m);
    }

    /**
     * Test changeToExtractionMode on non empty heap.
     */
    @Test
    public final void testChangeToExtractionModeNonEmpty4() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true,
                "purple", "orange", "green", "red");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "purple", "orange", "green", "red");

        m.changeToExtractionMode();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(mExpected, m);
    }

    /**
     * Test removeFirst leaving an empty heap.
     */
    @Test
    public final void testremoveFirstEmpty() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false,
                "green");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false);

        String removed = m.removeFirst();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals("green", removed);
        assertEquals(mExpected, m);
    }

    /**
     * Test removeFirst on non empty heap.
     */
    @Test
    public final void testremoveFirstNonEmpty1() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false,
                "green", "orange", "red", "purple");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "orange", "red", "purple");

        String removed = m.removeFirst();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals("green", removed);
        assertEquals(mExpected, m);
    }

    /**
     * Test removeFirst on non empty heap.
     */
    @Test
    public final void testremoveFirstNonEmpty2() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false,
                "purple", "red", "orange", "green");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "purple", "red", "orange");

        String removed = m.removeFirst();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals("green", removed);
        assertEquals(mExpected, m);
    }

    /**
     * Test removeFirst on non empty heap.
     */
    @Test
    public final void testremoveFirstNonEmpty3() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false,
                "orange", "purple", "green", "aqua", "red");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "orange", "purple", "green", "red");

        String removed = m.removeFirst();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals("aqua", removed);
        assertEquals(mExpected, m);
    }

    /**
     * Test removeFirst on non empty heap.
     */
    @Test
    public final void testremoveFirstNonEmpty4() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "blue",
                "black", "red", "aqua", "green", "orange");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "blue", "black", "red", "green", "orange");

        String removed = m.removeFirst();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals("aqua", removed);
        assertEquals(mExpected, m);
    }

    /**
     * Test isInInsertionMode on empty heap.
     */
    @Test
    public final void testisInInsertionModeEmpty1() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true);

        boolean r = m.isInInsertionMode();
        boolean rExpected = mExpected.isInInsertionMode();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(rExpected, r);
        assertEquals(true, r);
        assertEquals(mExpected, m);
    }

    /**
     * Test isInInsertionMode on empty heap.
     */
    @Test
    public final void testisInInsertionModeEmpty2() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false);

        boolean r = m.isInInsertionMode();
        boolean rExpected = mExpected.isInInsertionMode();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(rExpected, r);
        assertEquals(false, r);
        assertEquals(mExpected, m);
    }

    /**
     * Test isInInsertionMode on non empty heap.
     */
    @Test
    public final void testisInInsertionModeNonEmpty1() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "red");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "red");

        boolean r = m.isInInsertionMode();
        boolean rExpected = mExpected.isInInsertionMode();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(rExpected, r);
        assertEquals(true, r);
        assertEquals(mExpected, m);
    }

    /**
     * Test isInInsertionMode on non empty heap.
     */
    @Test
    public final void testisInInsertionModeNonEmpty2() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "red");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "red");

        boolean r = m.isInInsertionMode();
        boolean rExpected = mExpected.isInInsertionMode();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(rExpected, r);
        assertEquals(false, r);
        assertEquals(mExpected, m);
    }

    /**
     * Test isInInsertionMode on non empty heap.
     */
    @Test
    public final void testisInInsertionModeNonEmpty3() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "red",
                "aqua", "green", "purple", "orange");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "red", "aqua", "green", "purple", "orange");

        boolean r = m.isInInsertionMode();
        boolean rExpected = mExpected.isInInsertionMode();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(rExpected, r);
        assertEquals(true, r);
        assertEquals(mExpected, m);
    }

    /**
     * Test isInInsertionMode on non empty heap.
     */
    @Test
    public final void testisInInsertionModeNonEmpty4() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "red",
                "aqua", "green", "purple", "orange");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "red", "aqua", "green", "purple", "orange");

        boolean r = m.isInInsertionMode();
        boolean rExpected = mExpected.isInInsertionMode();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(rExpected, r);
        assertEquals(false, r);
        assertEquals(mExpected, m);
    }

    /**
     * Test order on empty heap.
     */
    @Test
    public final void testOrderEmpty1() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true);

        Comparator<String> o = m.order();
        Comparator<String> oExpected = mExpected.order();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(oExpected, o);
        assertEquals(ORDER, o);
        assertEquals(mExpected, m);
    }

    /**
     * Test order on empty heap.
     */
    @Test
    public final void testOrderEmpty2() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false);

        Comparator<String> o = m.order();
        Comparator<String> oExpected = mExpected.order();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(oExpected, o);
        assertEquals(ORDER, o);
        assertEquals(mExpected, m);
    }

    /**
     * Test order on non empty heap.
     */
    @Test
    public final void testOrderNonEmpty1() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true,
                "green");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "green");

        Comparator<String> o = m.order();
        Comparator<String> oExpected = mExpected.order();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(oExpected, o);
        assertEquals(ORDER, o);
        assertEquals(mExpected, m);
    }

    /**
     * Test order on non empty heap.
     */
    @Test
    public final void testOrderNonEmpty2() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "red");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "red");

        Comparator<String> o = m.order();
        Comparator<String> oExpected = mExpected.order();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(oExpected, o);
        assertEquals(ORDER, o);
        assertEquals(mExpected, m);
    }

    /**
     * Test order on non empty heap.
     */
    @Test
    public final void testOrderNonEmpty3() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "red",
                "aqua", "green", "purple", "orange");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "red", "aqua", "green", "purple", "orange");

        Comparator<String> o = m.order();
        Comparator<String> oExpected = mExpected.order();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(oExpected, o);
        assertEquals(ORDER, o);
        assertEquals(mExpected, m);
    }

    /**
     * Test order on non empty heap.
     */
    @Test
    public final void testOrderNonEmpty4() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "red",
                "aqua", "green", "purple", "orange");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "red", "aqua", "green", "purple", "orange");

        Comparator<String> o = m.order();
        Comparator<String> oExpected = mExpected.order();

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(oExpected, o);
        assertEquals(ORDER, o);
        assertEquals(mExpected, m);
    }

    /**
     * Test size on empty heap.
     */
    @Test
    public final void testSizeEmpty1() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true);

        int s = m.size();
        int sExpected = mExpected.size();
        final int zero = 0;

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(sExpected, s);
        assertEquals(zero, s);
        assertEquals(mExpected, m);
    }

    /**
     * Test size on empty heap.
     */
    @Test
    public final void testSizeEmpty2() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false);

        int s = m.size();
        int sExpected = mExpected.size();
        final int zero = 0;

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(sExpected, s);
        assertEquals(zero, s);
        assertEquals(mExpected, m);
    }

    /**
     * Test size on a non empty heap.
     */
    @Test
    public final void testSizeNonEmpty1() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "red");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "red");

        int s = m.size();
        int sExpected = mExpected.size();
        final int one = 1;

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(sExpected, s);
        assertEquals(one, s);
        assertEquals(mExpected, m);
    }

    /**
     * Test size on a non empty heap.
     */
    @Test
    public final void testSizeNonEmpty2() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "red");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "red");

        int s = m.size();
        int sExpected = mExpected.size();
        final int one = 1;

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(sExpected, s);
        assertEquals(one, s);
        assertEquals(mExpected, m);
    }

    /**
     * Test size on a non empty heap.
     */
    @Test
    public final void testSizeNonEmpty3() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "red",
                "aqua", "green", "purple", "orange");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "red", "aqua", "green", "purple", "orange");

        int s = m.size();
        int sExpected = mExpected.size();
        final int five = 5;

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(sExpected, s);
        assertEquals(five, s);
        assertEquals(mExpected, m);
    }

    /**
     * Test size on a non empty heap.
     */
    @Test
    public final void testSizeNonEmpty4() {
        /*
         * Set up variables and call method under test
         */
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "red",
                "aqua", "green", "purple", "orange");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "red", "aqua", "green", "purple", "orange");

        int s = m.size();
        int sExpected = mExpected.size();
        final int five = 5;

        /*
         * Assert that values of variables meet expectations
         */
        assertEquals(sExpected, s);
        assertEquals(five, s);
        assertEquals(mExpected, m);
    }

}
