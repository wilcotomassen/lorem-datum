package nl.wilcotomassen.loremdatum.generator.numerical;

import org.testng.Assert;
import org.testng.annotations.Test;

public abstract class NumericalGeneratorConfigurationTest {
	
	/**
	 * Valid lower bound test values for variation (all these values should be accepted)
	 */
	public final static double[] VARIATION_LOWER_BOUND_VALID_TEST_VALUES = { -Double.MIN_NORMAL, -.0001, -0,001, -0.01, -0.1, 
			-1.0};
	
	/**
	 * Invalid lower bound test values for variation (all these values should be rejected)
	 */
	public final static double[] VARIATION_LOWER_BOUND_INVALID_TEST_VALUES = { Double.NaN, Double.NEGATIVE_INFINITY, 
			Double.POSITIVE_INFINITY };
	
	/**
	 * Valid upper bound test values for variation (all these values should be accepted)
	 */
	public final static double[] VARIATION_UPPER_BOUND_VALID_TEST_VALUES = { Double.MIN_NORMAL, .0001, 0,001, 0.01, 0.1, 1.0 };
	
	/**
	 * Invalid upper bound test values for variation (all these values should be rejected)
	 */
	public final static double[] VARIATION_UPPER_BOUND_INVALID_TEST_VALUES = { Double.NaN, Double.NEGATIVE_INFINITY, 
			Double.POSITIVE_INFINITY };
	
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
	protected abstract NumericalGeneratorConfiguration getConfiguration(
			Integer seed,
			Float naProbability, 
			Double variationLowerBound,
			Double variationUpperBound);
	
	protected final NumericalGeneratorConfiguration getConfiguration() {
		return getConfiguration(null, null, null, null);
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
	public final void testVariationLowerBoundDefault() {
		testVariationLowerBoundEquals(getConfiguration(), NumericalGeneratorConfiguration.VARIATION_LOWER_BOUND_DEFAULT);
	}
	
	@Test
	public final void testVariationLowerBoundsValidValues() {
		for (int i = 0; i < VARIATION_LOWER_BOUND_VALID_TEST_VALUES.length; i++) {
			final double testValue = VARIATION_LOWER_BOUND_VALID_TEST_VALUES[i];
			testVariationLowerBoundEquals(getConfiguration(null, null, testValue, null), testValue);
		}
	}

	@Test
	public final void testVariationLowerBoundsInvalidValues() {
		for (int i = 0; i < VARIATION_LOWER_BOUND_INVALID_TEST_VALUES.length; i++) {
			final double testValue = VARIATION_LOWER_BOUND_INVALID_TEST_VALUES[i];
			testVariationLowerBoundEquals(getConfiguration(null, null, testValue, null), testValue);
		}
	}
	
	@Test
	public final void testVariationUpperBoundDefault() {
		testVariationUpperBoundEquals(getConfiguration(),NumericalGeneratorConfiguration.VARIATION_UPPER_BOUND_DEFAULT );
	}
	
	@Test
	public final void testVariationUpperBoundValidValues() {
		for (int i = 0; i < VARIATION_UPPER_BOUND_VALID_TEST_VALUES.length; i++) {
			final double testValue = VARIATION_UPPER_BOUND_VALID_TEST_VALUES[i];
			testVariationUpperBoundEquals(getConfiguration(null, null, testValue, null), testValue);
		}
	}
	
	@Test
	public final void testVariationUpperBoundInvalidValues() {
		for (int i = 0; i < VARIATION_UPPER_BOUND_INVALID_TEST_VALUES.length; i++) {
			final double testValue = VARIATION_UPPER_BOUND_INVALID_TEST_VALUES[i];
			testVariationUpperBoundEquals(getConfiguration(null, null, testValue, null), testValue);
		}
	}
	
}
