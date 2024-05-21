package com.ecom.model;

import java.util.Date;

import com.ecom.enums.DeliveryType;
import com.ecom.enums.OrderStatus;
import com.ecom.enums.PaymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date bookingDate;

	private String orderNumber;

	private Cart cart;

	private UserDtls customer;

	private Address address;

	private DeliveryType delivery;
	
	private PaymentType payment;
	
	private OrderStatus status;
	
}
