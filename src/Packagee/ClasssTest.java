package Packagee;

import static org.junit.Assert.*;
import org.junit.Test;

public class ClasssTest {

    @Test
    public void testValidStudyHours() {
        assertTrue(Classs.isStudyHoursValid("5"));
    }

    @Test
    public void testEmptyStudyHours() {
        assertFalse(Classs.isStudyHoursValid(""));
    }

    @Test
    public void testNullStudyHours() {
        assertFalse(Classs.isStudyHoursValid(null));
    }

    @Test
    public void testAlphabetStudyHours() {
        assertFalse(Classs.isStudyHoursValid("abc"));
    }

    @Test
    public void testZeroStudyHours() {
        assertFalse(Classs.isStudyHoursValid("0"));
    }

    @Test
    public void testNegativeStudyHours() {
        assertFalse(Classs.isStudyHoursValid("-5"));
    }

    @Test
    public void testUpperBoundaryStudyHours() {
        assertTrue(Classs.isStudyHoursValid("24"));
    }

    @Test
    public void testExceedBoundaryStudyHours() {
        assertFalse(Classs.isStudyHoursValid("25"));
    }

    @Test
    public void testValidRollNumber() {
        assertTrue(Classs.isRollValid("12345"));
    }

    @Test
    public void testInvalidRollNumber() {
        assertFalse(Classs.isRollValid("SE123"));
    }

    @Test
    public void testEmptyRollNumber() {
        assertFalse(Classs.isRollValid(""));
    }

    @Test
    public void testNullRollNumber() {
        assertFalse(Classs.isRollValid(null));
    }


    @Test
    public void testHardRecommendation() {
        assertEquals("Study 3 Hours Daily",
                Classs.getRecommendation("Hard"));
    }

    @Test
    public void testMediumRecommendation() {
        assertEquals("Study 2 Hours Daily",
                Classs.getRecommendation("Medium"));
    }

    @Test
    public void testEasyRecommendation() {
        assertEquals("Study 1 Hour Daily",
                Classs.getRecommendation("Easy"));
    }
}