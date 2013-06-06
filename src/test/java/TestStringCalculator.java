import Calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: khangpv
 * Date: 6/6/13
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStringCalculator {
    @Test
    public void testEmptyString(){
        Calculator cal = new Calculator();
        assertEquals(0,cal.add(""));
    }
    @Test
    public void testAddNumber(){
        Calculator cal = new Calculator();
        assertEquals(6,cal.add("1,2,3"));
    }
    @Test
    public void testAddNewLine(){
        Calculator cal = new Calculator();
        assertEquals(6,cal.add("1,2\n3"));
    }
    @Test
    public void testAddDelimiter(){
        Calculator cal = new Calculator();
        assertEquals(6,cal.add("//;\n1;2;3"));
    }
    @Test
    public void testThrowException(){
        Calculator cal = new Calculator();
        try {
            assertEquals(0,cal.add("//;\n1;2,-3"));
            fail();
        }catch (Exception e){
            assertEquals("negatives not allowed",e.getMessage());
        }

    }

}
