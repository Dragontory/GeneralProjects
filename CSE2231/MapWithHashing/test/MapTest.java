import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.map.Map;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Ryan Liu, Tory Yang
 *
 */
public abstract class MapTest {

    /**
     * Invokes the appropriate {@code Map} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new map
     * @ensures constructorTest = {}
     */
    protected abstract Map<String, String> constructorTest();

    /**
     * Invokes the appropriate {@code Map} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new map
     * @ensures constructorRef = {}
     */
    protected abstract Map<String, String> constructorRef();

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsTest = [pairs in args]
     */
    private Map<String, String> createFromArgsTest(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorTest();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsRef = [pairs in args]
     */
    private Map<String, String> createFromArgsRef(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorRef();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    // add test cases for constructor, add, remove, removeAny, value,
    // hasKey, and size

    /**
     * Test for constructor with no args.
     */
    @Test
    public final void testConstructor() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> m = this.constructorRef();
        Map<String, String> mExp = this.constructorTest();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(mExp, m);
    }

    /**
     * Test for add in Non Empty Map.
     */
    @Test
    public final void testAddNonEmpty() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> s = this.createFromArgsTest("Lebron", "James");
        Map<String, String> sExpected = this.createFromArgsRef("Lebron",
                "James", "Kyrie", "Irving");

        s.add("Kyrie", "Irving");
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(s.hasKey("Kyrie") && s.equals(sExpected));

    }

    /**
     * Test for add in Empty Map.
     */
    @Test
    public final void testAddEmpty() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> s = this.createFromArgsTest();
        Map<String, String> sExpected = this.createFromArgsRef("Kyrie",
                "Irving");

        s.add("Kyrie", "Irving");
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(s.hasKey("Kyrie") && s.equals(sExpected));

    }

    /**
     * Test for add Remove leaving Non Empty Map.
     */
    @Test
    public final void testRemoveNonEmpty() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> s = this.createFromArgsTest("Lebron", "James",
                "Kyrie", "Irving");
        Map<String, String> sExpected = this.createFromArgsRef("Lebron",
                "James");

        s.remove("Kyrie");
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(!s.hasKey("Kyrie"));
        assertEquals(sExpected, s);

    }

    /**
     * Test for add Remove leaving Empty Map.
     */
    @Test
    public final void testRemoveEmpty() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> s = this.createFromArgsTest("Kyrie", "Irving");
        Map<String, String> sExpected = this.createFromArgsRef();

        s.remove("Kyrie");
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(!s.hasKey("Kyrie") && s.equals(sExpected));

    }

    /**
     * Test for Remove-any leaving Empty Map, thoroughly.
     */
    @Test
    public final void testRemoveAnyOnePair() {
        /*
         * Set up variables
         */
        Map<String, String> s = this.createFromArgsTest("Kyrie", "Irving");
        Map<String, String> sExpected = this.createFromArgsRef("Kyrie",
                "Irving");
        /*
         * Call method under test
         */
        Map.Pair<String, String> x = s.removeAny();
        /*
         * Assert that values of variables match expectations
         */
        String key = x.key();
        assertEquals(true, sExpected.hasKey(key));

        /*
         * Call expected method to match method under test
         */
        sExpected.remove(key);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(s, sExpected);
    }

    /**
     * Test for Remove-any leaving non-empty map, thoroughly.
     */
    @Test
    public final void testRemoveAnyOnePairSizeMoreThanOne() {
        /*
         * Set up variables
         */
        Map<String, String> s = this.createFromArgsTest("Kyrie", "Irving",
                "Kobe", "Bryant");
        Map<String, String> sExpected = this.createFromArgsRef("Kyrie",
                "Irving", "Kobe", "Bryant");
        /*
         * Call method under test
         */
        Map.Pair<String, String> x = s.removeAny();
        /*
         * Assert that values of variables match expectations
         */
        String key = x.key();
        assertEquals(true, sExpected.hasKey(key));

        /*
         * Call expected method to match method under test
         */
        sExpected.remove(key);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(s, sExpected);
    }

    /**
     * Test for Value with multiple Values.
     */
    @Test
    public final void testValueMultiple() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> s = this.createFromArgsTest("Lebron", "James",
                "Kyrie", "Irving");
        String value1 = s.value("Lebron");
        String value2 = s.value("Kyrie");
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(value1.equals("James") && value2.equals("Irving"));
    }

    /**
     * Test for Value with one Value.
     */
    @Test
    public final void testValueOne() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> s = this.createFromArgsTest("Lebron", "James");
        String value = s.value("Lebron");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals("James", value);
    }

    /**
     *
     * Test for Has key with multiple values.
     */
    @Test
    public final void testHasKeyMultipleTrue() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> s = this.createFromArgsTest("Lebron", "James",
                "Kyrie", "Irving");
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(s.hasKey("Lebron") && s.hasKey("Kyrie"));
    }

    /**
     *
     * Test for Has key with multiple values.
     */
    @Test
    public final void testHasKeyOneTrue() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> s = this.createFromArgsTest("Lebron", "James");
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(s.hasKey("Lebron"));
    }

    /**
     *
     * Test for Has key with multiple values.
     */
    @Test
    public final void testHasKeyOneFalse() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> s = this.createFromArgsTest("Lebron", "James");
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(!s.hasKey("Kobe"));
    }

    /**
     *
     * Test for Has key with multiple values.
     */
    @Test
    public final void testHasKeyNoneFalse() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> s = this.createFromArgsTest();
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(!s.hasKey("Lebron"));
    }

    /**
     * Test for Size in Non empty.
     */
    @Test
    public final void testSizeNonEmpty() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> s = this.createFromArgsTest("Kyrie", "Irving",
                "Lebron", "James");
        int size = s.size();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(2, size);
    }

    /**
     * Test for Size in empty.
     */
    @Test
    public final void testSizeEmpty() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> s = this.createFromArgsTest();
        int size = s.size();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, size);
    }

}
