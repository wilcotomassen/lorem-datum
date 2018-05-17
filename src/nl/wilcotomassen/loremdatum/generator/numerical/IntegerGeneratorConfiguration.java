package nl.wilcotomassen.loremdatum.generator.numerical;

/**
 * Generator configuration for the {@link IntegerGenerator} class
 */
public class IntegerGeneratorConfiguration extends NumericalGeneratorConfiguration {

	/**
	 * Initial value to generate values from
	 */
	public final int initiator;
	
	/**
	 * Absolute limits of generated values (inclusive), or null if without
	 * limits  
	 */
	public final Integer valueLowerBound;
	public final Integer valueUpperBound;
	
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

		private int initiator = 100;
		private Integer valueLowerBound = null;
		private Integer valueUpperBound = null;
		
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
			this.valueLowerBound = valueLowerBound;
			return self();
		}
		
		/**
		 * @param valueUpperBound the upper bound of the generated values (inclusive) or null for no upper bound
		 * @return updated Builder
		 */
		public T variationUpperBound(Integer valueUpperBound) {
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
