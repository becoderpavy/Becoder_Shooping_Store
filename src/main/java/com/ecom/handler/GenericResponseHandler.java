package com.ecom.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

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
public class GenericResponseHandler {

	private int status;
	private String message;
	private Object data;

	public ResponseEntity<?> create() {

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", status);
		response.put("message", message);

		if (!ObjectUtils.isEmpty(data)) {
			response.put("data", data);
		}
		return new ResponseEntity<>(response, HttpStatus.valueOf(status));
	}

}
