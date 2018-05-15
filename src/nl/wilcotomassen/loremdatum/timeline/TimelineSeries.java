package nl.wilcotomassen.loremdatum.timeline;

import java.util.ArrayList;

import nl.wilcotomassen.loremdatum.generator.Generator;
import nl.wilcotomassen.loremdatum.generator.GeneratorConfiguration;
import nl.wilcotomassen.loremdatum.generator.GeneratorFactory;
import nl.wilcotomassen.loremdatum.generator.dates.DateGenerator;
import nl.wilcotomassen.loremdatum.generator.dates.DateGeneratorConfiguration;

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
		TimelineDataPoint dataPoint = new TimelineDataPoint(dateGenerator.getNext(), valueGenerator.getNext());
		dataPoints.add(dataPoint);
		return dataPoint;
	}
	
}
