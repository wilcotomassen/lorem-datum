package nl.wilcotomassen.loremdatum.generator.numerical;

import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfiguration;

/**
 * Generator configuration for the {@link LongGenerator} class
 */
public class LongGeneratorConfiguration extends RandomGeneratorConfiguration {
	
	/**
	 * Initial value
	 */
	public long initiator = 100;
	
	/**
	 * Limits in variation relative to the last
	 * generated value [-1.0, 1.0] in double precision
	 */
	public double variationLowerBound = -.1;
	public double variationUpperBound = +.1;
	
	/**
	 * Absolute limits of generated values, or null 
	 * if without limits 
	 */
	public Long valueLowerBound = null;
	public Long valueUpperBound = null;
}
