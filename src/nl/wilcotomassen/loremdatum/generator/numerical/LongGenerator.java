package nl.wilcotomassen.loremdatum.generator.numerical;

import nl.wilcotomassen.loremdatum.generator.RandomGenerator;

/**
 * Numerical data generator of 64-bit signed integer values
 */
public class LongGenerator extends RandomGenerator {
	
	/**
	 * The current (last generated) value, which can be null (NA)
	 */
	private Long currentValue;
	
	/**
	 * The last generated value that wasn't NA (can't be null)
	 */
	private double lastDataValue;
	
	public LongGenerator(LongGeneratorConfiguration configuration) {
		super(configuration);
		currentValue = configuration.initiator;
		lastDataValue = currentValue;
	}
	
	@Override
	public Long getCurrent() {
		return currentValue; 
	}

	@Override
	public Long getNext() {
		
		// Check if we should generate a N/A value
		if (tryForNA()) {
			currentValue = null;
		} else {
		
			// Retrieve configuration
			LongGeneratorConfiguration configuration = 
					(LongGeneratorConfiguration) getConfiguration();
			
			// Define random variation (based on on current value)
			double variationMultiplier = random.nextUniform(
					configuration.variationUpperBound, 
					configuration.variationLowerBound);
			double variation = lastDataValue * variationMultiplier;
			
			// Calculate new value
			long newValue = (long) Math.round((double) lastDataValue + variation);
					
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
