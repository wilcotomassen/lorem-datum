package nl.wilcotomassen.loremdatum.generator.numerical;

/**
 * Generator configuration for the {@link LongGenerator} class
 */
public class LongGeneratorConfiguration extends NumericalGeneratorConfiguration {
	
	/**
	 * Initial value to generate values from
	 */
	public final long initiator;
	
	/**
	 * Absolute limits of generated values (inclusive), or null 
	 * if without limits 
	 */
	public final Long valueLowerBound;
	public final Long valueUpperBound;
	
	/**
	 * Instantiate GeneratorConfiguration
	 * 
	 * @param builder
	 */
	protected LongGeneratorConfiguration(ConfigurationBuilder<?> builder) {
		super(builder);
		this.initiator = builder.initiator;
		this.valueLowerBound = builder.valueLowerBound;
		this.valueUpperBound = builder.valueUpperBound;
	}
	
	/**
	 * Create a builder for this Configuration
	 * 
	 * @return a builder for this Configuration
	 */
	public static ConfigurationBuilder<?> builder() {
		return new LongGeneratorConfigurationBuilder();
	}
	
	/**
	 * Abstract ConfigurationBuilder
	 */
	public static abstract class ConfigurationBuilder<T extends ConfigurationBuilder<T>>
			extends NumericalGeneratorConfiguration.ConfigurationBuilder<T> {

		private long initiator = 100;
		private Long valueLowerBound = null;
		private Long valueUpperBound = null;
		
		protected abstract T self();
		
		/**
		 * @param valueLowerBound the initial value to generate values from
		 * @return updated Builder
		 */
		public T initiator(long initiator) {
			this.initiator = initiator;
			return self();
		}

		/**
		 * @param valueLowerBound the lower bound of the generated values (inclusive) or null for no lower bound
		 * @return updated Builder
		 */
		public T valueLowerBound(Long valueLowerBound) {
			this.valueLowerBound = valueLowerBound;
			return self();
		}
		
		/**
		 * @param valueUpperBound the upper bound of the generated values (inclusive) or null for no upper bound
		 * @return updated Builder
		 */
		public T variationUpperBound(Long valueUpperBound) {
			this.valueUpperBound = valueUpperBound;
			return self();
		}
		
		/**
		 * Build the configuration
		 * @return
		 */
		public LongGeneratorConfiguration buildConfiguration() {
			return new LongGeneratorConfiguration(this);
		}
		
		/**
		 * Build the generator
		 * @return
		 */
		public LongGenerator build() {
			return new LongGenerator(buildConfiguration());
		}
		
	}
		
	/**
	 * Implementation of the ConfigurationBuilder for this class
	 */
	private static class LongGeneratorConfigurationBuilder
			extends ConfigurationBuilder<LongGeneratorConfigurationBuilder> {
		
		@Override
		protected LongGeneratorConfigurationBuilder self() {
			return this;
		}
		
	}
	
}
