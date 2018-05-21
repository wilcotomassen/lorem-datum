package nl.wilcotomassen.loremdatum.generator;

public abstract class RandomGeneratorConfiguration extends GeneratorConfiguration {
	
	/**
	 * Integer seed for the random number generator
	 */
	public final int seed;
	public static final int SEED_DEFAULT = 0;
	
	/**
	 * Probability of generating a N/A value [0.0, 1.0f] or
	 * null for disabling N/A values
	 */
	public final Float naProbability;
	
	/**
	 * Instantiate GeneratorConfiguration
	 * 
	 * @param builder
	 */
	protected RandomGeneratorConfiguration(ConfigurationBuilder<?> builder) {
		this.seed = builder.seed;
		this.naProbability = builder.naProbability;
	}
	
	/**
	 * Create a builder for this Configuration
	 * 
	 * @return a builder for this Configuration
	 */
	public static ConfigurationBuilder<?> builder() {
		return new RandomGeneratorConfigurationBuilder();
	}
	
	/**
	 * Abstract ConfigurationBuilder
	 */
	public static abstract class ConfigurationBuilder<T extends ConfigurationBuilder<T>>
			extends GeneratorConfiguration.ConfigurationBuilder<T> {

		private int seed = SEED_DEFAULT;
		private Float naProbability = null;
		
		protected abstract T self();

		/**
		 * @param seed the seed for the random number generator
		 * @return updated Builder
		 */
		public T seed(int seed) {
			this.seed = seed;
			return self();
		}
		
		/**
		 * @param naProbability Probability of generating a N/A value [0.0, 1.0f] or null for disabling N/A values
		 * @return updated Builder
		 */
		public T naProbability(Float naProbability) {
			this.naProbability = naProbability;
			return self();
		}
		
	}
		
	/**
	 * Implementation of the ConfigurationBuilder for this class
	 */
	private static class RandomGeneratorConfigurationBuilder
			extends ConfigurationBuilder<RandomGeneratorConfigurationBuilder> {
		@Override
		protected RandomGeneratorConfigurationBuilder self() {
			return this;
		}
	}
	
}
