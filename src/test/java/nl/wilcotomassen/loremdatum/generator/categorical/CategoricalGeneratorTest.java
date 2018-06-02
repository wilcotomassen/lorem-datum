package nl.wilcotomassen.loremdatum.generator.categorical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import nl.wilcotomassen.loremdatum.generator.categorical.CategoricalGeneratorConfiguration.ConfigurationBuilder;

public class CategoricalGeneratorTest {
	
	@Parameters("generationTestCount")
	@Test
	public void testValuesNonNull(@Optional("100") int generationTestCount) {
		
		final Object[] TEST_VALUES = { 1f, "Hello world", 132, 3002L};
		final double[] TEST_PROBABILITIES = {13, 93, 102, 34};
		
		// Build configuration
		ConfigurationBuilder<?> builder = CategoricalGenerator.builder();
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final Object testValue = TEST_VALUES[i];
			final double testProbability = TEST_PROBABILITIES[i];
			builder.addItem(testProbability, testValue);
		}
		CategoricalGenerator generator = builder.build();
		
		List<Object> testValueList = Arrays.asList(TEST_VALUES);
		for (int i = 0; i < generationTestCount; i++) {
			Object value = generator.getNext();
			
			Assert.assertNotNull(value);
			Assert.assertTrue(testValueList.contains(value));
			
		}
		
	}
	
	@Parameters("generationTestCount")
	@Test
	public void testValuesNull(@Optional("100") int generationTestCount) {
		
		final Object[] TEST_VALUES = { 1f, "Hello world", 132, 3002L};
		final double[] TEST_PROBABILITIES = {13, 93, 102, 34};
		
		// Build configuration
		ConfigurationBuilder<?> builder = CategoricalGenerator.builder();
		builder = builder.naProbability(0.5f);
		for (int i = 0; i < TEST_VALUES.length; i++) {
			final Object testValue = TEST_VALUES[i];
			final double testProbability = TEST_PROBABILITIES[i];
			builder.addItem(testProbability, testValue);
		}
		CategoricalGenerator generator = builder.build();
		
		List<Object> testValueList = Arrays.asList(TEST_VALUES);
		for (int i = 0; i < generationTestCount; i++) {
			Object value = generator.getNext();
			
			if (value != null) {
				Assert.assertTrue(testValueList.contains(value));				
			}
			
		}
		
	}
	
	@Test
	public void testProbability() {
		
		final int TEST_COUNT = 10000;
		final double ALLOWED_ERROR = 0.01; // Allow 1% error
		
		class TestObject {
			public final Object value;
			public final double probability;
			public int occurenceCount = 0;
			
			public TestObject(Object value, double probability) {
				this.value = value;
				this.probability = probability;
			}
			
		};
		
		ArrayList<TestObject> testObjects = new ArrayList<TestObject>();
		testObjects.add(new TestObject("Foo", 0.5));
		testObjects.add(new TestObject("Bar", 0.3));
		testObjects.add(new TestObject("Baz", 0.2));
		
		ConfigurationBuilder<?> builder = CategoricalGenerator.builder();
		for (TestObject obj: testObjects) {
			builder.addItem(obj.probability, obj.value);
		}
		CategoricalGenerator generator = builder.build();

		// Count occurrences of generated values
		for (int i = 0; i < TEST_COUNT; i++) {
			Object value = generator.getNext();
			
			TestObject object = testObjects.stream()
				.filter(o -> o.value.equals(value))
				.findFirst()
				.get();
			object.occurenceCount++;
			
		}
		
		for (TestObject obj: testObjects) {
			double expectedOccurenceCount = obj.probability * (double) TEST_COUNT;
			Assert.assertEquals(obj.occurenceCount, expectedOccurenceCount, ALLOWED_ERROR * (double) TEST_COUNT);
		}
		
	}

}

