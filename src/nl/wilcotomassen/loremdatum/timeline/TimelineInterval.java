package nl.wilcotomassen.loremdatum.timeline;

public class TimelineInterval {
	
	private int unit;
	private int value;
	
	/**
	 * Construct TimelineInterval with unit and value
	 * @param unit
	 * @param value
	 */
	public TimelineInterval(int unit, int value) {
		this.unit = unit;
		this.value = value;
	}
	
	/**
	 * Get unit of the interval
	 * 
	 * @return
	 */
	public int getUnit() {
		return unit;
	}

	/**
	 * Get interval value
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
}