package nl.wilcotomassen.loremdatum.generator.numerical;


/**
 * Generator configuration for the {@link FloatGenerator} class
 */
public class FloatGeneratorConfiguration extends NumericalGeneratorConfiguration {

	/**
	 * Initial value to generate values from
	 */
	public final float initiator;
	public static final float INITIATOR_DEFAULT = 100f; 
	
	/**
	 * Absolute lower limit of generated value (inclusive), or null 
	 * if without limits 
	 */
	public final Float valueLowerBound;
	public static final Float VALUE_LOWER_BOUND_DEFAULT = null;
	
	/**
	 * Absolute upper limit of generated value (inclusive), or null 
	 * if without limits 
	 */
	public final Float valueUpperBound;
	public static final Float VALUE_UPPER_BOUND_DEFAULT = null;
	
	/**
	 * Instantiate GeneratorConfiguration
	 * 
	 * @param builder
	 */
	protected FloatGeneratorConfiguration(ConfigurationBuilder<?> builder) {
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
		return new FloatGeneratorConfigurationBuilder();
	}
	
	/**
	 * Abstract ConfigurationBuilder
	 */
	public static abstract class ConfigurationBuilder<T extends ConfigurationBuilder<T>>
			extends NumericalGeneratorConfiguration.ConfigurationBuilder<T> {
		
		private float initiator = INITIATOR_DEFAULT;
		private Float valueLowerBound = VALUE_LOWER_BOUND_DEFAULT;
		private Float valueUpperBound = VALUE_UPPER_BOUND_DEFAULT;
		
		protected abstract T self();
		
		/**
		 * @param valueLowerBound the initial value to generate values from
		 * @return updated Builder
		 */
		public T initiator(float initiator) {
			this.initiator = initiator;
			return self();
		}

		/**
		 * @param valueLowerBound the lower bound of the generated values (inclusive) or null for no lower bound
		 * @return updated Builder
		 */
		public T valueLowerBound(Float valueLowerBound) {
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
		public T valueUpperBound(Float valueUpperBound) {
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
		public FloatGeneratorConfiguration buildConfiguration() {
			return new FloatGeneratorConfiguration(this);
		}
		
		/**
		 * Build the generator
		 * @return
		 */
		public FloatGenerator build() {
			return new FloatGenerator(buildConfiguration());
		}
		
	}
		
	/**
	 * Implementation of the ConfigurationBuilder for this class
	 */
	private static class FloatGeneratorConfigurationBuilder
			extends ConfigurationBuilder<FloatGeneratorConfigurationBuilder> {
		@Override
		protected FloatGeneratorConfigurationBuilder self() {
			return this;
		}
	}

}