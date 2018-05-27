package nl.wilcotomassen.loremdatum.generator.categorical;

import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfiguration;

public class BooleanGeneratorConfiguration extends RandomGeneratorConfiguration {
	
	/**
	 * Probability of generating a true value [0.0, 1.0f]
	 */
	public final float trueProbability;
	public static final float TRUE_PROBABILITY_DEFAULT = 0.5f;
	
	/**
	 * Instantiate BooleanConfiguration
	 * 
	 * @param builder
	 */
	protected BooleanGeneratorConfiguration(ConfigurationBuilder<?> builder) {
		super(builder);
		this.trueProbability = builder.trueProbability;
	}
	
	/**
	 * Create a builder for this Configuration
	 * 
	 * @return a builder for this Configuration
	 */
	public static ConfigurationBuilder<?> builder() {
		return new BooleanGeneratorConfigurationBuilder();
	}
	
	/**
	 * Abstract ConfigurationBuilder
	 */
	public static abstract class ConfigurationBuilder<T extends ConfigurationBuilder<T>>
			extends RandomGeneratorConfiguration.ConfigurationBuilder<T> {

		private float trueProbability = TRUE_PROBABILITY_DEFAULT;
		
		protected abstract T self();
		
		/**
		 * @param trueProbability Probability of generating a true value [0.0, 1.0f]
		 * @return updated Builder
		 */
		public T trueProbability(float trueProbability) {
			if (trueProbability < 0.0f || trueProbability > 1.0f) {
				throw new IllegalArgumentException(String.format("Invalid trueProbability value: '%g'. Valid values are the range [0.0, 1.0] or null", trueProbability));
			}
			this.trueProbability = trueProbability;
			return self();
		}
		
		/**
		 * Build the configuration
		 * @return
		 */
		public BooleanGeneratorConfiguration buildConfiguration() {
			return new BooleanGeneratorConfiguration(this);
		}
		
		/**
		 * Build the generator
		 * @return
		 */
		public BooleanGenerator build() {
			return new BooleanGenerator(buildConfiguration());
		}
		
	}
		
	/**
	 * Implementation of the ConfigurationBuilder for this class
	 */
	private static class BooleanGeneratorConfigurationBuilder
			extends ConfigurationBuilder<BooleanGeneratorConfigurationBuilder> {
		
		@Override
		protected BooleanGeneratorConfigurationBuilder self() {
			return this;
		}
		
	}
	
}
