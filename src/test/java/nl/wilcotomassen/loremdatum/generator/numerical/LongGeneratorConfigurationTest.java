package nl.wilcotomassen.loremdatum.generator.numerical;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LongGeneratorConfigurationTest extends NumericalGeneratorConfigurationTest {
	
	/**
	 * Get default LongGeneratorConfiguration
	 * 
	 * @return
	 */
	protected LongGeneratorConfiguration getIntegerConfiguration() {
		return LongGeneratorConfiguration.builder().buildConfiguration();
	}
	
	@Override
	protected NumericalGeneratorConfiguration getNumericalConfiguration(
			Integer seed, 
			Float naProbability, 
			Double variationLowerBound,
			Double variationUpperBound
			) {
		
		LongGeneratorConfiguration.ConfigurationBuilder<?> configurationBuilder = 
				LongGeneratorConfiguration.builder();
		
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
		Assert.assertEquals(getIntegerConfiguration().initiator, LongGeneratorConfiguration.INITIATOR_DEFAULT);
	}
	
	@Test
	public final void testInitiatorSetter() {
		final long[] TEST_VALUES = {Long.MIN_VALUE, -2, -1, 0, 1, 2, Long.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final long testValue = TEST_VALUES[i];
			
			LongGeneratorConfiguration configuration = LongGeneratorConfiguration.builder()
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
		final long[] TEST_VALUES = {Long.MIN_VALUE, -2, -1, 0, 1, 2, Long.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final long testValue = TEST_VALUES[i];
			
			LongGeneratorConfiguration configuration = LongGeneratorConfiguration.builder()
					.valueLowerBound(testValue)
					.buildConfiguration();
			
			Assert.assertEquals((Long) configuration.valueLowerBound, (Long) testValue);
			
		}
	}
	
	@Test
	public final void testValueUpperBoundDefaultValue() {
		Assert.assertNull(getIntegerConfiguration().valueUpperBound);
	}
	
	@Test
	public final void testValueUpperBoundSetter() {
		final long[] TEST_VALUES = {Long.MIN_VALUE, -2, -1, 0, 1, 2, Long.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final long testValue = TEST_VALUES[i];
			
			LongGeneratorConfiguration configuration = LongGeneratorConfiguration.builder()
					.valueUpperBound(testValue)
					.buildConfiguration();
			
			Assert.assertEquals((Long) configuration.valueUpperBound, (Long) testValue);
			
		}
	}
	
	@Test
	public final void testInvalidBoundsCombination() {
		
		// Upper bound lower then previously set lower bound
		Assert.assertThrows(IllegalArgumentException.class, () -> LongGeneratorConfiguration.builder()
				.valueLowerBound(10L)
				.valueUpperBound(5L)
				.buildConfiguration());
		
		// Lower bound higher than previously set upper bound
		Assert.assertThrows(IllegalArgumentException.class, () -> LongGeneratorConfiguration.builder()
				.valueUpperBound(5L)
				.valueLowerBound(10L)
				.buildConfiguration());
		
	}
	
}