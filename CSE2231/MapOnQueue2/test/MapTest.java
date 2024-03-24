import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.map.Map;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
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

    /**
     * Test for add in Non Empty Map.
     */
    @Test
    public final void testAddNonEmpty() {
        Map<String, String> s = this.createFromArgsTest("Lebron", "James");
        Map<String, String> sExpected = this.createFromArgsRef("Lebron",
                "James", "Kyrie", "Irving");

        s.add("Kyrie", "Irving");
        assertTrue(s.hasKey("Kyrie") && s.equals(sExpected));

    }

    /**
     * Test for add in Empty Map.
     */
    @Test
    public final void testAddEmpty() {
        Map<String, String> s = this.createFromArgsTest();
        Map<String, String> sExpected = this.createFromArgsRef("Kyrie",
                "Irving");

        s.add("Kyrie", "Irving");
        assertTrue(s.hasKey("Kyrie") && s.equals(sExpected));

    }

    /**
     * Test for add Remove leaving Non Empty Map.
     */
    @Test
    public final void testRemoveNonEmpty() {
        Map<String, String> s = this.createFromArgsTest("Lebron", "James",
                "Kyrie", "Irving");
        Map<String, String> sExpected = this.createFromArgsRef("Lebron",
                "James");

        s.remove("Kyrie");
        assertTrue(!s.hasKey("Kyrie") && s.equals(sExpected));

    }

    /**
     * Test for add Remove leaving Empty Map.
     */
    @Test
    public final void testRemoveEmpty() {
        Map<String, String> s = this.createFromArgsTest("Kyrie", "Irving");
        Map<String, String> sExpected = this.createFromArgsRef();

        s.remove("Kyrie");
        assertTrue(!s.hasKey("Kyrie") && s.equals(sExpected));

    }

    /**
     * Test for Remove-any leaving Non Empty Map.
     */
    @Test
    public final void testRemoveAnyNonEmpty() {
        Map<String, String> s = this.createFromArgsTest("Lebron", "James",
                "Kyrie", "Irving");
        int firstSize = s.size();
        s.removeAny();
        int secondSize = s.size();
        assertTrue(firstSize - secondSize == 1);
    }

    /**
     * Test for Remove-any leaving Empty Map.
     */
    @Test
    public final void testRemoveAnyEmpty() {
        Map<String, String> s = this.createFromArgsTest("Kyrie", "Irving");
        Map<String, String> sExpected = this.createFromArgsRef();

        s.removeAny();
        assertTrue(!s.hasKey("Kyrie") && s.equals(sExpected));
    }

    /**
     * Test for Value with multiple Values.
     */
    @Test
    public final void testValueMultiple() {
        Map<String, String> s = this.createFromArgsTest("Lebron", "James",
                "Kyrie", "Irving");
        String value1 = s.value("Lebron");
        String value2 = s.value("Kyrie");
        assertTrue(value1.equals("James") && value2.equals("Irving"));
    }

    /**
     * Test for Value with one Value.
     */
    @Test
    public final void testValueOne() {
        Map<String, String> s = this.createFromArgsTest("Lebron", "James");
        String value = s.value("Lebron");
        assertEquals("James", value);
    }

    /**
     *
     * Test for Has key with multiple values.
     */
    @Test
    public final void testHasKeyMultiple() {
        Map<String, String> s = this.createFromArgsTest("Lebron", "James",
                "Kyrie", "Irving");
        assertTrue(s.hasKey("Lebron") && s.hasKey("Kyrie"));
    }

    /**
     *
     * Test for Has key with multiple values.
     */
    @Test
    public final void testHasKeyOne() {
        Map<String, String> s = this.createFromArgsTest("Lebron", "James");
        assertTrue(s.hasKey("Lebron"));
    }

    /**
     * Test for Size in Non empty.
     */
    @Test
    public final void testSizeNonEmpty() {
        Map<String, String> s = this.createFromArgsTest("Kyrie", "Irving",
                "Lebron", "James");
        int size = s.size();
        assertEquals(2, size);
    }

    /**
     * Test for Size in empty.
     */
    @Test
    public final void testSizeEmpty() {
        Map<String, String> s = this.createFromArgsTest();
        int size = s.size();
        assertEquals(0, size);
    }

}
