package nl.wilcotomassen.loremdatum.generator;

import nl.wilcotomassen.loremdatum.generator.configuration.DoubleGeneratorConfiguration;

public class IntegerGenerator extends NumericalGenerator {
	
	public IntegerGenerator(DoubleGeneratorConfiguration configuration) {
		super(configuration);
	}

	private final static Integer doubleToInteger(Double v) {
		return (v != null) 
			? (int) v.doubleValue()
			: null;
	}
	@Override
	public Integer current() {
		return doubleToInteger(getCurrent());
	}

	@Override
	public Object next() {
		return doubleToInteger(getNext());
	}

}
