package com.ecom.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseDto {

	private int createdBy;

	private int updatedBy;

	private Date createdDate;

	private Date updatedDate;

}
