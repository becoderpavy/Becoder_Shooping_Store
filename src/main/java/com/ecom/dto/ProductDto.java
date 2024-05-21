package com.ecom.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto {

	private Integer id;

	private String title;

	private String description;

	private Integer discount;

	private Double originalPrice;

	private Double discountPrice;

	private Integer stock;

	private Boolean isActive;

	private Boolean isFeature;

}
