package nl.wilcotomassen.loremdatum.generator.numerical;

/**
 * Generator configuration for the {@link IntegerGenerator} class
 */
public class IntegerGeneratorConfiguration extends NumericalGeneratorConfiguration {

	/**
	 * Initial value
	 */
	public int initiator = 100;
	
	/**
	 * Absolute limits of generated values, or null if without
	 * limits  
	 */
	public Integer valueLowerBound = null;
	public Integer valueUpperBound = null;

	
}
