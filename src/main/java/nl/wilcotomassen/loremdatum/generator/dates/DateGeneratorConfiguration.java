package nl.wilcotomassen.loremdatum.generator.dates;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import nl.wilcotomassen.loremdatum.generator.GeneratorConfiguration;

public class DateGeneratorConfiguration extends GeneratorConfiguration {
	
	public enum IntervalUnit {
		YEAR(ChronoUnit.YEARS),
		MONTH(ChronoUnit.MONTHS),
		WEEK(ChronoUnit.WEEKS),
		DAY(ChronoUnit.DAYS),
		HOUR(ChronoUnit.HOURS),
		MINUTE(ChronoUnit.MINUTES),
		SECOND(ChronoUnit.SECONDS),
		MILLISECOND(ChronoUnit.MILLIS);
	
		private final ChronoUnit chronoUnit;
		
		IntervalUnit(ChronoUnit chronoUnit) {
			this.chronoUnit = chronoUnit;
		}
		
		public ChronoUnit getCalendarUnit() {
			return chronoUnit;
		}

	};
	
	/**
	 * Start date/time of the generated time sequence
	 */
	public final LocalDateTime start;
	
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

		private LocalDateTime start = LocalDateTime.now();
		private IntervalUnit intervalUnit = IntervalUnit.DAY;
		private int intervalValue = 1;
		
		protected abstract T self();
		
		/**
		 * @param valueLowerBound the start date/time of the generated time sequence
		 * @return updated Builder
		 */
		public T start(LocalDateTime start) {
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
