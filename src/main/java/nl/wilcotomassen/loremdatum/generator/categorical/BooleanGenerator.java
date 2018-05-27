package nl.wilcotomassen.loremdatum.generator.categorical;

import nl.wilcotomassen.loremdatum.generator.RandomGenerator;
import nl.wilcotomassen.loremdatum.generator.categorical.BooleanGeneratorConfiguration.ConfigurationBuilder;

public class BooleanGenerator extends RandomGenerator {
	
	/**
	 * The last generated value
	 */
	private Boolean currentValue;
	
	public BooleanGenerator(BooleanGeneratorConfiguration configuration) {
		super(configuration);
	}
	
	@Override
	public Boolean getCurrent() {
		return currentValue; 
	}

	@Override
	public Boolean getNext() {
		
		// Check if we should generate a N/A value
		if (tryForNA()) {
			currentValue = null;
		} else {
		
			// Retrieve configuration
			BooleanGeneratorConfiguration configuration = 
					(BooleanGeneratorConfiguration) getConfiguration();

			// Update current and last data value
			currentValue = (random.nextUniform(0, 1) < configuration.trueProbability);
			
		}
		
		return getCurrent();
		
	}
	
	/**
	 * Get a configuration builder for this generator
	 * 
	 * @return a configuration builder for this generator
	 */
	public static ConfigurationBuilder<?> builder() {
		return BooleanGeneratorConfiguration.builder();
	}

}
