package nl.wilcotomassen.loremdatum.generator;

import java.util.Random;

import nl.wilcotomassen.loremdatum.generator.configuration.RandomGeneratorConfiguration;

public abstract class RandomGenerator extends Generator {
	
	protected Random random;
	
	public RandomGenerator(RandomGeneratorConfiguration configuration) {
		super(configuration);
		random = new Random(configuration.seed);
	}
	
}
