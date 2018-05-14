package nl.wilcotomassen.loremdatum.generator;

import nl.wilcotomassen.loremdatum.generator.configuration.DoubleGeneratorConfiguration;

public class DoubleGenerator extends NumericalGenerator {
	
	public DoubleGenerator(DoubleGeneratorConfiguration configuration) {
		super(configuration);
	}
	
	@Override
	public Double current() {
		return getCurrent(); 
	}

	@Override
	public Double next() {
		return getNext();
	}

}
