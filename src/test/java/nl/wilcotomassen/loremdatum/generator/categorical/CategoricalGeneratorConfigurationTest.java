package nl.wilcotomassen.loremdatum.generator.categorical;

import org.testng.Assert;
import org.testng.annotations.Test;

import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfiguration;
import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfigurationTest;
import nl.wilcotomassen.loremdatum.generator.categorical.CategoricalGeneratorConfiguration.ConfigurationBuilder;
import nl.wilcotomassen.loremdatum.generator.categorical.CategoricalGeneratorConfiguration.Item;

public class CategoricalGeneratorConfigurationTest extends RandomGeneratorConfigurationTest  {
	
	@Override
	protected RandomGeneratorConfiguration getRandomConfiguration(Integer seed, Float naProbability) {
		CategoricalGeneratorConfiguration.ConfigurationBuilder<?> configurationBuilder 
			= CategoricalGenerator.builder();
		
		if (seed != null) {
			configurationBuilder.seed(seed);
		}
		configurationBuilder.naProbability(naProbability);
		
		return configurationBuilder.buildConfiguration();
		
	}
	
	@Test
	public final void testItemSetter() {
		
		final Object[] TEST_VALUES = { 1f, "Hello world", 132, 3002L};
		final double[] TEST_PROBABILITIES = {13, 93, 102, 34};
		
		// Build configuration
		ConfigurationBuilder<?> builder = CategoricalGenerator.builder();
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final Object testValue = TEST_VALUES[i];
			final double testProbability = TEST_PROBABILITIES[i];
			builder.addItem(testProbability, testValue);
		}
		CategoricalGeneratorConfiguration configuration = 
				builder.buildConfiguration();
		
		// Test for existence of values in configuration
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final Object testValue = TEST_VALUES[i];
			final double testProbability = TEST_PROBABILITIES[i];
			
			Item item = new Item(testProbability, testValue);
			Assert.assertTrue(configuration.items.contains(item));
		}
		
	}
		
		

}
