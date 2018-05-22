package nl.wilcotomassen.loremdatum.generator;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public abstract class RandomGeneratorTest {
	
	protected abstract RandomGenerator getGenerator(Float naProbability);
	
	@Parameters("generationTestCount")
	@Test
	private void testValuesNotNull(@Optional("100") int generationTestCount) {
		
		// Setup generator with NA probability of null (shouldn't generate any null values)
		RandomGenerator generator = getGenerator(null);
		
		// Run tests
		for (int i = 0; i < generationTestCount; i++) {
			Object value = generator.getNext();
			Assert.assertNotNull(value);
		}
		
	}
	
	@Parameters("generationTestCount")
	@Test
	private void testValuesAllNull(@Optional("100") int generationTestCount) {
		
		// Setup generator with NA probability of 1.0 (should generate only null values)
		RandomGenerator generator = getGenerator(new Float(1.0));
		
		// Run tests
		for (int i = 0; i < generationTestCount; i++) {
			Object value = generator.getNext();
			Assert.assertNull(value);
		}
		
	}

}
