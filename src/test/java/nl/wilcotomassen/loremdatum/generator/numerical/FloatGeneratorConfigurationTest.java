package nl.wilcotomassen.loremdatum.generator.numerical;

import org.testng.annotations.Test;

public class FloatGeneratorConfigurationTest extends NumericalGeneratorConfigurationTest {
	
	@Override
	protected NumericalGeneratorConfiguration getConfiguration(
			Integer seed, 
			Float naProbability, 
			Double variationLowerBound,
			Double variationUpperBound) {
		
		FloatGeneratorConfiguration.ConfigurationBuilder<?> configurationBuilder = 
				FloatGeneratorConfiguration.builder();
		
		if (seed != null) {
			configurationBuilder.seed(seed);
		}
		if (naProbability != null) {
			configurationBuilder.naProbability(naProbability);
		}
		if (variationLowerBound != null) {
			configurationBuilder.variationLowerBound(variationLowerBound);
		}
		if (variationUpperBound != null) {
			configurationBuilder.variationUpperBound(variationUpperBound);
		}
		
		return configurationBuilder.buildConfiguration();
		
	}

}
