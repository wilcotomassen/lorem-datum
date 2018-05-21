package nl.wilcotomassen.loremdatum.generator.numerical;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegerGeneratorConfigurationTest  extends NumericalGeneratorConfigurationTest {
	
	/**
	 * Get default IntegerGeneratorConfiguration
	 * 
	 * @return
	 */
	protected IntegerGeneratorConfiguration getIntegerConfiguration() {
		return IntegerGeneratorConfiguration.builder().buildConfiguration();
	}
	
	@Override
	protected NumericalGeneratorConfiguration getNumericalConfiguration(
			Integer seed, 
			Float naProbability, 
			Double variationLowerBound,
			Double variationUpperBound
			) {
		
		IntegerGeneratorConfiguration.ConfigurationBuilder<?> configurationBuilder = 
				IntegerGeneratorConfiguration.builder();
		
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
		Assert.assertEquals(getIntegerConfiguration().initiator, IntegerGeneratorConfiguration.INITIATOR_DEFAULT);
	}
	
	@Test
	public final void testInitiatorSetter() {
		final int[] TEST_VALUES = {Integer.MIN_VALUE, -2, -1, 0, 1, 2, Integer.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final int testValue = TEST_VALUES[i];
			
			IntegerGeneratorConfiguration configuration = IntegerGeneratorConfiguration.builder()
					.initiator(testValue)
					.buildConfiguration();
			
			Assert.assertEquals(configuration.initiator, testValue);
			
		}
	}
	
	@Test
	public final void testValueLowerBoundDefaultValue() {
		Assert.assertNull(getIntegerConfiguration().valueLowerBound);
	}
	
	@Test
	public final void testValueLowerBoundSetter() {
		final int[] TEST_VALUES = {Integer.MIN_VALUE, -2, -1, 0, 1, 2, Integer.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final int testValue = TEST_VALUES[i];
			
			IntegerGeneratorConfiguration configuration = IntegerGeneratorConfiguration.builder()
					.valueLowerBound(testValue)
					.buildConfiguration();
			
			Assert.assertEquals((Integer) configuration.valueLowerBound, (Integer) testValue);
			
		}
	}
	
	@Test
	public final void testValueUpperBoundDefaultValue() {
		Assert.assertNull(getIntegerConfiguration().valueUpperBound);
	}
	
	@Test
	public final void testValueUpperBoundSetter() {
		final int[] TEST_VALUES = {Integer.MIN_VALUE, -2, -1, 0, 1, 2, Integer.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final int testValue = TEST_VALUES[i];
			
			IntegerGeneratorConfiguration configuration = IntegerGeneratorConfiguration.builder()
					.valueUpperBound(testValue)
					.buildConfiguration();
			
			Assert.assertEquals((Integer) configuration.valueUpperBound, (Integer) testValue);
			
		}
	}
	
	@Test
	public final void testInvalidBoundsCombination() {
		
		// Upper bound lower then previously set lower bound
		Assert.assertThrows(IllegalArgumentException.class, () -> IntegerGeneratorConfiguration.builder()
				.valueLowerBound(10)
				.valueUpperBound(5)
				.buildConfiguration());
		
		// Lower bound higher than previously set upper bound
		Assert.assertThrows(IllegalArgumentException.class, () -> IntegerGeneratorConfiguration.builder()
				.valueUpperBound(5)
				.valueLowerBound(10)
				.buildConfiguration());
		
	}
	
}