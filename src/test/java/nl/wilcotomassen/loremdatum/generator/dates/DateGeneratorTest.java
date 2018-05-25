package nl.wilcotomassen.loremdatum.generator.dates;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import nl.wilcotomassen.loremdatum.generator.dates.DateGeneratorConfiguration.IntervalUnit;

public class DateGeneratorTest {
	
	public final int[] intervalValueTests = {1, 2, 10, 100, 1000};
	
	@Parameters("generationTestCount")
	@Test
	public void testMilliSeconds(@Optional("100") int generationTestCount) {
		testInterval(IntervalUnit.MILLISECOND, ChronoUnit.MILLIS, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testSeconds(@Optional("100") int generationTestCount) {
		testInterval(IntervalUnit.SECOND, ChronoUnit.SECONDS, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testMinutes(@Optional("100") int generationTestCount) {
		testInterval(IntervalUnit.MINUTE, ChronoUnit.MINUTES, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testHours(@Optional("100") int generationTestCount) {
		testInterval(IntervalUnit.HOUR, ChronoUnit.HOURS, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testDays(@Optional("100") int generationTestCount) {
		testInterval(IntervalUnit.DAY, ChronoUnit.DAYS, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testWeeks(@Optional("100") int generationTestCount) {
		testInterval(IntervalUnit.WEEK, ChronoUnit.WEEKS, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testMonths(@Optional("100") int generationTestCount) {
		testInterval(IntervalUnit.MONTH, ChronoUnit.MONTHS, generationTestCount);
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testYears(@Optional("100") int generationTestCount) {
		testInterval(IntervalUnit.YEAR, ChronoUnit.YEARS, generationTestCount);
	}
	
	public void testInterval(IntervalUnit intervalUnit, TemporalUnit expectedUnit, int generationTestCount) {
		
		for (int interval: intervalValueTests) {
			
			// Create generator
			LocalDateTime startTime = LocalDateTime.of(0, 1, 1, 0, 0, 0);
			DateGenerator generator = DateGenerator.builder()
					.start(startTime)
					.intervalUnit(intervalUnit)
					.intervalValue(interval)
					.build();
			
			// Test start time
			Assert.assertEquals(startTime, generator.getCurrent());
			
			// Test increments
			for (int i = 1; i < generationTestCount + 1; i++) {
				
				LocalDateTime generatedValue = generator.getNext();
				LocalDateTime expectedValue = startTime.plus(i * interval, expectedUnit);
				
				Assert.assertEquals(generatedValue, generator.getCurrent());
				Assert.assertEquals(generatedValue, expectedValue);
				
			}
			
		}
	}

}
