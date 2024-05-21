package com.ecom.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String title;

	private String description;

	@Column(nullable = false)
	private Integer discount;

	@Column(nullable = false)
	private Double originalPrice;

	@Column(nullable = true)
	private Double discountPrice;

	@Column(nullable = false)
	private Integer stock; 

	@Column(nullable = false) 
	private Boolean isActive;

	@Column(nullable = false)
	private Boolean isFeature;

	@OneToMany(mappedBy = "product")   
//	@JoinColumn(name = "product_id")
	private List<ProductImage> images;

	@ManyToOne
	private Category category;

}
