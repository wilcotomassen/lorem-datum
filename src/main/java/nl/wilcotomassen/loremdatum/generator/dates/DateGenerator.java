package nl.wilcotomassen.loremdatum.generator.dates;

import java.time.LocalDateTime;

import nl.wilcotomassen.loremdatum.generator.Generator;
import nl.wilcotomassen.loremdatum.generator.dates.DateGeneratorConfiguration.ConfigurationBuilder;

/**
 * Generator for date (and time) axes
 */
public class DateGenerator extends Generator {
	
	/**
	 * Current date/time
	 */
	private LocalDateTime currentDate;
	
	public DateGenerator(DateGeneratorConfiguration configuration) {
		super(configuration);
		
		currentDate = configuration.start;
		
	}
	
	@Override
	public LocalDateTime getCurrent() {
		return currentDate;
	}
	
	@Override
	public LocalDateTime getNext() {
		
		//Get configuration
		DateGeneratorConfiguration configuration = (DateGeneratorConfiguration) getConfiguration();
		
		// Add interval to current date
		currentDate = currentDate.plus(configuration.intervalValue, configuration.intervalUnit.getCalendarUnit());
		
		// Return current date
		return getCurrent();
	}
	
	/**
	 * Get a configuration builder for this generator
	 * 
	 * @return a configuration builder for this generator
	 */
	public static ConfigurationBuilder<?> builder() {
		return DateGeneratorConfiguration.builder();
	}
	
}
