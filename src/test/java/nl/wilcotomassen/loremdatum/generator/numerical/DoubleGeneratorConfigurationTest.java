package nl.wilcotomassen.loremdatum.generator.numerical;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleGeneratorConfigurationTest extends NumericalGeneratorConfigurationTest {
	
	public final static double TEST_DELTA_DOUBLE = 0.0001;
	
	/**
	 * Get default DoubleGeneratorConfiguration
	 * 
	 * @return
	 */
	protected DoubleGeneratorConfiguration getDoubleConfiguration() {
		return DoubleGeneratorConfiguration.builder().buildConfiguration();
	}
	
	@Override
	protected NumericalGeneratorConfiguration getNumericalConfiguration(
			Integer seed, 
			Float naProbability, 
			Double variationLowerBound,
			Double variationUpperBound
			) {
		
		DoubleGeneratorConfiguration.ConfigurationBuilder<?> configurationBuilder = 
				DoubleGeneratorConfiguration.builder();
		
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
		Assert.assertEquals(getDoubleConfiguration().initiator, DoubleGeneratorConfiguration.INITIATOR_DEFAULT, TEST_DELTA_DOUBLE);
	}
	
	@Test
	public final void testInitiatorSetter() {
		final double[] TEST_VALUES = {Double.MIN_VALUE, -2f, -1f, 0f, 1f, 2f, Double.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final double testValue = TEST_VALUES[i];
			
			DoubleGeneratorConfiguration configuration = DoubleGeneratorConfiguration.builder()
					.initiator(testValue)
					.buildConfiguration();
			
			Assert.assertEquals(configuration.initiator, testValue, TEST_DELTA_DOUBLE);
			
		}
	}
	
	@Test
	public final void testValueLowerBoundDefaultValue() {
		Assert.assertNull(getDoubleConfiguration().valueLowerBound);
	}
	
	@Test
	public final void testValueLowerBoundSetter() {
		final double[] TEST_VALUES = {Double.MIN_VALUE, -2, -1, 0, 1f, 2f, Double.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final double testValue = TEST_VALUES[i];
			
			DoubleGeneratorConfiguration configuration = DoubleGeneratorConfiguration.builder()
					.valueLowerBound(testValue)
					.buildConfiguration();
			
			Assert.assertEquals(configuration.valueLowerBound, testValue, TEST_DELTA_DOUBLE);
			
		}
	}
	
	@Test
	public final void testValueUpperBoundDefaultValue() {
		Assert.assertNull(getDoubleConfiguration().valueUpperBound);
	}
	
	@Test
	public final void testValueUpperBoundSetter() {
		final double[] TEST_VALUES = {Double.MIN_VALUE, -2f, -1f, 0f, 1f, 2f, Double.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final double testValue = TEST_VALUES[i];
			
			DoubleGeneratorConfiguration configuration = DoubleGeneratorConfiguration.builder()
					.valueUpperBound(testValue)
					.buildConfiguration();
			
			Assert.assertEquals(configuration.valueUpperBound, testValue, TEST_DELTA_DOUBLE);
			
		}
	}
	
	@Test
	public final void testInvalidBoundsCombination() {
		
		// Upper bound lower then previously set lower bound
		Assert.assertThrows(IllegalArgumentException.class, () -> DoubleGeneratorConfiguration.builder()
				.valueLowerBound(10.0)
				.valueUpperBound(5.0)
				.buildConfiguration());
		
		// Lower bound higher than previously set upper bound
		Assert.assertThrows(IllegalArgumentException.class, () -> DoubleGeneratorConfiguration.builder()
				.valueUpperBound(5.0)
				.valueLowerBound(10.0)
				.buildConfiguration());
		
	}
	
}
