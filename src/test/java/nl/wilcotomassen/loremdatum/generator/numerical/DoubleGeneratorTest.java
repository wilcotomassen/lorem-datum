package nl.wilcotomassen.loremdatum.generator.numerical;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import nl.wilcotomassen.loremdatum.generator.RandomGenerator;
import nl.wilcotomassen.loremdatum.generator.RandomGeneratorTest;

public class DoubleGeneratorTest extends RandomGeneratorTest {
	
	@Override
	protected RandomGenerator getGenerator(Float naProbability) {
		return DoubleGenerator.builder()
				.naProbability(naProbability)
				.build();
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testBoundsFloatExtremes(@Optional("100") int generationTestCount) {
		testBounds(Double.MIN_VALUE, Double.MAX_VALUE, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testBoundsPositiveMax(@Optional("100") int generationTestCount) {
		testBounds(0, Double.MAX_VALUE, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testBoundsPositive(@Optional("100") int generationTestCount) {
		testBounds(0, 0.1, generationTestCount);
	}
	
	/**
	 * Test if generated values fall between given bounds for <generationTestCount> cases
	 * 
	 * @param lowerBound
	 * @param upperBound
	 * @param generationTestCount
	 */
	private void testBounds(double lowerBound, double upperBound, int generationTestCount) {
		
		// Setup generator
		double initiator = lowerBound + (upperBound - lowerBound) * 0.5;
		DoubleGenerator generator = DoubleGenerator.builder()
				.initiator(initiator)
				.naProbability(null)
				.valueLowerBound(lowerBound)
				.valueUpperBound(upperBound)
				.build();
		
		// Run tests
		for (int i = 0; i < generationTestCount; i++) {
			Double value = generator.getNext();
			Assert.assertNotNull(value);
			Assert.assertTrue(value >= lowerBound);
			Assert.assertTrue(value <= upperBound);
			Assert.assertEquals(value, generator.getCurrent());
		}
		
	}
	
}
