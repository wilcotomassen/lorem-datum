package nl.wilcotomassen.loremdatum.generator.numerical;

/**
 * Generator configuration for the {@link DoubleGenerator} class
 */
public class DoubleGeneratorConfiguration extends NumericalGeneratorConfiguration {

	/**
	 * Initial value
	 */
	public double initiator = 100;
	
	/**
	 * Absolute limits of generated values, or null 
	 * if without limits 
	 */
	public Double valueLowerBound = null;
	public Double valueUpperBound = null;

}
