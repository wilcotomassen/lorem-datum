package nl.wilcotomassen.loremdatum.generator.categorical;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BooleanGeneratorTest {
	
	@Parameters("generationTestCount")
	@Test
	public void testAllTrueNotNull(@Optional("100") int generationTestCount) {
		
		// Setup generator
		BooleanGenerator generator = BooleanGenerator.builder()
				.naProbability(null)
				.trueProbability(1f)
				.build();
		
		// Run tests
		for (int i = 0; i < generationTestCount; i++) {
			Boolean value = generator.getNext();
			Assert.assertNotNull(value);
			Assert.assertTrue(value);
		}
		
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testAllTrueNull(@Optional("100") int generationTestCount) {
		
		// Setup generator
		BooleanGenerator generator = BooleanGenerator.builder()
				.naProbability(.5f)
				.trueProbability(1f)
				.build();
		
		// Run tests
		for (int i = 0; i < generationTestCount; i++) {
			Boolean value = generator.getNext();
			
			if (value != null) {
				Assert.assertTrue(value);
			}
			
		}
		
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testAllFalse(@Optional("100") int generationTestCount) {
		
		// Setup generator
		BooleanGenerator generator = BooleanGenerator.builder()
				.naProbability(null)
				.trueProbability(0f)
				.build();
		
		// Run tests
		for (int i = 0; i < generationTestCount; i++) {
			Boolean value = generator.getNext();
			Assert.assertNotNull(value);
			Assert.assertFalse(value);
		}
		
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testAllFalseNull(@Optional("100") int generationTestCount) {
		
		// Setup generator
		BooleanGenerator generator = BooleanGenerator.builder()
				.naProbability(.5f)
				.trueProbability(0f)
				.build();
		
		// Run tests
		for (int i = 0; i < generationTestCount; i++) {
			Boolean value = generator.getNext();
			
			if (value != null) {
				Assert.assertFalse(value);
			}
			
		}
		
	}
	
}
