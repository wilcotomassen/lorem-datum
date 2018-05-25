package nl.wilcotomassen.loremdatum.generator.dates;

import java.util.Date;
import java.util.GregorianCalendar;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import nl.wilcotomassen.loremdatum.generator.dates.DateGeneratorConfiguration.IntervalUnit;

public class DateGeneratorTest {
	
//	public final int[] intervalValueTests = {1, 2, 10, 100, 1000};
	public final int[] intervalValueTests = {1};
	
	@Parameters("generationTestCount")
	@Test
	public void testSeconds(@Optional("100") int generationTestCount) {
		
		for (int interval: intervalValueTests) {
			
			// Create generator
			Date startTime = new GregorianCalendar(0, 0, 0, 0, 0, 0).getTime();
			DateGenerator generator = DateGenerator.builder()
					.start(startTime)
					.intervalUnit(IntervalUnit.SECOND)
					.intervalValue(interval)
					.build();
			
			// Test start time
			Assert.assertEquals(startTime, generator.getCurrent());
			
			// Test increments
			for (int i = 1; i < generationTestCount + 1; i++) {
				
				Date generatedValue = generator.getNext();
				Date expectedValue = new GregorianCalendar(0, 0, 0, 0, 0, i * interval).getTime();
				
				Assert.assertEquals(generatedValue, generator.getCurrent());
				Assert.assertEquals(generatedValue, expectedValue);
				
			}
			
		}
		
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testMinutes(@Optional("100") int generationTestCount) {
		
		for (int interval: intervalValueTests) {
			
			// Create generator
			Date startTime = new GregorianCalendar(0, 0, 0, 0, 0, 0).getTime();
			DateGenerator generator = DateGenerator.builder()
					.start(startTime)
					.intervalUnit(IntervalUnit.MINUTE)
					.intervalValue(interval)
					.build();
			
			// Test start time
			Assert.assertEquals(startTime, generator.getCurrent());
			
			// Test increments
			for (int i = 1; i < generationTestCount + 1; i++) {
				
				Date generatedValue = generator.getNext();
				Date expectedValue = new GregorianCalendar(0, 0, 0, 0, i * interval, 0).getTime();
				
				Assert.assertEquals(generatedValue, generator.getCurrent());
				Assert.assertEquals(generatedValue, expectedValue);
				
			}
			
		}
		
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testHours(@Optional("100") int generationTestCount) {
		
		for (int interval: intervalValueTests) {
			
			// Create generator
			Date startTime = new GregorianCalendar(0, 0, 0, 0, 0, 0).getTime();
			DateGenerator generator = DateGenerator.builder()
					.start(startTime)
					.intervalUnit(IntervalUnit.HOUR)
					.intervalValue(interval)
					.build();
			
			// Test start time
			Assert.assertEquals(startTime, generator.getCurrent());
			
			// Test increments
			for (int i = 1; i < generationTestCount + 1; i++) {
				
				Date generatedValue = generator.getNext();
				Date expectedValue = new GregorianCalendar(0, 0, 0, i * interval, 0, 0).getTime();
				
				Assert.assertEquals(generatedValue, generator.getCurrent());
				Assert.assertEquals(generatedValue, expectedValue);
				
			}
			
		}
		
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testDays(@Optional("100") int generationTestCount) {
		
		for (int interval: intervalValueTests) {
			
			// Create generator
			Date startTime = new GregorianCalendar(0, 0, 0, 0, 0, 0).getTime();
			DateGenerator generator = DateGenerator.builder()
					.start(startTime)
					.intervalUnit(IntervalUnit.DAY)
					.intervalValue(interval)
					.build();
			
			// Test start time
			Assert.assertEquals(startTime, generator.getCurrent());
			
			// Test increments
			for (int i = 1; i < generationTestCount + 1; i++) {
				
				Date generatedValue = generator.getNext();
				Date expectedValue = new GregorianCalendar(0, 0, i * interval).getTime();
				
				Assert.assertEquals(generatedValue, generator.getCurrent());
				Assert.assertEquals(generatedValue, expectedValue);
				
			}
			
		}
		
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testWeeks(@Optional("100") int generationTestCount) {
		
		for (int interval: intervalValueTests) {
			
			// Create generator
			Date startTime = new GregorianCalendar(0, 0, 0, 0, 0, 0).getTime();
			DateGenerator generator = DateGenerator.builder()
					.start(startTime)
					.intervalUnit(IntervalUnit.WEEK)
					.intervalValue(interval)
					.build();
			
			// Test start time
			Assert.assertEquals(startTime, generator.getCurrent());
			
			// Test increments
			for (int i = 1; i < generationTestCount + 1; i++) {
				
				Date generatedValue = generator.getNext();
				Date expectedValue = new GregorianCalendar(0, 0, i * interval * 7, 0, 0, 0).getTime();
				
				Assert.assertEquals(generatedValue, generator.getCurrent());
				Assert.assertEquals(generatedValue, expectedValue);
				
			}
			
		}
		
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testMonths(@Optional("100") int generationTestCount) {
		
		generationTestCount = 20;
		
		for (int interval: intervalValueTests) {
			
			// Create generator
			Date startTime = new GregorianCalendar(0, 0, 0, 0, 0, 0).getTime();
			DateGenerator generator = DateGenerator.builder()
					.start(startTime)
					.intervalUnit(IntervalUnit.MONTH)
					.intervalValue(interval)
					.build();
			
			// Test start time
			Assert.assertEquals(startTime, generator.getCurrent());
			
			// Test increments
			for (int i = 0; i < generationTestCount; i++) {
				
				Date generatedValue = generator.getNext();
				Date expectedValue = new GregorianCalendar(0, i * interval, 0, 0, 0, 0).getTime();
				
				System.out.println(generatedValue.getMonth() + " > " + (i % 12));
				
//				Assert.assertEquals(generatedValue, generator.getCurrent());
//				Assert.assertEquals(generatedValue, expectedValue);
				
			}
			
		}
		
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testYears(@Optional("100") int generationTestCount) {
		
		for (int interval: intervalValueTests) {
			
			// Create generator
			Date startTime = new GregorianCalendar(0, 0, 0, 0, 0, 0).getTime();
			DateGenerator generator = DateGenerator.builder()
					.start(startTime)
					.intervalUnit(IntervalUnit.YEAR)
					.intervalValue(interval)
					.build();
			
			// Test start time
			Assert.assertEquals(startTime, generator.getCurrent());
			
			// Test increments
			for (int i = 1; i < generationTestCount + 1; i++) {
				
				Date generatedValue = generator.getNext();
				Date expectedValue = new GregorianCalendar(i * interval, 0, 0).getTime();
				
				Assert.assertEquals(generatedValue, generator.getCurrent());
				Assert.assertEquals(generatedValue, expectedValue);
				
			}
			
		}
		
	}
	

}
