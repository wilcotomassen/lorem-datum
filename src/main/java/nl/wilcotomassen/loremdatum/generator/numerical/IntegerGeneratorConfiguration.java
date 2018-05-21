package nl.wilcotomassen.loremdatum.generator.numerical;

/**
 * Generator configuration for the {@link IntegerGenerator} class
 */
public class IntegerGeneratorConfiguration extends NumericalGeneratorConfiguration {

	/**
	 * Initial value to generate values from
	 */
	public final int initiator;
	public static final int INITIATOR_DEFAULT = 100; 
	
	/**
	 * Absolute lower limit of generated value (inclusive), or null 
	 * if without limits 
	 */
	public final Integer valueLowerBound;
	public static final Integer VALUE_LOWER_BOUND_DEFAULT = null;
	
	/**
	 * Absolute upper limit of generated value (inclusive), or null 
	 * if without limits 
	 */
	public final Integer valueUpperBound;
	public static final Integer VALUE_UPPER_BOUND_DEFAULT = null;
	
	/**
	 * Instantiate GeneratorConfiguration
	 * 
	 * @param builder
	 */
	protected IntegerGeneratorConfiguration(ConfigurationBuilder<?> builder) {
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
		return new IntegerGeneratorConfigurationBuilder();
	}
	
	/**
	 * Abstract ConfigurationBuilder
	 */
	public static abstract class ConfigurationBuilder<T extends ConfigurationBuilder<T>>
			extends NumericalGeneratorConfiguration.ConfigurationBuilder<T> {

		private int initiator = INITIATOR_DEFAULT;
		private Integer valueLowerBound = VALUE_LOWER_BOUND_DEFAULT;
		private Integer valueUpperBound = VALUE_UPPER_BOUND_DEFAULT;
		
		protected abstract T self();
		
		/**
		 * @param valueLowerBound the initial value to generate values from
		 * @return updated Builder
		 */
		public T initiator(int initiator) {
			this.initiator = initiator;
			return self();
		}

		/**
		 * @param valueLowerBound the lower bound of the generated values (inclusive) or null for no lower bound
		 * @return updated Builder
		 */
		public T valueLowerBound(Integer valueLowerBound) {
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
		public T valueUpperBound(Integer valueUpperBound) {
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
		public IntegerGeneratorConfiguration buildConfiguration() {
			return new IntegerGeneratorConfiguration(this);
		}
		
		/**
		 * Build the generator
		 * @return
		 */
		public IntegerGenerator build() {
			return new IntegerGenerator(buildConfiguration());
		}
		
	}
		
	/**
	 * Implementation of the ConfigurationBuilder for this class
	 */
	private static class IntegerGeneratorConfigurationBuilder
			extends ConfigurationBuilder<IntegerGeneratorConfigurationBuilder> {
		
		@Override
		protected IntegerGeneratorConfigurationBuilder self() {
			return this;
		}
		
	}
	
}
