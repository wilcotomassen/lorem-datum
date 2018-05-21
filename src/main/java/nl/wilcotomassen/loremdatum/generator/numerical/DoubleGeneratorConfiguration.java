package nl.wilcotomassen.loremdatum.generator.numerical;

/**
 * Generator configuration for the {@link DoubleGenerator} class
 */
public class DoubleGeneratorConfiguration extends NumericalGeneratorConfiguration {

	/**
	 * Initial value to generate values from
	 */
	public final double initiator;
	public static final float INITIATOR_DEFAULT = 100; 
	
	/**
	 * Absolute lower limit of generated value (inclusive), or null 
	 * if without limits 
	 */
	public final Double valueLowerBound;
	public static final Double VALUE_LOWER_BOUND_DEFAULT = null;
	
	/**
	 * Absolute upper limit of generated value (inclusive), or null 
	 * if without limits 
	 */
	public final Double valueUpperBound;
	public static final Double VALUE_UPPER_BOUND_DEFAULT = null;
	
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

		private double initiator = INITIATOR_DEFAULT;
		private Double valueLowerBound = VALUE_LOWER_BOUND_DEFAULT;
		private Double valueUpperBound = VALUE_UPPER_BOUND_DEFAULT;
		
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
			if (valueLowerBound != null && valueUpperBound != null && valueLowerBound >= valueUpperBound) {
				throw new IllegalArgumentException("Value lower bound should be smaller than value upper bound");
			}
			this.valueLowerBound = valueLowerBound;
			return self();
		}
		
		/**
		 * @param valueUpperBound the upper bound of the generated values (inclusive) or null for no upper bound
		 * @return updated Builder
		 */
		public T valueUpperBound(Double valueUpperBound) {
			if (valueLowerBound != null && valueUpperBound != null && valueUpperBound <= valueLowerBound) {
				throw new IllegalArgumentException("Value upper bound should be greater than value lower bound");
			}
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
