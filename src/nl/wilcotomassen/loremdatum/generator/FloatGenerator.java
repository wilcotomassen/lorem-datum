package nl.wilcotomassen.loremdatum.generator;

import nl.wilcotomassen.loremdatum.generator.configuration.FloatGeneratorConfiguration;

public class FloatGenerator extends RandomGenerator {
	
	private float currentValue;

	public FloatGenerator(FloatGeneratorConfiguration configuration) {
		super(configuration);
		currentValue = configuration.initiator;
	}
	
	@Override
	public Float current() {
		return currentValue;
	}

	@Override
	public Float next() {
		
		// Retrieve configuration
		FloatGeneratorConfiguration configuration = 
				(FloatGeneratorConfiguration) getConfiguration();
		
		// Define random variation (based on on current value)
		float variationRange = (configuration.variationUpperBound - configuration.variationLowerBound); 
		float variationMultiplier = configuration.variationLowerBound 
				+ random.nextFloat() * variationRange;
		float variation = currentValue * variationMultiplier;
		
		// Calculate new value
		float newValue = currentValue + variation;
		
		// Limit new value to configured value bounds
		if (configuration.valueLowerBound != null) {
			newValue = Math.max(newValue, configuration.valueLowerBound);
		}
		if (configuration.valueUpperBound != null) {
			newValue = Math.min(newValue, configuration.valueUpperBound);
		}

		// Update current value
		currentValue = newValue;
		
		return current();
		
	}
	
}
