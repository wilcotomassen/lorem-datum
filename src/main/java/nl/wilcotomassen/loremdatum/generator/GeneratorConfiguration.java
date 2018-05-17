package nl.wilcotomassen.loremdatum.generator;

public abstract class GeneratorConfiguration {
	
	/**
	 * Create a builder for this Configuration
	 * @return a builder for this Configuration
	 */
	public static ConfigurationBuilder<?> builder() {
		return new GeneratorConfigurationBuilder();
	}
	
	/**
	 * Abstract ConfigurationBuilder
	 */
	public static abstract class ConfigurationBuilder<T extends ConfigurationBuilder<T>> {
		protected abstract T self();
	}

	/**
	 * Implementation of the ConfigurationBuilder for this
	 * class
	 */
	private static class GeneratorConfigurationBuilder extends ConfigurationBuilder<GeneratorConfigurationBuilder> {
		@Override
		protected GeneratorConfigurationBuilder self() {
			return this;
		}
	}
	
}
