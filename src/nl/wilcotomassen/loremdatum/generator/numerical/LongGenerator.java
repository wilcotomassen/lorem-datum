package nl.wilcotomassen.loremdatum.generator.numerical;

import nl.wilcotomassen.loremdatum.generator.RandomGenerator;
import nl.wilcotomassen.loremdatum.generator.numerical.LongGeneratorConfiguration.ConfigurationBuilder;

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
					configuration.variationLowerBound, 
					configuration.variationUpperBound);
			double variation = lastDataValue * variationMultiplier;
			
			// Calculate new value (casting to double might lead to some imprecision)
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
	
	/**
	 * Get a configuration builder for this generator
	 * 
	 * @return a configuration builder for this generator
	 */
	public static ConfigurationBuilder<?> builder() {
		return LongGeneratorConfiguration.builder();
	}
	
}
