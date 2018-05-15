package nl.wilcotomassen.loremdatum.generator;

import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * Generator that contains a random generator, also has the
 * ability to generate NA values
 */
public abstract class RandomGenerator extends Generator {
	
//	protected Random random;
	protected RandomDataGenerator random;
	
	public RandomGenerator(RandomGeneratorConfiguration configuration) {
		super(configuration);
		random = new RandomDataGenerator(new JDKRandomGenerator(configuration.seed));
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
			return random.getRandomGenerator().nextFloat() < config.naProbability;
		}
	}
	
}
