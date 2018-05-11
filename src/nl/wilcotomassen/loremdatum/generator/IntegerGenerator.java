package nl.wilcotomassen.loremdatum.generator;

import nl.wilcotomassen.loremdatum.generator.configuration.IntegerGeneratorConfiguration;

public class IntegerGenerator extends RandomGenerator {
	
	private Integer currentValue;
	
	private int lastDataValue;

	public IntegerGenerator(IntegerGeneratorConfiguration configuration) {
		super(configuration);
		currentValue = configuration.initiator;
		lastDataValue = currentValue;
	}

	@Override
	public Integer current() {
		return currentValue;
	}

	@Override
	public Object next() {
		
		if (tryForNA()) {
			currentValue = null;
		} else {

			// Retrieve configuration
			IntegerGeneratorConfiguration configuration = 
					(IntegerGeneratorConfiguration) getConfiguration();
			
			// Define random variation (based on on current value)
			float variationRange = (configuration.variationUpperBound - configuration.variationLowerBound); 
			float variationMultiplier = configuration.variationLowerBound 
					+ random.nextFloat() * (float) variationRange;
			int variation = Math.round(lastDataValue * variationMultiplier);
			
			// Calculate new value
			int newValue = lastDataValue + variation;
			
			// Limit new value to configured value bounds
			if (configuration.valueLowerBound != null) {
				newValue = Math.max(newValue, configuration.valueLowerBound);
			}
			if (configuration.valueUpperBound != null) {
				newValue = Math.min(newValue, configuration.valueUpperBound);
			}

			// Update current value
			currentValue = newValue;
			lastDataValue = currentValue;
			
		}
		
		return current();
		
	}

}
