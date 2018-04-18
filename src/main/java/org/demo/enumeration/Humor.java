package org.demo.enumeration;

public enum Humor {

	LOW("Low", 1),
	MEDIUM("Medium", 2),
	HIGH("High", 3);

	private String humorLevel;
	private int humorValue;

	/*
	 * Default constructor
	 */
	Humor(String humorLevel, int humorValue) {
		this.humorLevel = humorLevel;
		this.humorValue = humorValue;
	}

	public String toString() {
		return humorLevel + " " + humorValue;

	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S)
	// ----------------------------------------------------------------------

	public String getHumorLevel() {
		return humorLevel;
	}

	public void setHumorLevel(String humorLevel) {
		this.humorLevel = humorLevel;
	}

	public int getHumorValue() {
		return humorValue;
	}

	public void setHumorValue(int humorValue) {
		this.humorValue = humorValue;
	}
}
