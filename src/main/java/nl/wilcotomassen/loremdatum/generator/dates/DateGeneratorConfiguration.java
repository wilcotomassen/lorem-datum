package nl.wilcotomassen.loremdatum.generator.dates;

import java.util.Calendar;
import java.util.Date;

import nl.wilcotomassen.loremdatum.generator.GeneratorConfiguration;

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
	public final Date start;
	
	/**
	 * Unit of the interval between each generated 
	 * value
	 */
	public final IntervalUnit intervalUnit;
	
	/**
	 * How many interval units should be between
	 * each generated value (should always be one or more)
	 */
	public final int intervalValue;
	
	/**
	 * Instantiate GeneratorConfiguration
	 * 
	 * @param builder
	 */
	protected DateGeneratorConfiguration(ConfigurationBuilder<?> builder) {
		this.start = builder.start;
		this.intervalUnit = builder.intervalUnit;
		this.intervalValue = builder.intervalValue;
	}
	
	/**
	 * Create a builder for this Configuration
	 * 
	 * @return a builder for this Configuration
	 */
	public static ConfigurationBuilder<?> builder() {
		return new DateGeneratorConfigurationBuilder();
	}
	
	/**
	 * Abstract ConfigurationBuilder
	 */
	public static abstract class ConfigurationBuilder<T extends ConfigurationBuilder<T>>
			extends GeneratorConfiguration.ConfigurationBuilder<T> {

		private Date start = new Date();
		private IntervalUnit intervalUnit = IntervalUnit.DAY;
		private int intervalValue = 1;
		
		protected abstract T self();
		
		/**
		 * @param valueLowerBound the start date/time of the generated time sequence
		 * @return updated Builder
		 */
		public T start(Date start) {
			this.start = start;
			return self();
		}

		/**
		 * @param valueLowerBound the unit of interval between each generated value
		 * @return updated Builder
		 */
		public T intervalUnit(IntervalUnit intervalUnit) {
			this.intervalUnit = intervalUnit;
			return self();
		}
		
		/**
		 * @param testValue how many interval units should be between each generated value (1 or higher)
		 * @return updated Builder
		 */
		public T intervalValue(int testValue) {
			
			if (testValue <= 0) {
				throw new IllegalArgumentException("Interval value should be greater than zero");
			}
			
			this.intervalValue = testValue;
			return self();
		}
		
		/**
		 * Build the configuration
		 * @return
		 */
		public DateGeneratorConfiguration buildConfiguration() {
			return new DateGeneratorConfiguration(this);
		}
		
		/**
		 * Build the generator
		 * @return
		 */
		public DateGenerator build() {
			return new DateGenerator(buildConfiguration());
		}
		
	}
		
	/**
	 * Implementation of the ConfigurationBuilder for this class
	 */
	private static class DateGeneratorConfigurationBuilder
			extends ConfigurationBuilder<DateGeneratorConfigurationBuilder> {
		
		@Override
		protected DateGeneratorConfigurationBuilder self() {
			return this;
		}
		
	}
	
}
