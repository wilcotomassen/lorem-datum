package nl.wilcotomassen.loremdatum.generator;

import nl.wilcotomassen.loremdatum.generator.configuration.FloatGeneratorConfiguration;

public class FloatGenerator extends RandomGenerator {
	
	/**
	 * Current value (can be null)
	 */
	private Float currentValue;
	
	/**
	 * Last data value (can't be null)
	 */
	private float lastDataValue;

	public FloatGenerator(FloatGeneratorConfiguration configuration) {
		super(configuration);
		currentValue = configuration.initiator;
		lastDataValue = currentValue;
	}
	
	@Override
	public Float current() {
		return currentValue;
	}

	@Override
	public Float next() {
		
		// Check if we should generate a N/A value
		if (tryForNA()) {
			currentValue = null;
		} else {
		
			// Retrieve configuration
			FloatGeneratorConfiguration configuration = 
					(FloatGeneratorConfiguration) getConfiguration();
			
			// Define random variation (based on on current value)
			float variationRange = (configuration.variationUpperBound - configuration.variationLowerBound); 
			float variationMultiplier = configuration.variationLowerBound 
					+ random.nextFloat() * variationRange;
			float variation = lastDataValue * variationMultiplier;
			
			// Calculate new value
			float newValue = lastDataValue + variation;
			
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
		
		return current();
		
	}
	
}
