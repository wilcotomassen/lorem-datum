package nl.wilcotomassen.loremdatum.generator;

import nl.wilcotomassen.loremdatum.generator.dates.*;
import nl.wilcotomassen.loremdatum.generator.numerical.*;

public class GeneratorFactory {
	
	public static Generator create(GeneratorConfiguration configuration) throws Exception {

		if (configuration instanceof DateGeneratorConfiguration) {
			return new DateGenerator((DateGeneratorConfiguration) configuration);
		} else if (configuration instanceof DoubleGeneratorConfiguration) {
			return new DoubleGenerator((DoubleGeneratorConfiguration) configuration);	
		} else if (configuration instanceof FloatGeneratorConfiguration) {
			return new FloatGenerator((FloatGeneratorConfiguration) configuration);
		} else if (configuration instanceof IntegerGeneratorConfiguration) {
			return new IntegerGenerator((IntegerGeneratorConfiguration) configuration);
		} else if (configuration instanceof LongGeneratorConfiguration) {
			return new LongGenerator((LongGeneratorConfiguration) configuration);
		} else {
			throw new Exception("Unrecognized configuration: " + configuration.getClass().getName());
		}
		
	}

}
