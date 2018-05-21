package nl.wilcotomassen.loremdatum.generator.numerical;

import org.testng.Assert;
import org.testng.annotations.Test;

import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfiguration;
import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfigurationTest;

/**
 * Tests for all NumericalConfigurations
 */
public abstract class NumericalGeneratorConfigurationTest extends RandomGeneratorConfigurationTest {
	
	/**
	 * Valid lower bound test values for variation (all these values should be accepted)
	 * Correct range: [-1.0, 0.0]
	 */
	public final static double[] VARIATION_LOWER_BOUND_VALID_TEST_VALUES = { 
		0.0, // Greatest allowed value
		-Double.MIN_NORMAL,	-.0001, -0.001, -0.01, -0.1, // Range of allowable values 
		-1.0 // Smallest allowed value
	}; 
	
	/**
	 * Invalid lower bound test values for variation (all these values should be rejected)
	 */
	public final static double[] VARIATION_LOWER_BOUND_INVALID_TEST_VALUES = { 
		Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, // Invalid numbers 
		-(1.0 + Double.MIN_VALUE), Double.MIN_VALUE, // Smallest out of bound values
		.0001, 0,001, 0.01, 0.1, 1.0 // Positive values
	}; 
	
	/**
	 * Valid upper bound test values for variation (all these values should be accepted)
	 * Correct range: [0.0, 1.0]
	 */
	public final static double[] VARIATION_UPPER_BOUND_VALID_TEST_VALUES = { 
		0.0, // Smallest allowed value
		Double.MIN_NORMAL, .0001, 0.001, 0.01, 0.1, // Range of allowed values 
		1.0 // Greatest allowed value
	}; 
	
	/**
	 * Invalid upper bound test values for variation (all these values should be rejected)
	 */
	public final static double[] VARIATION_UPPER_BOUND_INVALID_TEST_VALUES = { 
		Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, // NaN and infinity
		1.0 + Double.MIN_VALUE, -Double.MIN_VALUE, // Smallest out of bound values
		-.0001, -0.001, -0.01, -0.1, -1.0 // Negative values 
	};
	
	/**
	 * Fetch configuration of a subclass from {@link NumericalGeneratorConfiguration}
	 * 
	 * @param seed
	 * @param naProbability
	 * @param initiatior
	 * @param variationUpperBound
	 * @param variationLowerBound
	 * @return
	 */
	protected abstract NumericalGeneratorConfiguration getNumericalConfiguration(
			Integer seed,
			Float naProbability, 
			Double variationLowerBound,
			Double variationUpperBound);
	
	protected final NumericalGeneratorConfiguration getNumericalConfiguration() {
		return getNumericalConfiguration(null, null, null, null);
	}
	
	protected final RandomGeneratorConfiguration getRandomConfiguration(
			Integer seed,
			Float naProbability) {
		return getNumericalConfiguration(seed, naProbability, null, null);
	}
	
	private void testVariationLowerBoundEquals(NumericalGeneratorConfiguration configuration, 
			double expectedVariationLowerBound) {
		Assert.assertEquals(configuration.variationLowerBound, expectedVariationLowerBound);
	}
	
	private void testVariationUpperBoundEquals(NumericalGeneratorConfiguration configuration, 
			double expectedVariationUpperBound) {
		Assert.assertEquals(configuration.variationUpperBound, expectedVariationUpperBound);
	}
	
	@Test
	public final void testVariationLowerBoundDefaultValue() {
		testVariationLowerBoundEquals(getNumericalConfiguration(), NumericalGeneratorConfiguration.VARIATION_LOWER_BOUND_DEFAULT);
	}
	
	@Test
	public final void testVariationLowerBoundsWithValidValues() {
		for (int i = 0; i < VARIATION_LOWER_BOUND_VALID_TEST_VALUES.length; i++) {
			final double testValue = VARIATION_LOWER_BOUND_VALID_TEST_VALUES[i];
			testVariationLowerBoundEquals(getNumericalConfiguration(null, null, testValue, null), testValue);
		}
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testVariationLowerBoundsWithInvalidValues() {
		for (int i = 0; i < VARIATION_LOWER_BOUND_INVALID_TEST_VALUES.length; i++) {
			final double testValue = VARIATION_LOWER_BOUND_INVALID_TEST_VALUES[i];
			getNumericalConfiguration(null, null, testValue, null);
		}
	}
	
	@Test
	public final void testVariationUpperBoundDefaultValue() {
		testVariationUpperBoundEquals(getNumericalConfiguration(), NumericalGeneratorConfiguration.VARIATION_UPPER_BOUND_DEFAULT);
	}
	
	@Test
	public final void testVariationUpperBoundWithValidValues() {
		for (int i = 0; i < VARIATION_UPPER_BOUND_VALID_TEST_VALUES.length; i++) {
			final double testValue = VARIATION_UPPER_BOUND_VALID_TEST_VALUES[i];
			testVariationUpperBoundEquals(getNumericalConfiguration(null, null, null, testValue), testValue);
		}
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testVariationUpperBoundWithInvalidValues() {
		for (int i = 0; i < VARIATION_UPPER_BOUND_INVALID_TEST_VALUES.length; i++) {
			final double testValue = VARIATION_UPPER_BOUND_INVALID_TEST_VALUES[i];
			getNumericalConfiguration(null, null, null, testValue);
		}
	}
	
}
