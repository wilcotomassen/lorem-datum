package nl.wilcotomassen.loremdatum.generator;

import nl.wilcotomassen.loremdatum.generator.configuration.DoubleGeneratorConfiguration;

public class FloatGenerator extends NumericalGenerator {
	
	public FloatGenerator(DoubleGeneratorConfiguration configuration) {
		super(configuration);
	}
	
	private static final Float doubleToFloat(Double v) {
		return (v != null) 
			? (float) v.doubleValue()
			: null;
	}
	
	@Override
	public Float current() {
		return doubleToFloat(getCurrent());
	}

	@Override
	public Float next() {
		return doubleToFloat(getNext());
	}
	
}
