package nl.wilcotomassen.loremdatum.generator.numerical;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import nl.wilcotomassen.loremdatum.generator.RandomGenerator;
import nl.wilcotomassen.loremdatum.generator.RandomGeneratorTest;

public class FloatGeneratorTest extends RandomGeneratorTest {
	
	@Override
	protected RandomGenerator getGenerator(Float naProbability) {
		return FloatGenerator.builder()
				.naProbability(naProbability)
				.build();
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testBoundsFloatExtremes(@Optional("100") int generationTestCount) {
		testBounds(Float.MIN_VALUE, Float.MAX_VALUE, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testBoundsPositiveMax(@Optional("100") int generationTestCount) {
		testBounds(0f, Float.MAX_VALUE, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testBoundsPositive(@Optional("100") int generationTestCount) {
		testBounds(0f, 0.1f, generationTestCount);
	}
	
	/**
	 * Test if generated values fall between given bounds for <generationTestCount> cases
	 * 
	 * @param lowerBound
	 * @param upperBound
	 * @param generationTestCount
	 */
	private void testBounds(float lowerBound, float upperBound, int generationTestCount) {
		
		// Setup generator
		float initiator = lowerBound + (upperBound - lowerBound) * 0.5f;
		FloatGenerator generator = FloatGenerator.builder()
				.initiator(initiator)
				.naProbability(null)
				.valueLowerBound(lowerBound)
				.valueUpperBound(upperBound)
				.build();
		
		// Run tests
		for (int i = 0; i < generationTestCount; i++) {
			Float value = generator.getNext();
			Assert.assertNotNull(value);
			Assert.assertTrue(value >= lowerBound);
			Assert.assertTrue(value <= upperBound);
		}
		
	}
	
}
