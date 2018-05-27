package nl.wilcotomassen.loremdatum.generator.categorical;

import java.util.HashMap;
import java.util.Map;

import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfiguration;

public class CategoricalGeneratorConfiguration extends RandomGeneratorConfiguration {
	
	/**
	 * Map of items in the category together with their submitted probabilities. The probability
	 * range is not predetermined, but the probability of finding item N is the probability of item N 
	 * over the sum of all item probabilities in the set. 
	 */
	public final Map<Double, Object> items;
	
	/**
	 * Map of items in the category together with their normalized probabilities [0.0, 1.0]. The probability 
	 * of finding item N is the normalized probability of item N over 1.0
	 */
	public final Map<Double, Object> probabilityMap;

	protected CategoricalGeneratorConfiguration(ConfigurationBuilder<?> builder) {
		super(builder);
		items = new HashMap<Double, Object>(builder.items);
		
		// Construct probability map
		double probabilitySum = items.keySet().stream().mapToDouble(Number::doubleValue).sum();
		probabilityMap = new HashMap<Double, Object>();
		for (Map.Entry<Double, Object> entry : items.entrySet()) {
			double normalizedProbability = entry.getKey() / probabilitySum;
			probabilityMap.put(normalizedProbability, entry.getValue());
		}
		
	}
	
	/**
	 * Create a builder for this Configuration
	 * 
	 * @return a builder for this Configuration
	 */
	public static ConfigurationBuilder<?> builder() {
		return new CategoricalGeneratorConfigurationBuilder();
	}
	
	/**
	 * Abstract ConfigurationBuilder
	 */
	public static abstract class ConfigurationBuilder<T extends ConfigurationBuilder<T>>
			extends RandomGeneratorConfiguration.ConfigurationBuilder<T> {

		private Map<Double, Object> items = new HashMap<Double, Object>();

		protected abstract T self();
		
		/**
		 * @param trueProbability Probability of generating a true value [0.0, 1.0f]
		 * @return updated Builder
		 */
		public T addItem(double probability, Object item) {
			items.put(probability, item);
			return self();
		}
		
		/**
		 * Build the configuration
		 * @return
		 */
		public CategoricalGeneratorConfiguration buildConfiguration() {
			return new CategoricalGeneratorConfiguration(this);
		}
		
		/**
		 * Build the generator
		 * @return
		 */
		public CategoricalGenerator build() {
			return new CategoricalGenerator(buildConfiguration());
		}
		
	}
		
	/**
	 * Implementation of the ConfigurationBuilder for this class
	 */
	private static class CategoricalGeneratorConfigurationBuilder
			extends ConfigurationBuilder<CategoricalGeneratorConfigurationBuilder> {
		
		@Override
		protected CategoricalGeneratorConfigurationBuilder self() {
			return this;
		}
		
	}
	

}
