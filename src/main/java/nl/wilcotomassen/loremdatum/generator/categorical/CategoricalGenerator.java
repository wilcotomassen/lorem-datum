package nl.wilcotomassen.loremdatum.generator.categorical;

import nl.wilcotomassen.loremdatum.generator.RandomGenerator;
import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfiguration;
import nl.wilcotomassen.loremdatum.generator.categorical.CategoricalGeneratorConfiguration.ConfigurationBuilder;
import nl.wilcotomassen.loremdatum.generator.categorical.CategoricalGeneratorConfiguration.Item;

public class CategoricalGenerator extends RandomGenerator {
	
	private Object currentValue;
	
	public CategoricalGenerator(RandomGeneratorConfiguration configuration) {
		super(configuration);
		currentValue = null;
	}

	@Override
	public Object getCurrent() {
		return currentValue;
	}

	@Override
	public Object getNext() {
		
		// Check if we should generate a N/A value
		if (tryForNA()) {
			currentValue = null;
		} else {
		
			// Retrieve configuration
			CategoricalGeneratorConfiguration configuration = 
					(CategoricalGeneratorConfiguration) getConfiguration();
			
			// Find item in probability
			double generatedProbability = random.nextUniform(0, 1);
			double itemProbability = 0;
			for (Item item: configuration.probabilityMap) {
				itemProbability += item.getProbability();
				if (generatedProbability < itemProbability) {
					currentValue = item.getValue();
					break;
				}
			}

		}
		
		return getCurrent();
	}
	
	/**
	 * Get a configuration builder for this generator
	 * 
	 * @return a configuration builder for this generator
	 */
	public static ConfigurationBuilder<?> builder() {
		return CategoricalGeneratorConfiguration.builder();
	}

}
