package nl.wilcotomassen.loremdatum.generator.configuration;

public class DoubleGeneratorConfiguration extends RandomGeneratorConfiguration {

	/**
	 * Initial value
	 */
	public double initiator = 100f;
	
	/**
	 * Limits in variation relative to the last
	 * generated value [-1.0, 1.0]
	 */
	public double variationLowerBound = -.1;
	public double variationUpperBound = +.1;
	
	/**
	 * Absolute limits of generated values 
	 */
	public Double valueLowerBound = null;
	public Double valueUpperBound = null;

}
