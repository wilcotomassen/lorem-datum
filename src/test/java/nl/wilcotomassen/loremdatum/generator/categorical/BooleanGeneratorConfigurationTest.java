package nl.wilcotomassen.loremdatum.generator.categorical;

import org.testng.Assert;
import org.testng.annotations.Test;

import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfiguration;
import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfigurationTest;

public class BooleanGeneratorConfigurationTest extends RandomGeneratorConfigurationTest {
	
	public final static double TEST_DELTA_DOUBLE = 0.0001;

	@Override
	protected RandomGeneratorConfiguration getRandomConfiguration(Integer seed, Float naProbability) {
		BooleanGeneratorConfiguration.ConfigurationBuilder<?> configurationBuilder 
			= BooleanGenerator.builder();
		
		if (seed != null) {
			configurationBuilder.seed(seed);
		}
		configurationBuilder.naProbability(naProbability);
		
		return configurationBuilder.buildConfiguration();
		
	}
	
	@Test
	public final void testTrueProbabilityDefaultValue() {
		Assert.assertEquals(BooleanGenerator.builder().buildConfiguration().trueProbability, 
				 BooleanGeneratorConfiguration.TRUE_PROBABILITY_DEFAULT, TEST_DELTA_DOUBLE);
	}
	
	@Test
	public final void testTrueProbabilitySetterWithValidValues() {
		final float[] TEST_VALUES = { 0f, Float.MIN_VALUE, 0.0001f, 0.1f, 0.5f, 0.9f, 1f };
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final float testValue = TEST_VALUES[i];
			
			BooleanGeneratorConfiguration configuration = BooleanGenerator.builder()
					.trueProbability(testValue)
					.buildConfiguration();
			
			Assert.assertEquals(configuration.trueProbability, testValue, TEST_DELTA_DOUBLE);
			
		}
	}
	
	@Test
	public final void testTrueProbabilitySetterWithInvalidValues() {
		final float[] TEST_VALUES = { -1 -0.001f, 1.0001f, 2f, Float.MAX_VALUE };
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final float testValue = TEST_VALUES[i];
			Assert.assertThrows(IllegalArgumentException.class, () -> BooleanGenerator.builder()
					.trueProbability(testValue)
					.buildConfiguration());
		}
	}

}
