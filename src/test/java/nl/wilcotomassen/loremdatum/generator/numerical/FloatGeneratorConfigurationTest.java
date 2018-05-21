package nl.wilcotomassen.loremdatum.generator.numerical;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatGeneratorConfigurationTest extends NumericalGeneratorConfigurationTest {
	
	/**
	 * Get default FloatGeneratorConfiguration
	 * 
	 * @return
	 */
	protected FloatGeneratorConfiguration getFloatConfiguration() {
		return FloatGeneratorConfiguration.builder().buildConfiguration();
	}
	
	@Override
	protected NumericalGeneratorConfiguration getNumericalConfiguration(
			Integer seed, 
			Float naProbability, 
			Double variationLowerBound,
			Double variationUpperBound
			) {
		
		FloatGeneratorConfiguration.ConfigurationBuilder<?> configurationBuilder = 
				FloatGeneratorConfiguration.builder();
		
		if (seed != null) {
			configurationBuilder.seed(seed);
		}
		configurationBuilder.naProbability(naProbability);
		if (variationLowerBound != null) {
			configurationBuilder.variationLowerBound(variationLowerBound);
		}
		if (variationUpperBound != null) {
			configurationBuilder.variationUpperBound(variationUpperBound);
		}
		
		return configurationBuilder.buildConfiguration();
		
	}
	
	@Test
	public final void testInitiatorDefaultValue() {
		Assert.assertEquals(getFloatConfiguration().initiator, FloatGeneratorConfiguration.INITIATOR_DEFAULT);
	}
	
	@Test
	public final void testInitiatorSetter() {
		final float[] TEST_VALUES = {Float.MIN_VALUE, -2f, -1f, 0f, 1f, 2f, Float.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final float testValue = TEST_VALUES[i];
			
			FloatGeneratorConfiguration configuration = FloatGeneratorConfiguration.builder()
					.initiator(testValue)
					.buildConfiguration();
			
			Assert.assertEquals(configuration.initiator, testValue);
			
		}
	}
	
	@Test
	public final void testValueLowerBoundDefaultValue() {
		Assert.assertNull(getFloatConfiguration().valueLowerBound);
	}
	
	@Test
	public final void testValueLowerBoundSetter() {
		final float[] TEST_VALUES = {Float.MIN_VALUE, -2f, -1f, 0f, 1f, 2f, Float.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final float testValue = TEST_VALUES[i];
			
			FloatGeneratorConfiguration configuration = FloatGeneratorConfiguration.builder()
					.valueLowerBound(testValue)
					.buildConfiguration();
			
			Assert.assertEquals(configuration.valueLowerBound, testValue);
			
		}
	}
	
	@Test
	public final void testValueUpperBoundDefaultValue() {
		Assert.assertNull(getFloatConfiguration().valueUpperBound);
	}
	
	@Test
	public final void testValueUpperBoundSetter() {
		final float[] TEST_VALUES = {Float.MIN_VALUE, -2f, -1f, 0f, 1f, 2f, Float.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final float testValue = TEST_VALUES[i];
			
			FloatGeneratorConfiguration configuration = FloatGeneratorConfiguration.builder()
					.valueUpperBound(testValue)
					.buildConfiguration();
			
			Assert.assertEquals(configuration.valueUpperBound, testValue);
			
		}
	}
	
	@Test
	public final void testInvalidBoundsCombination() {
		
		// Upper bound lower then previously set lower bound
		Assert.assertThrows(IllegalArgumentException.class, () -> FloatGeneratorConfiguration.builder()
				.valueLowerBound(10f)
				.valueUpperBound(5f)
				.buildConfiguration());
		
		// Lower bound higher than previously set upper bound
		Assert.assertThrows(IllegalArgumentException.class, () -> FloatGeneratorConfiguration.builder()
				.valueUpperBound(5f)
				.valueLowerBound(10f)
				.buildConfiguration());
		
	}
	
}
