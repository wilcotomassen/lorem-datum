package nl.wilcotomassen.loremdatum.generator.numerical;

import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfiguration;

public abstract class NumericalGeneratorConfiguration extends RandomGeneratorConfiguration {
	
	/**
	 * The lower bound for the variation of the generated
	 * values relative to the last generator value in double
	 * precision. Range is [-1.0, 0.0]
	 */
	private double variationLowerBound = -.1;
	
	/**
	 * The upper bound for the variation of the generated
	 * values relative to the last generator value in double
	 * precision. Range is [0.0, 1.0]
	 */
	private double variationUpperBound = +.1;
	
	/**
	 * Set the lower bound for the variation of the generated
	 * values relative to the last generator value in double
	 * precision. The supplied value is clamped to [-1.0, 0.0]
	 * 
	 * @param v Upper bound of the value generation variation [-1.0, 0.0]
	 */
	public final void setVariationLowerBound(double v) {
		variationLowerBound = Math.max(-1, Math.min(0, v));
	}
	
	/**
	 * Get the lower bound for the variation of the generated
	 * values relative to the last generator value in double
	 * precision. Range is [-1.0, 0.0]
	 * 
	 * @return
	 */
	public final double getVariationLowerBound() {
		return variationLowerBound;
	}
	
	/**
	 * Set the upper bound for the variation of the generated
	 * values relative to the last generator value in double
	 * precision. The supplied value is clamped to [0, 1]
	 * 
	 * @param v Upper bound of the value generation variation [0, 1]
	 */
	public final void setVariationUpperBound(double v) {
		variationUpperBound = Math.max(0, Math.min(1, v));
	}
	
	/**
	 * Get the upper bound for the variation of the generated
	 * values relative to the last generator value in double
	 * precision. Range is [0.0, 1.0]
	 *
	 * @return
	 */
	public final double getVariationUpperBound() {
		return variationUpperBound;
	}

}
