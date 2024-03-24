import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.stack.Stack;

/**
 * JUnit test fixture for {@code Stack<String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class StackTest {

    /**
     * Invokes the appropriate {@code Stack} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new stack
     * @ensures constructorTest = <>
     */
    protected abstract Stack<String> constructorTest();

    /**
     * Invokes the appropriate {@code Stack} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new stack
     * @ensures constructorRef = <>
     */
    protected abstract Stack<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Stack<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsTest = [entries in args]
     */
    private Stack<String> createFromArgsTest(String... args) {
        Stack<String> stack = this.constructorTest();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    /**
     *
     * Creates and returns a {@code Stack<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsRef = [entries in args]
     */
    private Stack<String> createFromArgsRef(String... args) {
        Stack<String> stack = this.constructorRef();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    // TODO - add test cases for constructor, push, pop, and length

    /**
     * Tests Default Constructor.
     */
    @Test
    public final void testDefaultConstructor() {
        Stack<String> s = this.constructorTest();
        Stack<String> sExpected = this.constructorRef();

        assertEquals(sExpected, s);
    }

    /**
     * Tests Push from empty stack.
     */
    @Test
    public final void testPushFromEmpty() {
        Stack<String> s = this.createFromArgsTest();
        Stack<String> sExpected = this.createFromArgsRef("apple");

        s.push("apple");

        assertEquals(sExpected, s);
    }

    /**
     * Tests Push from non empty stack.
     */
    @Test
    public final void testPushFromNonEmpty1() {
        Stack<String> s = this.createFromArgsTest("apple");
        Stack<String> sExpected = this.createFromArgsRef("pear", "apple");

        s.push("pear");

        assertEquals(sExpected, s);
    }

    /**
     * Tests Push from non empty stack.
     */
    @Test
    public final void testPushFromNonEmpty2() {
        Stack<String> s = this.createFromArgsTest("apple", "banana", "carrot",
                "dragonfruit");
        Stack<String> sExpected = this.createFromArgsRef("electrolyte", "apple",
                "banana", "carrot", "dragonfruit");

        s.push("electrolyte");

        assertEquals(sExpected, s);
    }

    /**
     * Tests Pop resulting in empty stack.
     */
    @Test
    public final void testPopToEmpty() {
        Stack<String> s = this.createFromArgsTest("apple");
        Stack<String> sExpected = this.createFromArgsRef();

        String ans = s.pop();

        assertEquals(sExpected, s);
        assertEquals("apple", ans);
    }

    /**
     * Tests Pop resulting in non empty stack.
     */
    @Test
    public final void testPopToNonEmpty1() {
        Stack<String> s = this.createFromArgsTest("apple", "banana");
        Stack<String> sExpected = this.createFromArgsRef("banana");

        String ans = s.pop();

        assertEquals(sExpected, s);
        assertEquals("apple", ans);
    }

    /**
     * Tests Pop resulting in non empty stack.
     */
    @Test
    public final void testPopToNonEmpty2() {
        Stack<String> s = this.createFromArgsTest("apple", "banana", "carrot",
                "dragonfruit", "electrolyte");
        Stack<String> sExpected = this.createFromArgsRef("banana", "carrot",
                "dragonfruit", "electrolyte");

        String ans = s.pop();

        assertEquals(sExpected, s);
        assertEquals("apple", ans);
    }

    /**
     * Tests Length 0.
     */
    @Test
    public final void testLengthEmpty() {
        Stack<String> s = this.createFromArgsTest();

        int len = s.length();

        assertEquals(0, len);
    }

    /**
     * Tests Length 1.
     */
    @Test
    public final void testLength1() {
        Stack<String> s = this.createFromArgsTest("apple");

        int len = s.length();

        assertEquals(1, len);
    }

    /**
     * Tests Length 2.
     */
    @Test
    public final void testLength2() {
        Stack<String> s = this.createFromArgsTest("apple", "banana", "C", "d",
                "e");

        int len = s.length();
        final int five = 5;

        assertEquals(five, len);
    }

}
