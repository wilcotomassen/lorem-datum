package nl.wilcotomassen.loremdatum.generator;

import org.testng.Assert;
import org.testng.annotations.Test;

import nl.wilcotomassen.loremdatum.generator.dates.*;
import nl.wilcotomassen.loremdatum.generator.numerical.*;

public class GeneratorFactoryTest {
	
	@Test
	public void testDateGeneratorCreation() throws Exception {
		DateGeneratorConfiguration config = DateGenerator.builder().buildConfiguration();
		Generator generator = GeneratorFactory.create(config);
		
		Assert.assertNotNull(generator);
		Assert.assertEquals(generator.getClass(), DateGenerator.class);
	}
	
	@Test
	public void testDoubleGeneratorCreation() throws Exception {
		DoubleGeneratorConfiguration config = DoubleGenerator.builder().buildConfiguration();
		Generator generator = GeneratorFactory.create(config);
		
		Assert.assertNotNull(generator);
		Assert.assertEquals(generator.getClass(), DoubleGenerator.class);
	}
	
	@Test
	public void testFloatGeneratorCreation() throws Exception {
		FloatGeneratorConfiguration config = FloatGenerator.builder().buildConfiguration();
		Generator generator = GeneratorFactory.create(config);
		
		Assert.assertNotNull(generator);
		Assert.assertEquals(generator.getClass(), FloatGenerator.class);
	}
	
	@Test
	public void testIntegerGeneratorCreation() throws Exception {
		IntegerGeneratorConfiguration config = IntegerGenerator.builder().buildConfiguration();
		Generator generator = GeneratorFactory.create(config);
		
		Assert.assertNotNull(generator);
		Assert.assertEquals(generator.getClass(), IntegerGenerator.class);
	}
	
	@Test
	public void testLongGeneratorCreation() throws Exception {
		LongGeneratorConfiguration config = LongGenerator.builder().buildConfiguration();
		Generator generator = GeneratorFactory.create(config);
		
		Assert.assertNotNull(generator);
		Assert.assertEquals(generator.getClass(), LongGenerator.class);
	}
	
}
