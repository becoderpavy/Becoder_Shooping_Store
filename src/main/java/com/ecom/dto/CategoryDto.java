package com.ecom.dto;

import java.util.List;

import com.ecom.model.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDto extends BaseDto{
	private Integer id;

	private String name;

	private String description;

	@Builder.Default
	private Boolean isActive = true;
	
	@Builder.Default
	private Boolean isDeleted = false;

	@Builder.Default
	private Boolean isFeatures=false;

	private String images;
	
	private List<ProductDto> products;
}
