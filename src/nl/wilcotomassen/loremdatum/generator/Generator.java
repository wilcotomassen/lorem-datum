package nl.wilcotomassen.loremdatum.generator;

import nl.wilcotomassen.loremdatum.generator.configuration.GeneratorConfiguration;

public abstract class Generator {
	
	private GeneratorConfiguration configuration;
	
	/**
	 * Initialize configuration with a configuration
	 * 
	 * @param configuration
	 */
	public Generator(GeneratorConfiguration configuration) {
		this.configuration = configuration;
	}
	
	/**
	 * Get the configuration
	 * 
	 * @return
	 */
	public GeneratorConfiguration getConfiguration() {
		return configuration;
	}
	
	/**
	 * Get the current value
	 * 
	 * @return
	 */
	public abstract Object current();

	/**
	 * Update the current value
	 * 
	 * @return
	 */
	public abstract Object next();

}
