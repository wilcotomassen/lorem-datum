package nl.wilcotomassen.loremdatum.generator.numerical;

import org.testng.Assert;
import org.testng.annotations.Test;

public abstract class NumericalGeneratorConfigurationTest {
	
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
	public final void testVariationLowerBoundPositiveSetterNotNull() {
		final double variationLowerBound = .001;
		testVariationLowerBoundEquals(getConfiguration(null, null, variationLowerBound, null), variationLowerBound);
	}
	
	@Test
	public final void testVariationUpperBoundDefault() {
		testVariationUpperBoundEquals(getConfiguration(),NumericalGeneratorConfiguration.VARIATION_UPPER_BOUND_DEFAULT );
	}
	
	@Test
	public final void testVariationUpperBoundPositiveSetterNotNull() {
		final double variationUpperBound = .3;
		testVariationUpperBoundEquals(getConfiguration(null, null, null, variationUpperBound), variationUpperBound);
	}
	
	@Test
	public final void testVariationUpperBoundNegativeSetterNotNull() {
		//@TODO : Should not work, as it exceeds the bounds
		final double variationUpperBound = -.3;
		testVariationUpperBoundEquals(getConfiguration(null, null, null, variationUpperBound), variationUpperBound);
	}
	
}
