package nl.wilcotomassen.loremdatum.generator.configuration;

public class FloatGeneratorConfiguration extends RandomGeneratorConfiguration {

	/**
	 * Initial value
	 */
	public float initiator = 100f;
	
	/**
	 * Limits in variation relative to the last
	 * generated value [-1.0, 1.0]
	 */
	public float variationLowerBound = -.1f;
	public float variationUpperBound = +.1f;
	
	/**
	 * Absolute limits of generated values 
	 */
	public Float valueLowerBound = null;
	public Float valueUpperBound = null;

}