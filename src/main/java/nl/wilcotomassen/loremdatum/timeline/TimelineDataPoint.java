package nl.wilcotomassen.loremdatum.timeline;

import java.util.Date;

/**
 * A single Data point for a TimelineSeries 
 */
public class TimelineDataPoint {
	
	private Date date;
	private Object value;
	
	public TimelineDataPoint(Date date, Object value) {
		this.date = date;
		this.value = value;
	}

	/**
	 * Get date for the data point
	 * 
	 * @return
	 */
	public Date getDate() {
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
