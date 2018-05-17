package example;

import java.util.Date;

import nl.wilcotomassen.loremdatum.generator.dates.DateGeneratorConfiguration;
import nl.wilcotomassen.loremdatum.generator.numerical.FloatGenerator;
import nl.wilcotomassen.loremdatum.timeline.TimelineDataPoint;
import nl.wilcotomassen.loremdatum.timeline.TimelineSeries;

public class TimelineExample {

	public static void main(String[] args) {
		
		FloatGenerator valueGen = FloatGenerator.builder()
				.initiator(1000)
				.naProbability(0.1f)
				.build();
		
		for (int i = 0; i < 100; i++) {
			Float v = valueGen.getNext();
			System.out.println(v);
		}
////				
//		TimelineSeries tl = new TimelineSeries(
//				new DateGeneratorConfiguration(), 
//				valueGen);
		
//		for (int i = 0; i < 100; i++) {
//			TimelineDataPoint dp = tl.next();
//			Date t = dp.getDate();
//			Float v = (Float) dp.getValue();
//			
//			System.out.println(t.toString() + "\t" + v);
//		}

	}

}

