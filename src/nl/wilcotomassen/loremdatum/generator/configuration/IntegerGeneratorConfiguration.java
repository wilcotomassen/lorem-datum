package nl.wilcotomassen.loremdatum.generator.configuration;

public class IntegerGeneratorConfiguration extends RandomGeneratorConfiguration {

	/**
	 * Initial value
	 */
	public int initiator = 100;
	
	/**
	 * Limits in variation relative to the last
	 * generated value [-1.0, 1.0]
	 */
	public float variationLowerBound = -.1f;
	public float variationUpperBound = +.1f;
	
	/**
	 * Absolute limits of generated values 
	 */
	public Integer valueLowerBound = null;
	public Integer valueUpperBound = null;

	
}
