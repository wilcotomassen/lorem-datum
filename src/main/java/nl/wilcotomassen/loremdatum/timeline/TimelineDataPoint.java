package nl.wilcotomassen.loremdatum.timeline;

import java.time.LocalDateTime;

/**
 * A single Data point for a TimelineSeries 
 */
public class TimelineDataPoint {
	
	private LocalDateTime date;
	private Object value;
	
	public TimelineDataPoint(LocalDateTime date, Object value) {
		this.date = date;
		this.value = value;
	}

	/**
	 * Get date for the data point
	 * 
	 * @return
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * Get value for the data point
	 * @return
	 */
	public Object getValue() {
		return value;
	}

}
