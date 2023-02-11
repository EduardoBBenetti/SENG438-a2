package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
	private Range exampleRange;

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-2, 3);
	}

	// --------------------------- contains()

	@Test
	public void containsShouldBeFalseLower() {
		assertFalse("The answer should be false", exampleRange.contains(-5));
	}

	@Test
	public void containsShouldBeFalseUpper() {
		assertFalse("The answer should be false", exampleRange.contains(6.3));
	}

	@Test
	public void containsShouldBeTrueLowerBound() {
		assertTrue("The answer should be true", exampleRange.contains(-2));
	}

	@Test
	public void containsShouldBeTrueUpperBound() {
		assertTrue("The answer should be true", exampleRange.contains(3));
	}

	@Test
	public void containsShouldBeTrueBetween() {
		assertTrue("The answer should be true", exampleRange.contains(0.0));
	}

	// --------------------------- getLength()
	@Test
	public void getLengthShouldBeFive() {
		assertEquals("The central value of -2 and 3 should be 5", 5, exampleRange.getLength(), .000000001d);
	}

	@Test
	public void getLengthShouldBeZero() {
		Range R = new Range(0, 0);
		assertEquals("The central value of 0 and 0 should be 0", 0, R.getLength(), .000000001d);
	}

	// --------------------------- getLowerBound()
	@Test
	public void getLowerBoundShouldBeMinusTwo() {
		assertEquals("The lower bound value of -2 and 3 should be -2", -2, exampleRange.getLowerBound(), .000000001d);
	}

	@Test
	public void getLowerBoundShouldBeOne() {
		Range R = new Range(1, 5);
		assertEquals("The lower bound value of 1 and 5 should be 1", 1, R.getLowerBound(), .000000001d);
	}

	// --------------------------- intersects()
	@Test
	public void intersectsShouldBeTrueLower() {
		assertTrue("The lines interesect", exampleRange.intersects(-3, 0));
	}

	@Test
	public void intersectsShouldBeTrueMiddle() {
		assertTrue("The lines interesect", exampleRange.intersects(1, 2));
	}

	@Test
	public void intersectsShouldBeTrueUpper() { // This test case is not working
		assertTrue("The lines interesect", exampleRange.intersects(2, 6));
	}

	@Test
	public void intersectsShouldBeTrueLowerUpper() {
		assertTrue("The lines interesect", exampleRange.intersects(-4, 4));
	}

	@Test
	public void intersectsShouldBeFalseLower() { // This test case is not working
		assertFalse("The lines do not interesect", exampleRange.intersects(-7, -4));
	}

	@Test
	public void intersectsShouldBeFalseUpper() {
		assertFalse("The lines do not interesect", exampleRange.intersects(4, 6));
	}

	// --------------------------- toString()
	@Test
	public void toStringNegativePositive() { // This test case is not working (lower bound)
		assertEquals("The answer should be 'Range[-2.0,3.0]'", "Range[-2.0,3.0]", exampleRange.toString());
	}

	@Test
	public void toStringPositivePositive() { // This test case is not working (lower bound)
		Range R = new Range(2, 4.2);
		assertEquals("The answer should be 'Range[2.0,4.2]'", "Range[2.0,4.2]", R.toString());
	}

	@Test
	public void toStringNegativeNegative() { // This test case is not working (lower bound)
		Range R = new Range(-4.3, -1.2);
		assertEquals("The answer should be 'Range[-4.3,-1.2]'", "Range[-4.3,-1.2]", R.toString());
	}

	@After
	public void tearDown() throws Exception {
	}
}