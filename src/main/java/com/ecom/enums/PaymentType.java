package com.ecom.enums;

public enum PaymentType {
	COD(1, "Cash on Delivery"), CREDIT_CARD(2, "Credit Card"), DEBIT_CARD(2, "Debit Card"), UPI(23, "Upi"),
	NET_BANKING(3, "Net Banking");

	private final int id;
	private final String displayName;

	PaymentType(int id, String displayName) {
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
