package nl.wilcotomassen.loremdatum.generator.numerical;

import nl.wilcotomassen.loremdatum.generator.RandomGenerator;

/**
 * Numerical data generator of floating point values with double
 * precision
 */
public class DoubleGenerator extends RandomGenerator {
	
	/**
	 * The current (last generated) value, which can be null (NA)
	 */
	private Double currentValue;
	
	/**
	 * The last generated value that wasn't NA (can't be null)
	 */
	private double lastDataValue;
	
	public DoubleGenerator(DoubleGeneratorConfiguration configuration) {
		super(configuration);
		currentValue = configuration.initiator;
		lastDataValue = currentValue;
	}
	
	@Override
	public Double getCurrent() {
		return currentValue; 
	}

	@Override
	public Double getNext() {
		
		// Check if we should generate a N/A value
		if (tryForNA()) {
			currentValue = null;
		} else {
		
			// Retrieve configuration
			DoubleGeneratorConfiguration configuration = 
					(DoubleGeneratorConfiguration) getConfiguration();
			
			// Define random variation (based on on current value)
			double variationMultiplier = random.nextUniform(
					configuration.getVariationLowerBound(), 
					configuration.getVariationUpperBound());
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
