package nl.wilcotomassen.loremdatum.generator.dates;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import nl.wilcotomassen.loremdatum.generator.dates.DateGeneratorConfiguration.IntervalUnit;

public class DateGeneratorConfigurationTest {
	
	/**
	 * How many ms two date objects can be maximally apart to be considered
	 * equal
	 */
	public final static long TEST_DELTA_DATE_MS = 10;
	
	@Test
	public final void testStartDefaultValue() {
		DateGeneratorConfiguration configuration = DateGeneratorConfiguration.builder().buildConfiguration();
		assertEqualLocalDateTime(configuration.start, LocalDateTime.now());
	}
	
	@Test 
	public final void testStartSetter() {
		
		final LocalDateTime[] TEST_VALUES = {
				LocalDateTime.now(),
				LocalDateTime.of(0, 1, 1, 0, 0),
				LocalDateTime.of(2000, 1, 1, 0, 0),
				LocalDateTime.of(2018, 5, 18, 20, 57, 13),
				LocalDateTime.of(2093, 12, 18, 0, 0)
			};
		
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final LocalDateTime testValue = TEST_VALUES[i];
			
			DateGeneratorConfiguration configuration = DateGeneratorConfiguration.builder()
					.start(testValue)
					.buildConfiguration();
			
			Assert.assertEquals(configuration.start, testValue);
			
		}
	}
	
	@Test
	public final void testIntervalUnitDefaultValue() {
		DateGeneratorConfiguration configuration = DateGeneratorConfiguration.builder().buildConfiguration();
		Assert.assertEquals(configuration.intervalUnit, IntervalUnit.DAY);
	}
	
	@Test
	public final void testIntervalUnitSetter() {
		
		final DateGeneratorConfiguration.IntervalUnit[] TEST_VALUES = {
				IntervalUnit.YEAR,
				IntervalUnit.MONTH,
				IntervalUnit.WEEK,
				IntervalUnit.DAY,
				IntervalUnit.HOUR,
				IntervalUnit.MINUTE,
				IntervalUnit.SECOND,
				IntervalUnit.MILLISECOND
			};
		
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final DateGeneratorConfiguration.IntervalUnit testValue = TEST_VALUES[i];
			
			DateGeneratorConfiguration configuration = DateGeneratorConfiguration.builder()
					.intervalUnit(testValue)
					.buildConfiguration();
			
			Assert.assertEquals(configuration.intervalUnit, testValue);
			
		}
		
	}
	
	@Test
	public final void testIntervalValueDefaultValue() {
		DateGeneratorConfiguration configuration = DateGeneratorConfiguration.builder().buildConfiguration();
		Assert.assertEquals(configuration.intervalValue, 1);
	}
	
	@Test
	public final void testIntervalValueSetterWithValidValues() {
		
		final int[] TEST_VALUES = { 1, 2, 3, 15, Integer.MAX_VALUE };
		
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final int testValue = TEST_VALUES[i];
			
			DateGeneratorConfiguration configuration = DateGeneratorConfiguration.builder()
					.intervalValue(testValue)
					.buildConfiguration();
			
			Assert.assertEquals(configuration.intervalValue, testValue);
			
		}
		
	}
	
	@Test
	public final void testIntervalValueSetterWithInvalidValues() {
		
		final int[] TEST_VALUES = { Integer.MIN_VALUE, -200, -1, 0 };
		
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final int testValue = TEST_VALUES[i];
			
			Assert.assertThrows(IllegalArgumentException.class, () -> DateGeneratorConfiguration.builder()
					.intervalValue(testValue)
					.buildConfiguration());
			
		}
		
	}
	
	@Test
	public final void testBuilder() {
		Assert.assertNotNull(DateGeneratorConfiguration.builder());
	}
	
	@Test
	public final void testBuild() {
		DateGenerator generator = DateGeneratorConfiguration.builder()
				.build();
		Assert.assertNotNull(generator);
		Assert.assertTrue(generator.getClass() == DateGenerator.class);
	}
	
	@Test
	public final void testIntervalUnits() {
		Assert.assertEquals(IntervalUnit.YEAR.getCalendarUnit(), ChronoUnit.YEARS);
		Assert.assertEquals(IntervalUnit.MONTH.getCalendarUnit(), ChronoUnit.MONTHS);
		Assert.assertEquals(IntervalUnit.WEEK.getCalendarUnit(), ChronoUnit.WEEKS);
		Assert.assertEquals(IntervalUnit.DAY.getCalendarUnit(), ChronoUnit.DAYS);
		Assert.assertEquals(IntervalUnit.HOUR.getCalendarUnit(), ChronoUnit.HOURS);
		Assert.assertEquals(IntervalUnit.MINUTE.getCalendarUnit(), ChronoUnit.MINUTES);
		Assert.assertEquals(IntervalUnit.SECOND.getCalendarUnit(), ChronoUnit.SECONDS);
		Assert.assertEquals(IntervalUnit.MILLISECOND.getCalendarUnit(), ChronoUnit.MILLIS);
	}
	
	private final void assertEqualLocalDateTime(LocalDateTime a, LocalDateTime b) {
		
		// Compare up to seconds
		Assert.assertEquals(a.toEpochSecond(ZoneOffset.UTC), b.toEpochSecond(ZoneOffset.UTC));
		
		// Compare up to TEST_DELTA_DATE_MS ms
		int msA = a.get(ChronoField.MILLI_OF_DAY);
		int msB = b.get(ChronoField.MILLI_OF_DAY);
		Assert.assertTrue(Math.abs(msA - msB) <= TEST_DELTA_DATE_MS);
			
	}
	
}
