package com.ecom.enums;

public enum DeliveryType {

	OFFICE(1, "Office"), HOME(2, "Home"), OTHER(3, "Other");

	private final int id;
	private final String displayName;

	DeliveryType(int id, String displayName) {
		this.id = id;
		this.displayName = displayName;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return displayName;
	}

}
