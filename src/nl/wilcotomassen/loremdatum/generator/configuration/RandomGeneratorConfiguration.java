package nl.wilcotomassen.loremdatum.generator.configuration;

public abstract class RandomGeneratorConfiguration extends GeneratorConfiguration {
	
	public long seed;
	
	/**
	 * Probability of generating a N/A value [0.0, 1.0f] or
	 * null for disabling N/A values
	 */
	public Float naProbability = null;

}
