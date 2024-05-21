package com.ecom.enums;

public enum AddressType {

	PRESENT(1, "Present Address"), PERMANENT(2, "Permanent");

	private final int id;
	private final String displayName;

	AddressType(int id, String displayName) {
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
