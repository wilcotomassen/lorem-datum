package nl.wilcotomassen.loremdatum.generator.numerical;

import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfiguration;

/**
 * Generator configuration for the {@link FloatGenerator} class
 */
public class FloatGeneratorConfiguration extends RandomGeneratorConfiguration {

	/**
	 * Initial value
	 */
	public float initiator = 100f;
	
	/**
	 * Limits in variation relative to the last
	 * generated value [-1.0, 1.0] in double precision
	 */
	public double variationLowerBound = -.1f;
	public double variationUpperBound = +.1f;
	
	/**
	 * Absolute limits of generated values, or null 
	 * if without limits 
	 */
	public Float valueLowerBound = null;
	public Float valueUpperBound = null;

}