package nl.wilcotomassen.loremdatum.generator;

import java.util.Random;

/**
 * Generator that contains a random generator, also has the
 * ability to generate NA values
 */
public abstract class RandomGenerator extends Generator {
	
	protected Random random;
	
	public RandomGenerator(RandomGeneratorConfiguration configuration) {
		super(configuration);
		random = new Random(configuration.seed);
	}
	
	/**
	 * Try to find a N/A value
	 * 
	 * @return true if next value should be N/A
	 */
	protected boolean tryForNA() {
		RandomGeneratorConfiguration config = (RandomGeneratorConfiguration) getConfiguration();
		if (config.naProbability == null) {
			return false;
		} else {
			return random.nextFloat() < config.naProbability;
		}
	}
	
}
