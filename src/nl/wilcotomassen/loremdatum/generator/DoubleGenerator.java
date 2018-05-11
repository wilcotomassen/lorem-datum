package nl.wilcotomassen.loremdatum.generator;

import nl.wilcotomassen.loremdatum.generator.configuration.DoubleGeneratorConfiguration;

public class DoubleGenerator extends RandomGenerator {
	
	private Double currentValue;
	
	private double lastDataValue;

	public DoubleGenerator(DoubleGeneratorConfiguration configuration) {
		super(configuration);
		currentValue = configuration.initiator;
		lastDataValue = currentValue;
	}
	
	@Override
	public Double current() {
		return currentValue;
	}

	@Override
	public Double next() {
		
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
		
		return current();
		
	}

}
