package nl.wilcotomassen.loremdatum.generator.numerical;

/**
 * Generator configuration for the {@link LongGenerator} class
 */
public class LongGeneratorConfiguration extends NumericalGeneratorConfiguration {
	
	/**
	 * Initial value
	 */
	public long initiator = 100;
	
	/**
	 * Absolute limits of generated values, or null 
	 * if without limits 
	 */
	public Long valueLowerBound = null;
	public Long valueUpperBound = null;
}
