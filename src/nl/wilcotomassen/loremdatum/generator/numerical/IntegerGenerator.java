package nl.wilcotomassen.loremdatum.generator.numerical;

import nl.wilcotomassen.loremdatum.generator.RandomGenerator;

/**
 * Numerical data generator of 32-bit signed integer values
 */
public class IntegerGenerator extends RandomGenerator {
	
	/**
	 * The current (last generated) value, which can be null (NA)
	 */
	private Integer currentValue;
	
	/**
	 * The last generated value that wasn't NA (can't be null)
	 */
	private int lastDataValue;
	
	public IntegerGenerator(IntegerGeneratorConfiguration configuration) {
		super(configuration);
		currentValue = configuration.initiator;
		lastDataValue = currentValue;
	}
	
	@Override
	public Integer getCurrent() {
		return currentValue;
	}

	@Override
	public Integer getNext() {
		
		// Check if we should generate a N/A value
		if (tryForNA()) {
			currentValue = null;
		} else {
		
			// Retrieve configuration
			IntegerGeneratorConfiguration configuration = 
					(IntegerGeneratorConfiguration) getConfiguration();
			
			// Define random variation (based on on current value)
			double variationMultiplier = random.nextUniform(
					configuration.variationLowerBound, 
					configuration.variationUpperBound);
			double variation = (double) lastDataValue * variationMultiplier;
			
			// Calculate new value (casting to double might lead to some imprecision)
			int newValue = (int) Math.round((double) lastDataValue + variation);
					
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
