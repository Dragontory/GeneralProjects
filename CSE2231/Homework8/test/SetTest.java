import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Put your name here
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
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

        Set<String> s = this.constructorTest();
        Set<String> sExpected = this.constructorRef();

        assertEquals(sExpected, s);
    }

    /**
     * Test add from empty Set.
     */
    @Test
    public final void testAddEmpty() {

        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef("one");

        s.add("one");

        assertEquals(sExpected, s);
    }

    /**
     * Test add from non empty Set.
     */
    @Test
    public final void testAddNonEmpty() {

        Set<String> s = this.createFromArgsTest("two", "three");
        Set<String> sExpected = this.createFromArgsRef("one", "two", "three");

        s.add("one");

        assertEquals(sExpected, s);
    }

    /**
     * Test remove evaluating to empty Set.
     */
    @Test
    public final void testRemoveEmpty() {

        Set<String> s = this.createFromArgsTest("one");
        Set<String> sExpected = this.createFromArgsRef();

        s.remove("one");

        assertEquals(sExpected, s);
    }

    /**
     * Test remove evaluating to non empty Set.
     */
    @Test
    public final void testRemoveNonEmpty() {

        Set<String> s = this.createFromArgsTest("one", "two");
        Set<String> sExpected = this.createFromArgsRef("two");

        s.remove("one");

        assertEquals(sExpected, s);
    }

    /**
     * Test removeAny with only one element.
     */
    @Test
    public final void testRemoveAnyOnlyOne() {

        Set<String> s = this.createFromArgsTest("one");
        Set<String> sExpected = this.createFromArgsRef();

        String r = s.removeAny();
        String rExpected = "one";

        assertEquals(sExpected, s);
        assertEquals(rExpected, r);

    }

    /**
     * Test removeAny with multiple elements.
     */
    @Test
    public final void testRemoveAnyMultiple() {

        Set<String> s = this.createFromArgsTest("one", "two", "three");
        Set<String> sExpected = this.createFromArgsRef("one", "two", "three");

        String r = s.removeAny();

        assertTrue(sExpected.contains(r) && s.size() == sExpected.size() - 1);
    }

    /**
     * Test contains.
     */
    @Test
    public final void testContains() {

        Set<String> s = this.createFromArgsTest("one", "two", "three");
        Set<String> sExpected = this.createFromArgsRef("one", "two", "three");

        assertTrue(s.contains("three") && sExpected.contains("three"));
    }

    /**
     * Test size.
     */
    @Test
    public final void testSizeNoneEmpty() {

        Set<String> s = this.createFromArgsTest("one", "two", "three");
        Set<String> sExpected = this.createFromArgsRef("one", "two", "three");

        int size = s.size();
        int expected = sExpected.size();

        assertEquals(expected, size);
    }

    /**
     * Test size.
     */
    @Test
    public final void testSizeEmpty() {

        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef();

        int size = s.size();
        int expected = sExpected.size();

        assertEquals(expected, size);
        assertEquals(size, 0);
    }

}
