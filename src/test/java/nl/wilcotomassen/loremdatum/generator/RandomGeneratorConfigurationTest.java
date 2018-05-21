package nl.wilcotomassen.loremdatum.generator;

import org.testng.Assert;
import org.testng.annotations.Test;

public abstract class RandomGeneratorConfigurationTest {
	
	/**
	 * Valid test values for NA Probability (all these values should be accepted)
	 * Correct range: [0.0, 1.0]
	 */
	public final static Float[] NAPROBABILITY_VALID_TEST_VALUES = { 
		0.0f, // Smallest allowed value
		Float.MIN_NORMAL, .0001f, 0.001f, 0.01f, 0.1f, // Range of allowed values 
		1.0f, // Greatest allowed value
		null // null
	}; 
	
	/**
	 * Invalid test values for NA Probability (all these values should be rejected)
	 */
	public final static Float[] NAPROBABILITY_INVALID_TEST_VALUES = { 
		Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, // NaN and infinity
		1.0f + Float.MIN_VALUE, -Float.MIN_VALUE, // Smallest out of bound values
		-.0001f, -0.001f, -0.01f, -0.1f, -1.0f // Negative values 
	};
	
	/**
	 * Fetch configuration of a subclass from {@link RandomGeneratorConfiguration}
	 * 
	 * @param seed
	 * @param naProbability
	 * @return
	 */
	protected abstract RandomGeneratorConfiguration getRandomConfiguration(
			Integer seed,
			Float naProbability);
	
	protected final RandomGeneratorConfiguration getRandomConfiguration() {
		return getRandomConfiguration(null, null);
	}
	
	private void testNaProbabilityEquals(RandomGeneratorConfiguration configuration, float expectedNaProbability) {
		Assert.assertEquals(configuration.naProbability, expectedNaProbability);
	}
	
	@Test
	public final void testSeedSetter() {
		final int[] TEST_VALUES = {Integer.MIN_VALUE, -2, -1, 0, 1, 2, Integer.MAX_VALUE};
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final int testValue = TEST_VALUES[i];
			RandomGeneratorConfiguration configuration = getRandomConfiguration(testValue, null);
			Assert.assertEquals(configuration.seed, testValue);
		}
	}
	
	@Test
	public final void testNaProbabilityDefaultValue() {
		Assert.assertNull(getRandomConfiguration().naProbability);
	}
	
	@Test
	public final void testNaProbabilitySetterWithValidValues() {
		for (int i = 0; i < NAPROBABILITY_VALID_TEST_VALUES.length; i++) {
			final Float testValue = NAPROBABILITY_VALID_TEST_VALUES[i];
			RandomGeneratorConfiguration configuration = getRandomConfiguration(null, testValue);
			if (testValue == null) {
				Assert.assertNull(configuration.naProbability);
			} else {
				testNaProbabilityEquals(configuration, testValue);
			}
		}
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testNaProbabilitySetterWithInvalidValues() {
		for (int i = 0; i < NAPROBABILITY_INVALID_TEST_VALUES.length; i++) {
			final float testValue = NAPROBABILITY_INVALID_TEST_VALUES[i];
			testNaProbabilityEquals(getRandomConfiguration(null, testValue), testValue);
		}
	}
}
