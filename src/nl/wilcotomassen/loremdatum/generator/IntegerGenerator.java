package nl.wilcotomassen.loremdatum.generator;

import nl.wilcotomassen.loremdatum.generator.configuration.IntegerGeneratorConfiguration;

public class IntegerGenerator extends RandomGenerator {
	
	private int currentValue;

	public IntegerGenerator(IntegerGeneratorConfiguration configuration) {
		super(configuration);
		currentValue = configuration.initiator;
	}

	@Override
	public Integer current() {
		return currentValue;
	}

	@Override
	public Object next() {
		
		// Retrieve configuration
		IntegerGeneratorConfiguration configuration = 
				(IntegerGeneratorConfiguration) getConfiguration();
		
		// Define random variation (based on on current value)
		float variationRange = (configuration.variationUpperBound - configuration.variationLowerBound); 
		float variationMultiplier = configuration.variationLowerBound 
				+ random.nextFloat() * (float) variationRange;
		int variation = Math.round(currentValue * variationMultiplier);
		
		// Calculate new value
		int newValue = currentValue + variation;
		
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
