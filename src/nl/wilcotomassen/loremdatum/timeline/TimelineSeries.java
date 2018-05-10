package nl.wilcotomassen.loremdatum.timeline;

import java.util.ArrayList;

import nl.wilcotomassen.loremdatum.generator.DateGenerator;
import nl.wilcotomassen.loremdatum.generator.Generator;
import nl.wilcotomassen.loremdatum.generator.GeneratorFactory;
import nl.wilcotomassen.loremdatum.generator.configuration.DateGeneratorConfiguration;
import nl.wilcotomassen.loremdatum.generator.configuration.GeneratorConfiguration;

public class TimelineSeries {
	
	private DateGenerator dateGenerator;
	private Generator valueGenerator;
	
	private ArrayList<TimelineDataPoint> dataPoints = new ArrayList<TimelineDataPoint>();
	
	public TimelineSeries(DateGeneratorConfiguration dateConfiguration, GeneratorConfiguration valueGeneratorConfiguration) {
		dateGenerator = new DateGenerator(dateConfiguration);
		try {
			this.valueGenerator = GeneratorFactory.create(valueGeneratorConfiguration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void generateData(int count) {
		for (int i = 0; i < count; i++) {
			next();
		}
	}
	
	public TimelineDataPoint next() {
		TimelineDataPoint dataPoint = new TimelineDataPoint(dateGenerator.next(), valueGenerator.next());
		dataPoints.add(dataPoint);
		return dataPoint;
	}
	
}
