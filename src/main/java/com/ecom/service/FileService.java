package com.ecom.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public Boolean uploadFile(MultipartFile file, String path);

}
