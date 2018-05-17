package nl.wilcotomassen.loremdatum.generator.numerical;

/**
 * Generator configuration for the {@link DoubleGenerator} class
 */
public class DoubleGeneratorConfiguration extends NumericalGeneratorConfiguration {

	/**
	 * Initial value to generate values from
	 */
	public final double initiator;
	
	/**
	 * Absolute limits of generated values (inclusive), or null 
	 * if without limits 
	 */
	public final Double valueLowerBound;
	public final Double valueUpperBound;
	
	/**
	 * Instantiate GeneratorConfiguration
	 * 
	 * @param builder
	 */
	protected DoubleGeneratorConfiguration(ConfigurationBuilder<?> builder) {
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
		return new DoubleGeneratorConfigurationBuilder();
	}
	
	/**
	 * Abstract ConfigurationBuilder
	 */
	public static abstract class ConfigurationBuilder<T extends ConfigurationBuilder<T>>
			extends NumericalGeneratorConfiguration.ConfigurationBuilder<T> {

		private double initiator = 100;
		private Double valueLowerBound = null;
		private Double valueUpperBound = null;
		
		protected abstract T self();
		
		/**
		 * @param valueLowerBound the initial value to generate values from
		 * @return updated Builder
		 */
		public T initiator(double initiator) {
			this.initiator = initiator;
			return self();
		}

		/**
		 * @param valueLowerBound the lower bound of the generated values (inclusive) or null for no lower bound
		 * @return updated Builder
		 */
		public T valueLowerBound(Double valueLowerBound) {
			this.valueLowerBound = valueLowerBound;
			return self();
		}
		
		/**
		 * @param valueUpperBound the upper bound of the generated values (inclusive) or null for no upper bound
		 * @return updated Builder
		 */
		public T variationUpperBound(Double valueUpperBound) {
			this.valueUpperBound = valueUpperBound;
			return self();
		}
		
		/**
		 * Build the configuration
		 * @return
		 */
		public DoubleGeneratorConfiguration buildConfiguration() {
			return new DoubleGeneratorConfiguration(this);
		}
		
		/**
		 * Build the generator
		 * @return
		 */
		public DoubleGenerator build() {
			return new DoubleGenerator(buildConfiguration());
		}
		
	}
		
	/**
	 * Implementation of the ConfigurationBuilder for this class
	 */
	private static class DoubleGeneratorConfigurationBuilder
			extends ConfigurationBuilder<DoubleGeneratorConfigurationBuilder> {
		@Override
		protected DoubleGeneratorConfigurationBuilder self() {
			return this;
		}
	}

}
