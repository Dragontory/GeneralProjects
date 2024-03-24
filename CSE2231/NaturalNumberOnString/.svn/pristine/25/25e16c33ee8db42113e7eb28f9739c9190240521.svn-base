import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;

/**
 * JUnit test fixture for {@code NaturalNumber}'s constructors and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class NaturalNumberTest {

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new number
     * @ensures constructorTest = 0
     */
    protected abstract NaturalNumber constructorTest();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorTest = i
     */
    protected abstract NaturalNumber constructorTest(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorTest)
     */
    protected abstract NaturalNumber constructorTest(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorTest = n
     */
    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract NaturalNumber constructorRef();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorRef = i
     */
    protected abstract NaturalNumber constructorRef(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorRef)
     */
    protected abstract NaturalNumber constructorRef(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorRef = n
     */
    protected abstract NaturalNumber constructorRef(NaturalNumber n);

    // TODO - add test cases for four constructors, multiplyBy10, divideBy10, isZero

    @Test
    public final void testNoArgumentConstructor() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber nn = this.constructorTest();
        NaturalNumber nnExp = this.constructorRef();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
    }

    @Test
    public final void testStringArgumentConstructorZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber nn = this.constructorTest("0");
        NaturalNumber nnExp = this.constructorRef("0");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
    }

    @Test
    public final void testStringArgumentConstructorNonZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber nn = this.constructorTest("1");
        NaturalNumber nnExp = this.constructorRef("1");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
    }

    @Test
    public final void testIntegerArgumentConstructorZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber nn = this.constructorTest(0);
        NaturalNumber nnExp = this.constructorRef(0);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
    }

    @Test
    public final void testIntegerArgumentConstructorNonZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber nn = this.constructorTest(1);
        NaturalNumber nnExp = this.constructorRef(1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
    }

    @Test
    public final void testNaturalNumberArgumentConstructorZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber arg = this.constructorRef(0);
        NaturalNumber nn = this.constructorTest(arg);
        NaturalNumber nnExp = this.constructorRef(arg);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
    }

    @Test
    public final void testNaturalNumberArgumentConstructorNonZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber arg = this.constructorRef(1);
        NaturalNumber nn = this.constructorTest(arg);
        NaturalNumber nnExp = this.constructorRef(arg);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
    }

    @Test
    public final void testMultiplyBy10ZeroAddZero() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(0);
        NaturalNumber nnExp = this.constructorRef(0);
        /*
         * Call method under test
         */
        nn.multiplyBy10(0);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
    }

    @Test
    public final void testMultiplyBy10ZeroAddNonZero() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(0);
        NaturalNumber nnExp = this.constructorRef(1);
        /*
         * Call method under test
         */
        nn.multiplyBy10(1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
    }

    @Test
    public final void testMultiplyBy10NonZeroAddZero() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(1);
        NaturalNumber nnExp = this.constructorRef(10);
        /*
         * Call method under test
         */
        nn.multiplyBy10(0);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
    }

    @Test
    public final void testMultiplyBy10NonZeroAddNonZero() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(1);
        NaturalNumber nnExp = this.constructorRef(11);
        /*
         * Call method under test
         */
        nn.multiplyBy10(1);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
    }

    @Test
    public final void testDivideBy10SingleDigitRemainderZero() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(0);
        NaturalNumber nnExp = this.constructorRef(0);
        int rem;
        int remExp = 0;
        /*
         * Call method under test
         */
        rem = nn.divideBy10();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
        assertEquals(rem, remExp);
    }

    @Test
    public final void testDivideBy10SingleDigitRemainderNonZero() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(1);
        NaturalNumber nnExp = this.constructorRef(0);
        int rem;
        int remExp = 1;
        /*
         * Call method under test
         */
        rem = nn.divideBy10();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
        assertEquals(rem, remExp);
    }

    @Test
    public final void testDivideBy10MultipleDigitsRemainderZero() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(20);
        NaturalNumber nnExp = this.constructorRef(2);
        int rem;
        int remExp = 0;
        /*
         * Call method under test
         */
        rem = nn.divideBy10();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
        assertEquals(rem, remExp);
    }

    @Test
    public final void testDivideBy10MultipleDigitsRemainderNonZero() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(21);
        NaturalNumber nnExp = this.constructorRef(2);
        int rem;
        int remExp = 1;
        /*
         * Call method under test
         */
        rem = nn.divideBy10();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nn, nnExp);
        assertEquals(rem, remExp);
    }

    @Test
    public final void testIsZeroZero() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(0);
        boolean res;
        boolean resExp = true;
        /*
         * Call method under test
         */
        res = nn.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(res, resExp);
    }

    @Test
    public final void testIsZeroHasZero() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(10);
        boolean res;
        boolean resExp = false;
        /*
         * Call method under test
         */
        res = nn.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(res, resExp);
    }

    @Test
    public final void testIsZeroHasZeroLeading() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(01);
        boolean res;
        boolean resExp = false;
        /*
         * Call method under test
         */
        res = nn.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(res, resExp);
    }

    @Test
    public final void testIsZeroNotZeroSingleDigit() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(1);
        boolean res;
        boolean resExp = false;
        /*
         * Call method under test
         */
        res = nn.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(res, resExp);
    }

    @Test
    public final void testIsZeroNotZeroMultipleDigits() {
        /*
         * Set up variables
         */
        NaturalNumber nn = this.constructorTest(12);
        boolean res;
        boolean resExp = false;
        /*
         * Call method under test
         */
        res = nn.isZero();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(res, resExp);
    }

}
