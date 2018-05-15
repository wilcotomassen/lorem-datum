package nl.wilcotomassen.loremdatum.generator;

public abstract class RandomGeneratorConfiguration extends GeneratorConfiguration {
	
	/**
	 * Seed for the random number generator
	 */
	public long seed;
	
	/**
	 * Probability of generating a N/A value [0.0, 1.0f] or
	 * null for disabling N/A values
	 */
	public Float naProbability = null;

}
