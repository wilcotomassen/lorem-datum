package nl.wilcotomassen.loremdatum.generator.dates;

import java.util.Date;
import java.util.GregorianCalendar;

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
		assertDateEquals(configuration.start, new Date());
	}
	
	@Test 
	public final void testStartSetter() {
		
		final Date[] TEST_VALUES = {
				new Date(),
				new GregorianCalendar().getTime(),
				new GregorianCalendar(0, 0, 0).getTime(),
				new GregorianCalendar(2000, 1, 1).getTime(),
				new GregorianCalendar(2018, 05, 18, 20, 57, 13).getTime(),
				new GregorianCalendar(2093, 15, 18).getTime()
			};
		
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final Date testValue = TEST_VALUES[i];
			
			DateGeneratorConfiguration configuration = DateGeneratorConfiguration.builder()
					.start(testValue)
					.buildConfiguration();
			
			assertDateEquals(configuration.start, testValue);
			
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
	
	/**
	 * Assert that A and B are either both null, or no further apart
	 * than {@link TEST_DELTA_DATE_MS}
	 * 
	 * @param a
	 * @param b
	 */
	private static void assertDateEquals(Date a, Date b) {

		if (a != null && b != null) {
			
			long deltaMs = Math.abs(a.getTime() - b.getTime());
			Assert.assertTrue(deltaMs <= TEST_DELTA_DATE_MS, "Dates are not equal (" + deltaMs + "ms difference)");
			
		} else {
			// Assume both are null
			Assert.assertEquals(a, b);
		}
		
	}
	

}
