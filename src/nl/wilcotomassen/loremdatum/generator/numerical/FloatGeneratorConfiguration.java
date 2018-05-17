package nl.wilcotomassen.loremdatum.generator.numerical;

/**
 * Generator configuration for the {@link FloatGenerator} class
 */
public class FloatGeneratorConfiguration extends NumericalGeneratorConfiguration {

	/**
	 * Initial value
	 */
	public float initiator = 100f;
	
	/**
	 * Absolute limits of generated values, or null 
	 * if without limits 
	 */
	public Float valueLowerBound = null;
	public Float valueUpperBound = null;

}