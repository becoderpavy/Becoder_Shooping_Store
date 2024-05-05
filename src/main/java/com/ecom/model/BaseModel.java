package com.ecom.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseModel {

	private Integer createdBy;

	@Column(nullable = true)
	private Integer updatedBy;

	private Date createdDate;

	private Date updatedDate;

}
