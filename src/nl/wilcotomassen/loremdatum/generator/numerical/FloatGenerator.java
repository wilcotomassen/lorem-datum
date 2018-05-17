package nl.wilcotomassen.loremdatum.generator.numerical;

import nl.wilcotomassen.loremdatum.generator.RandomGenerator;
import nl.wilcotomassen.loremdatum.generator.numerical.FloatGeneratorConfiguration.ConfigurationBuilder;

/**
 * Numerical data generator of floating point values with single
 * precision
 */
public class FloatGenerator extends RandomGenerator {
	
	/**
	 * The current (last generated) value, which can be null (NA)
	 */
	private Float currentValue;
	
	/**
	 * The last generated value that wasn't NA (can't be null)
	 */
	private float lastDataValue;
	
	public FloatGenerator(FloatGeneratorConfiguration configuration) {
		super(configuration);
		currentValue = configuration.initiator;
		lastDataValue = currentValue;
	}
	
	@Override
	public Float getCurrent() {
		return currentValue; 
	}

	@Override
	public Float getNext() {
		
		// Check if we should generate a N/A value
		if (tryForNA()) {
			currentValue = null;
		} else {
		
			// Retrieve configuration
			FloatGeneratorConfiguration configuration = 
					(FloatGeneratorConfiguration) getConfiguration();
			
			// Define random variation (based on on current value)
			double variationMultiplier = random.nextUniform(
					configuration.variationLowerBound, 
					configuration.variationUpperBound);
			float variation = (float) (lastDataValue * variationMultiplier);
			
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
		
		return getCurrent();
		
	}
	
	/**
	 * Get a configuration builder for this generator
	 * 
	 * @return a configuration builder for this generator
	 */
	public static ConfigurationBuilder<?> builder() {
		return FloatGeneratorConfiguration.builder();
	}
	
}
