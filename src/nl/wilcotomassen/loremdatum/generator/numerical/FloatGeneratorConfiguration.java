package nl.wilcotomassen.loremdatum.generator.numerical;


/**
 * Generator configuration for the {@link FloatGenerator} class
 */
public class FloatGeneratorConfiguration extends NumericalGeneratorConfiguration {

	/**
	 * Initial value to generate values from
	 */
	public final float initiator;
	
	/**
	 * Absolute limits of generated values (inclusive), or null 
	 * if without limits 
	 */
	public final Float valueLowerBound;
	public final Float valueUpperBound;
	
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

		private float initiator = 100;
		private Float valueLowerBound = null;
		private Float valueUpperBound = null;
		
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
			this.valueLowerBound = valueLowerBound;
			return self();
		}
		
		/**
		 * @param valueUpperBound the upper bound of the generated values (inclusive) or null for no upper bound
		 * @return updated Builder
		 */
		public T variationUpperBound(Float valueUpperBound) {
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