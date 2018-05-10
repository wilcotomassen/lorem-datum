package nl.wilcotomassen.loremdatum.generator.configuration;

import java.util.Calendar;
import java.util.Date;

public class DateGeneratorConfiguration extends GeneratorConfiguration {
	
	public enum IntervalUnit {
		YEAR(Calendar.YEAR),
		MONTH(Calendar.MONTH),
		WEEK(Calendar.WEEK_OF_YEAR),
		DAY(Calendar.DAY_OF_YEAR),
		HOUR(Calendar.HOUR_OF_DAY),
		MINUTE(Calendar.MINUTE),
		SECOND(Calendar.SECOND),
		MILLISECOND(Calendar.MILLISECOND);
	
		private final int calendarUnit;
		
		IntervalUnit(int calendarUnit) {
			this.calendarUnit = calendarUnit;
		}
		
		public int getCalendarUnit() {
			return calendarUnit;
		}

	};
	
	/**
	 * Start date/time of the generated time sequence
	 */
	public Date start = new Date();
	
	/**
	 * Unit of the interval between each generated 
	 * value
	 */
	public IntervalUnit intervalUnit = IntervalUnit.DAY;
	
	/**
	 * How many interval units should be between
	 * each generated value
	 */
	public int intervalValue = 1;

}
