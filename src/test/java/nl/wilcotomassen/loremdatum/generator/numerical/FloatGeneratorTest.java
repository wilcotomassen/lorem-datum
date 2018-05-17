package nl.wilcotomassen.loremdatum.generator.numerical;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatGeneratorTest {
	
	protected final static int SMALL_TEST_COUNT = 100;
	
	@Test
	public void testBoundsFloatExtremes() {
		testBounds(Float.MIN_VALUE, 0f, Float.MAX_VALUE, SMALL_TEST_COUNT);
	}
	
	@Test
	public void testBoundsPositiveMax() {
		testBounds(0f, 0.01f, Float.MAX_VALUE, SMALL_TEST_COUNT);
	}
	
	@Test
	public void testBoundsPositive() {
		testBounds(0f, 0.01f, 0.1f, SMALL_TEST_COUNT);
	}
	
	private void  testBounds(float lowerBound, float initiator, float upperBound, int testCount) {
		
		// Setup generator
		FloatGenerator generator = FloatGenerator.builder()
				.initiator(initiator)
				.valueLowerBound(lowerBound)
				.valueUpperBound(upperBound)
				.build();
		
		// Run tests
		for (int i = 0; i < testCount; i++) {
			Float value = generator.getNext();
			Assert.assertNotNull(value);
			Assert.assertTrue(value >= lowerBound);
			Assert.assertTrue(value <= upperBound);
		}
		
	}

}
