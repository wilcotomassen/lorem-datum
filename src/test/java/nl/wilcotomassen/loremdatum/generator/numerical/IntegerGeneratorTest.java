package nl.wilcotomassen.loremdatum.generator.numerical;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import nl.wilcotomassen.loremdatum.generator.RandomGenerator;
import nl.wilcotomassen.loremdatum.generator.RandomGeneratorTest;

public class IntegerGeneratorTest extends RandomGeneratorTest {
	
	@Override
	protected RandomGenerator getGenerator(Float naProbability) {
		return IntegerGenerator.builder()
				.naProbability(naProbability)
				.build();
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testBoundsFloatExtremes(@Optional("100") int generationTestCount) {
		testBounds(Integer.MIN_VALUE, Integer.MAX_VALUE, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testBoundsPositiveMax(@Optional("100") int generationTestCount) {
		testBounds(0, Integer.MAX_VALUE, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testBoundsPositive(@Optional("100") int generationTestCount) {
		testBounds(0, 1000, generationTestCount);
	}
	
	/**
	 * Test if generated values fall between given bounds for <generationTestCount> cases
	 * 
	 * @param lowerBound
	 * @param upperBound
	 * @param generationTestCount
	 */
	private void testBounds(int lowerBound, int upperBound, int generationTestCount) {
		
		// Setup generator
		int initiator = lowerBound + (upperBound - lowerBound) / 2;
		IntegerGenerator generator = IntegerGenerator.builder()
				.initiator(initiator)
				.naProbability(null)
				.valueLowerBound(lowerBound)
				.valueUpperBound(upperBound)
				.build();
		
		// Run tests
		for (int i = 0; i < generationTestCount; i++) {
			Integer value = generator.getNext();
			Assert.assertNotNull(value);
			Assert.assertTrue(value >= lowerBound);
			Assert.assertTrue(value <= upperBound);
			Assert.assertEquals(value, generator.getCurrent());
		}
		
	}
	
}
