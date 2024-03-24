import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Ryan Liu, Tory Yang
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    // TODO - add test cases for constructor, add, remove, removeAny, contains, and size

    /**
     * Test constructor.
     */
    @Test
    public final void testConstructor() {
        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.constructorTest();
        Set<String> sExpected = this.constructorRef();

        /*
         * Assert that values of sets match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test add from empty Set.
     */
    @Test
    public final void testAddEmpty() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef("apple");

        s.add("apple");

        /*
         * Assert that values of sets match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test add from non empty Set.
     */
    @Test
    public final void testAddNonEmpty1() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("apple", "banana");
        Set<String> sExpected = this.createFromArgsRef("apple", "banana",
                "carrot");

        s.add("carrot");

        /*
         * Assert that values of sets match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test add from non empty Set.
     */
    @Test
    public final void testAddNonEmpty2() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("pear", "grape", "anchovy",
                "pizza");
        Set<String> sExpected = this.createFromArgsRef("pear", "grape",
                "anchovy", "pizza", "joe");

        s.add("joe");

        /*
         * Assert that values of sets match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test add from non empty Set.
     */
    @Test
    public final void testAddNonEmpty3() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("apple");
        Set<String> sExpected = this.createFromArgsRef("apple", "banana");

        s.add("banana");

        /*
         * Assert that values of sets match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test remove evaluating to empty Set.
     */
    @Test
    public final void testRemoveEmpty() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("apple");
        Set<String> sExpected = this.createFromArgsRef();

        s.remove("apple");

        /*
         * Assert that values of sets match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test remove evaluating to non empty Set.
     */
    @Test
    public final void testRemoveNonEmpty1() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("apple", "banana");
        Set<String> sExpected = this.createFromArgsRef("banana");

        s.remove("apple");

        /*
         * Assert that values of sets match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test remove evaluating to non empty Set.
     */
    @Test
    public final void testRemoveNonEmpty2() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("banana", "apple", "carrot",
                "pineapple", "subway");
        Set<String> sExpected = this.createFromArgsRef("banana", "apple",
                "pineapple", "subway");

        s.remove("carrot");

        /*
         * Assert that values of sets match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test remove evaluating to non empty Set.
     */
    @Test
    public final void testRemoveNonEmpty3() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("banana", "apple", "carrot",
                "pineapple", "subway", "anchovy", "arizona");
        Set<String> sExpected = this.createFromArgsRef("banana", "apple",
                "carrot", "pineapple", "subway", "arizona");

        s.remove("anchovy");

        /*
         * Assert that values of sets match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test removeAny with only one element.
     */
    @Test
    public final void testRemoveAnyOnlyOne() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("apple");
        Set<String> sExpected = this.createFromArgsRef("apple");

        String r = s.removeAny();

        /*
         * Assert that values of sets match expectations
         */
        assertEquals(sExpected.contains(r), true);
        sExpected.remove(r);
        assertEquals(s, sExpected);

    }

    /**
     * Test removeAny with multiple elements.
     */
    @Test
    public final void testRemoveAnyMultiple1() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("apple", "banana", "carrot");
        Set<String> sExpected = this.createFromArgsRef("apple", "banana",
                "carrot");

        String r = s.removeAny();

        /*
         * Assert that values of sets match expectations
         */
        assertEquals(sExpected.contains(r), true);
        sExpected.remove(r);
        assertEquals(s, sExpected);
    }

    /**
     * Test removeAny with multiple elements.
     */
    @Test
    public final void testRemoveAnyMultiple2() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("banana", "apple", "carrot",
                "pineapple", "subway", "anchovy", "arizona");
        Set<String> sExpected = this.createFromArgsTest("banana", "apple",
                "carrot", "pineapple", "subway", "anchovy", "arizona");

        String r = s.removeAny();

        /*
         * Assert that values of sets match expectations
         */
        assertEquals(sExpected.contains(r), true);
        sExpected.remove(r);
        assertEquals(s, sExpected);

    }

    /**
     * Test contains with multiple elements.
     */
    @Test
    public final void testContainsMultiple1() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("apple", "banana", "carrot");
        Set<String> sExpected = this.createFromArgsRef("apple", "banana",
                "carrot");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(s.contains("carrot"), true);
        assertEquals(sExpected.contains("carrot"), true);
    }

    /**
     * Test contains with multiple elements.
     */
    @Test
    public final void testContainsMultiple2() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("banana", "apple", "carrot",
                "pineapple", "subway", "anchovy", "arizona");
        Set<String> sExpected = this.createFromArgsTest("banana", "apple",
                "carrot", "pineapple", "subway", "anchovy", "arizona");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(s.contains("anchovy"), true);
        assertEquals(sExpected.contains("anchovy"), true);
    }

    /**
     * Test contains with one element.
     */
    @Test
    public final void testContainsOnlyOne() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("apple");
        Set<String> sExpected = this.createFromArgsRef("apple");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(s.contains("apple"), true);
        assertEquals(sExpected.contains("apple"), true);
    }

    /**
     * Test size.
     */
    @Test
    public final void testSizeNonEmpty1() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("apple", "banana", "carrot");
        Set<String> sExpected = this.createFromArgsRef("apple", "banana",
                "carrot");

        int size = s.size();
        int expected = sExpected.size();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expected, size);
    }

    /**
     * Test size.
     */
    @Test
    public final void testSizeNonEmpty2() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("banana", "apple", "carrot",
                "pineapple", "subway", "anchovy", "arizona");
        Set<String> sExpected = this.createFromArgsTest("banana", "apple",
                "carrot", "pineapple", "subway", "anchovy", "arizona");

        int size = s.size();
        int expected = sExpected.size();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expected, size);
    }

    /**
     * Test size with one element.
     */
    @Test
    public final void testSizeOne() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest("apple");
        Set<String> sExpected = this.createFromArgsRef("apple");

        int size = s.size();
        int expected = sExpected.size();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expected, size);
        assertEquals(size, 1);
    }

    /**
     * Test empty set size.
     */
    @Test
    public final void testSizeEmpty() {

        /*
         * Set up variables and call method under test
         */
        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef();

        int size = s.size();
        int expected = sExpected.size();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expected, size);
        assertEquals(size, 0);
    }

}
