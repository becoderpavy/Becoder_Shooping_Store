package com.ecom.enums;

public enum OrderStatus {
	IN_PROGRESS(1, "Progress"), ORDER_RECEIVED(2, "Received"), PACKED(2, "Packed"), SHIPPED(3, "Shipped"),
	NET_BANKING(3, "Net Banking");

	private final int id;
	private final String displayName;

	OrderStatus(int id, String displayName) {
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
