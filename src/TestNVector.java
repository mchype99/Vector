package q2;
import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;

public class TestNVector {
    public TestNVector() {
    }

    /**
     * Test of equals method, of class NVector.
     */
    @Test
    public void testEquals() {
        System.out.println("run test equals");
        NVector y = new NVector(1,3,5,7,8);
        NVector x = new NVector(1,3,7,9,11);
        boolean expected = false;
        boolean result = x.equals(y);
        assertEquals(expected, result);
    }

    /**
     * Test of vararg constructor, of class NVector.
     */
    @Test
    public void testNVector() {
        System.out.println("run test NVector");
        NVector x = new NVector(2,4,6,8,10);
        String expected = "[2.0 4.0 6.0 8.0 10.0]";
        String result = x.toString();
        assertEquals(expected, result);
    }

    /**
     * Test of get method, of class NVector.
     */
    @Test
    public void testGet() {
        System.out.println("run test get");
        int i = 0;
        NVector x = new NVector(10,20,30,40,50);
        double expected = 10.0;
        double result = x.get(i);
        assertTrue(expected==result);
    }

    /**
     * Test of add method, of class NVector.
     */
    @Test
    public void testAdd() {
        System.out.println("run test add");
        NVector y = new NVector(1,2,3,4,5);
        NVector x = new NVector(10,11,12,13,14);
        NVector expected = new NVector(11,13,15,17,19);
        NVector result = x.add(y);
        assertTrue(Arrays.equals(expected.v, result.v));
    }

    /**
     * Test of sprod method, of class NVector.
     */
    @Test
    public void testSprod() {
        System.out.println("run test sprod");
        NVector y = new NVector(1,2,3,4,5);
        NVector x = new NVector(10,11,12,13,14);
        double expected = 190;
        double result = x.sprod(y);
        assertTrue(expected == result);
    }

    /**
     * Test of toString method, of class NVector.
     */
    @Test
    public void testToString() {
        System.out.println("run test toString");
        NVector x = new NVector(5,10,15,20,25);
        String expected = "[5.0 10.0 15.0 20.0 25.0]";
        String result = x.toString();
        assertEquals(expected, result);
    }
}
