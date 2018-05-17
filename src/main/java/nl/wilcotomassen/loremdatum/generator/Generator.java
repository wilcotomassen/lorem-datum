package nl.wilcotomassen.loremdatum.generator;

public abstract class Generator {
	
	/**
	 * The configuration for this generator
	 */
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
	public abstract Object getCurrent();

	/**
	 * Update the current value
	 * 
	 * @return
	 */
	public abstract Object getNext();

}
