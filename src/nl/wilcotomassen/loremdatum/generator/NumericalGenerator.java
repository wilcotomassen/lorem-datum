package nl.wilcotomassen.loremdatum.generator;

import nl.wilcotomassen.loremdatum.generator.configuration.DoubleGeneratorConfiguration;

/**
 * Class for generating numerical values (in double precision) that acts
 * as a base class for other numerical generators.
 * 
 * Classes using this base class are {@link DoubleGenerator}, 
 * {@link FloatGenerator} and {@link IntegerGenerator}
 */
public abstract class NumericalGenerator extends RandomGenerator {
	
	/**
	 * The current (last generated) value, which can be null (NA)
	 */
	private Double currentValue;
	
	/**
	 * The last generated value that wasn't NA (can't be null)
	 */
	private double lastDataValue;

	public NumericalGenerator(DoubleGeneratorConfiguration configuration) {
		super(configuration);
		currentValue = configuration.initiator;
		lastDataValue = currentValue;
	}
	
	/**
	 * Get the current (last generated) value
	 * 
	 * @return
	 */
	protected Double getCurrent() {
		return currentValue;
	}

	/**
	 * Generate a new value and return it
	 * 
	 * @return
	 */
	protected Double getNext() {
		
		// Check if we should generate a N/A value
		if (tryForNA()) {
			currentValue = null;
		} else {
		
			// Retrieve configuration
			DoubleGeneratorConfiguration configuration = 
					(DoubleGeneratorConfiguration) getConfiguration();
			
			// Define random variation (based on on current value)
			double variationRange = (configuration.variationUpperBound - configuration.variationLowerBound); 
			double variationMultiplier = configuration.variationLowerBound 
					+ random.nextDouble() * variationRange;
			double variation = lastDataValue * variationMultiplier;
			
			// Calculate new value
			double newValue = lastDataValue + variation;
					
			// Limit new value to configured value bounds
			if (configuration.valueLowerBound != null) {
				newValue = Math.max(newValue, configuration.valueLowerBound);
			}
			if (configuration.valueUpperBound != null) {
				newValue = Math.min(newValue, configuration.valueUpperBound);
			}
			
			// Update current and last data value
			currentValue = newValue;
			lastDataValue = newValue;
			
		}
		
		return getCurrent();
		
	}

}
