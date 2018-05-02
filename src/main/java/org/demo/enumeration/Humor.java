package org.demo.enumeration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	// ----------------------------------------------------------------------
	// Give list of Humor numerical values
	// ----------------------------------------------------------------------

	private static final List<Integer> HUMORVALUES;

	static {
		HUMORVALUES = new ArrayList<>();
		for (Humor Enum : Humor.values()) {
			HUMORVALUES.add(Enum.humorValue);
		}
	}

	public static List<Integer> getValues() {
		return Collections.unmodifiableList(HUMORVALUES);
	}

	// ----------------------------------------------------------------------
	// Give list of Humor level  texts
	// ----------------------------------------------------------------------
	private static final List<String> HUMORTEXTS;

	static {
		HUMORTEXTS = new ArrayList<>();
		for (Humor Enum : Humor.values()) {
			HUMORTEXTS.add(Enum.humorLevel);
		}
	}

	public static List<String> getTexts() {
		return Collections.unmodifiableList(HUMORTEXTS);
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

	// To string method
	public String toString() {
		return humorLevel + " " + humorValue;
	}
}