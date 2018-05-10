package nl.wilcotomassen.loremdatum.generator;

import java.util.Calendar;
import java.util.Date;

import nl.wilcotomassen.loremdatum.generator.configuration.DateGeneratorConfiguration;

/**
 * Generator for date (and time) axes
 */
public class DateGenerator extends Generator {
	
	/**
	 * Current state
	 */
	private Calendar calendar;
	
	public DateGenerator(DateGeneratorConfiguration configuration) {
		super(configuration);
		
		// Initialize current state as calendar
		this.calendar = Calendar.getInstance();
		this.calendar.setTime(configuration.start);
		
	}
	
	@Override
	public Date current() {
		return calendar.getTime();
	}
	
	@Override
	public Date next() {
		
		//Get configuration
		DateGeneratorConfiguration configuration = (DateGeneratorConfiguration) getConfiguration();
		
		// Add interval to current date
		calendar.add(configuration.intervalUnit.getCalendarUnit(), configuration.intervalValue);
		
		// Return current date
		return current();
	}
	
}
