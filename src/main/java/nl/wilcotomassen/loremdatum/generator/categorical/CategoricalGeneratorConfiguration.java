package nl.wilcotomassen.loremdatum.generator.categorical;

import java.util.ArrayList;

import nl.wilcotomassen.loremdatum.generator.RandomGeneratorConfiguration;

public class CategoricalGeneratorConfiguration extends RandomGeneratorConfiguration {
	
	/**
	 * Map of items in the category together with their submitted probabilities. The probability
	 * range is not predetermined, but the probability of finding item N is the probability of item N 
	 * over the sum of all item probabilities in the set. 
	 */
	public final ArrayList<Item> items;
	
	/**
	 * Map of items in the category together with their normalized probabilities [0.0, 1.0]. The probability 
	 * of finding item N is the normalized probability of item N over 1.0
	 */
	public final ArrayList<Item> probabilityMap;
	
	protected CategoricalGeneratorConfiguration(ConfigurationBuilder<?> builder) {
		super(builder);
		items = new ArrayList<Item>(builder.items);
		
		// Construct probability map
		double probabilitySum = items.stream().mapToDouble(Item::getProbability).sum();
		probabilityMap = new ArrayList<Item>();
		for (Item item: items) {
			double normalizedProbability = item.getProbability() / probabilitySum;
			probabilityMap.add(new Item(normalizedProbability, item.getValue()));
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

		private ArrayList<Item> items = new ArrayList<Item>();

		protected abstract T self();
		
		/**
		 * @param trueProbability Probability of generating a true value [0.0, 1.0f]
		 * @return updated Builder
		 */
		public T addItem(double probability, Object value) {
			items.add(new Item(probability, value));
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
	
	/**
	 * Small class that pairs an Object with a probability
	 */
	public static class Item {
		
		private double probability;
		private Object value;
		
		public Item(double probability, Object item) {
			this.probability = probability;
			this.value = item;
		}

		public double getProbability() {
			return probability;
		}

		public Object getValue() {
			return value;
		}
		
	}

}
