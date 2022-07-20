package com.techelevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

/**
 * Test class to verify the results of each exercise. Each
 * test also runs two assertions from `BaseSolution.java` that
 * will check to make sure at least one variable has been declared
 * and that all variables are camelCased.
 */
@TestMethodOrder(value = OrderAnnotation.class)
public class ExercisesTest extends BaseSolution {

    @Test
    @Order(1)
    public void testSolution1() throws Exception {
        assertEquals(3, iTest.getIntResult());
    }

    @Test
    @Order(2)
    public void testSolution2() throws Exception {
        assertEquals(3, iTest.getIntResult());
    }

    @Test
    @Order(3)
    public void testSolution3() throws Exception {
        assertEquals(1, iTest.getIntResult());
    }

    @Test
    @Order(4)
    public void testSolution4() throws Exception {
        assertEquals(2, iTest.getIntResult());
    }

    @Test
    @Order(5)
    public void testSolution5() throws Exception {
        assertEquals(2, iTest.getIntResult());
    }

    @Test
    @Order(6)
    public void testSolution6() throws Exception {
        assertEquals(5, iTest.getIntResult());
    }

    @Test
    @Order(7)
    public void testSolution7() throws Exception {
        assertEquals(1, iTest.getIntResult());
    }

    @Test
    @Order(8)
    public void testSolution8() throws Exception {
        assertEquals(3, iTest.getIntResult());
    }

    @Test
    @Order(9)
    public void testSolution9() throws Exception {
        assertEquals(2, iTest.getIntResult());
    }

    @Test
    @Order(10)
    public void testSolution10() throws Exception {
        assertEquals(0.45d, iTest.getDoubleResult(), 0.01);
    }

    @Test
    @Order(11)
    public void testSolution11() throws Exception {
        assertEquals(55, iTest.getIntResult());
    }

    @Test
    @Order(12)
    public void testSolution12() throws Exception {
        assertEquals(0.38d, iTest.getDoubleResult(), 0.01);
    }

    @Test
    @Order(13)
    public void testSolution13() throws Exception {
        assertEquals(18, iTest.getIntResult());
    }

    @Test
    @Order(14)
    public void testSolution14() throws Exception {
        assertEquals(12, iTest.getIntResult());
    }

    @Test
    @Order(15)
    public void testSolution15() throws Exception {
        assertEquals(5.0d, iTest.getDoubleResult(), 0.01);
    }

    @Test
    @Order(16)
    public void testSolution16() throws Exception {
        assertEquals(9, iTest.getIntResult());
    }

    @Test
    @Order(17)
    public void testSolution17() throws Exception {
        assertEquals(6, iTest.getIntResult());
    }

    @Test
    @Order(18)
    public void testSolution18() throws Exception {
        assertEquals(9, iTest.getIntResult());
    }

    @Test
    @Order(19)
    public void testSolution19() throws Exception {
        assertEquals(48, iTest.getIntResult());
    }

    @Test
    @Order(20)
    public void testSolution20() throws Exception {
        assertEquals(48, iTest.getIntResult());
    }

    @Test
    @Order(21)
    public void testSolution21() throws Exception {
        assertEquals(1.98d, iTest.getDoubleResult(),0.01);
    }

    @Test
    @Order(22)
    public void testSolution22() throws Exception {
        assertEquals(61, iTest.getIntResult());
    }

    @Test
    @Order(23)
    public void testSolution23() throws Exception {
        assertEquals(23, iTest.getIntResult());
    }

    @Test
    @Order(24)
    public void testSolution24() throws Exception {
        assertEquals(46, iTest.getIntResult());
    }

    @Test
    @Order(25)
    public void testSolution25() throws Exception {
        assertEquals(135, iTest.getIntResult());
    }

    @Test
    @Order(26)
    public void testSolution26() throws Exception {
        assertEquals(3.0d, iTest.getDoubleResult(), 0.01);
    }

    @Test
    @Order(27)
    public void testSolution27() throws Exception {
        assertEquals(7, iTest.getIntResult());
    }

    @Test
    @Order(28)
    public void testSolution28() throws Exception {
        assertEquals(13, iTest.getIntResult());
    }

    @Test
    @Order(29)
    public void testSolution29() throws Exception {
        assertEquals(0.46d, iTest.getDoubleResult(), 0.01);
    }

    @Test
    @Order(30)
    public void testSolution30() throws Exception {
        assertEquals(25, iTest.getIntResult());
    }

    @Test
    @Order(31)
    public void testSolution31() throws Exception {
        assertEquals(48, iTest.getIntResult());
    }

    @Test
    @Order(32)
    public void testSolution32() throws Exception {
        assertEquals(20, iTest.getIntResult());
    }

    @Test
    @Order(33)
    public void testSolution33() throws Exception {
        assertEquals(2.0d, iTest.getDoubleResult(), 0.01);
    }

    @Test
    @Order(34)
    public void testSolution34() throws Exception {
        assertEquals(15, iTest.getIntResult());
    }

    @Test
    @Order(35)
    public void testSolution35() throws Exception {
        assertEquals(323, iTest.getIntResult());
    }

    @Test
    @Order(36)
    public void testSolution36() throws Exception {
        assertEquals(48, iTest.getIntResult());
    }

    @Test
    @Order(37)
    public void testSolution37() throws Exception {
        assertEquals(1110, iTest.getIntResult());
    }

    @Test
    @Order(38)
    public void testSolution38() throws Exception {
        assertEquals(220, iTest.getIntResult());
    }

    @Test
    @Order(39)
    public void testSolution39() throws Exception {
        // NOTE: It is common for students to select int as the return type, so this test first checks
        // to make sure they used double, and gives them a clear hint if not.
        double dblResult = iTest.getDoubleResult();
        if (dblResult == 0.0) {
            Assertions.fail("Make sure your final answer uses the most appropriate data type.");
        }
        assertEquals(12.5, dblResult);
    }

    @Test
    @Order(40)
    public void testSolution40() throws Exception {
        assertEquals(5, iTest.getIntResult());
    }

    @Test
    @Order(41)
    public void testSolution41() throws Exception {
        assertEquals(3, iTest.getIntResult());
    }

    @Test
    @Order(42)
    public void testSolution42() throws Exception {
        assertEquals(23, iTest.getIntResult());
    }

    @Test
    @Order(43)
    public void testSolution43() throws Exception {
        assertEquals(40, iTest.getIntResult());
    }

    @Test
    @Order(44)
    public void testSolution44() throws Exception {
        assertEquals(17, iTest.getIntResult());
    }

    @Test
    @Order(45)
    public void testSolution45() throws Exception {
        assertEquals(2, iTest.getIntResult());
    }

    @Test
    @Order(46)
    public void testSolution46() throws Exception {
        assertEquals(14, iTest.getIntResult());
    }

    @Test
    @Order(47)
    public void testSolution47() throws Exception {
        assertEquals(24, iTest.getIntResult());
    }

    @Test
    @Order(48)
    public void testSolution48() throws Exception {
        assertEquals(6, iTest.getIntResult());
    }

    @Test
    @Order(49)
    public void testSolution49() throws Exception {
        assertEquals(21, iTest.getIntResult());
    }

    @Test
    @Order(50)
    public void testSolution50() throws Exception {
        // NOTE: This is another exercise where a student may select int for return type when we
        // expect a double, so this test first checks to make sure they used double, and gives them a clear hint if not.
        double dblResult = iTest.getDoubleResult();
        if (dblResult == 0.0) {
            Assertions.fail("Make sure your final answer uses the most appropriate data type.");
        }
        assertEquals(2.4, dblResult, 0.1);
    }

    @Test
    @Order(51)
    public void testSolution51() throws Exception {
        assertEquals(5.043, iTest.getDoubleResult(), 0.01);
    }

    @Test
    @Order(52)
    public void testSolution52() throws Exception {
        assertEquals("Hopper, Grace B.", iTest.getStringResult());
    }

    @Test
    @Order(53)
    public void testSolution53() throws Exception {
        assertEquals(67, iTest.getIntResult());
    }
}
