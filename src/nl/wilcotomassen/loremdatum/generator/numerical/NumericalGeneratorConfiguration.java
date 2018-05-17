package nl.wilcotomassen.loremdatum.generator.numerical;

import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfiguration;

public abstract class NumericalGeneratorConfiguration extends RandomGeneratorConfiguration {
	
	/**
	 * The lower bound for the variation of the generated
	 * values relative to the last generator value in double
	 * precision. Range is [-1.0, 0.0]
	 */
	public final double variationLowerBound;
	
	/**
	 * The upper bound for the variation of the generated
	 * values relative to the last generator value in double
	 * precision. Range is [0.0, 1.0]
	 */
	public final double variationUpperBound;
	
	/**
	 * Instantiate GeneratorConfiguration
	 * 
	 * @param builder
	 */
	protected NumericalGeneratorConfiguration(ConfigurationBuilder<?> builder) {
		super(builder);
		this.variationLowerBound = builder.variationLowerBound;
		this.variationUpperBound = builder.variationUpperBound;
	}
	
	/**
	 * Create a builder for this Configuration
	 * 
	 * @return a builder for this Configuration
	 */
	public static ConfigurationBuilder<?> builder() {
		return new NumericalGeneratorConfigurationBuilder();
	}
	
	/**
	 * Abstract ConfigurationBuilder
	 */
	public static abstract class ConfigurationBuilder<T extends ConfigurationBuilder<T>>
			extends RandomGeneratorConfiguration.ConfigurationBuilder<T> {

		private double variationLowerBound = -.1;
		private double variationUpperBound = +.1;
		
		protected abstract T self();

		/**
		 * @param variationLowerBound the lower bound of the value generation variation [-1.0, 0.0]
		 * @return updated Builder
		 */
		public T variationLowerBound(double variationLowerBound) {
			this.variationLowerBound = variationLowerBound;
			return self();
		}
		
		/**
		 * @param variationUpperBound the upper bound of the value generation variation [0.0, 1.0]
		 * @return updated Builder
		 */
		public T variationUpperBound(double variationUpperBound) {
			this.variationUpperBound = variationUpperBound;
			return self();
		}
		
	}
		
	/**
	 * Implementation of the ConfigurationBuilder for this class
	 */
	private static class NumericalGeneratorConfigurationBuilder
			extends ConfigurationBuilder<NumericalGeneratorConfigurationBuilder> {
		@Override
		protected NumericalGeneratorConfigurationBuilder self() {
			return this;
		}
	}
	
}
