package nl.wilcotomassen.loremdatum.generator.dates;

import java.util.Calendar;
import java.util.Date;

import nl.wilcotomassen.loremdatum.generator.Generator;

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
	public Date getCurrent() {
		return calendar.getTime();
	}
	
	@Override
	public Date getNext() {
		
		//Get configuration
		DateGeneratorConfiguration configuration = (DateGeneratorConfiguration) getConfiguration();
		
		// Add interval to current date
		calendar.add(configuration.intervalUnit.getCalendarUnit(), configuration.intervalValue);
		
		// Return current date
		return getCurrent();
	}
	
}
