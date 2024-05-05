package com.ecom.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

	@Override
	public Boolean uploadFile(MultipartFile file, String path) {

		try {
			String originalFilename = file.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			int lastIndex = originalFilename.lastIndexOf(".");
			String fileNameWithoutExtension = originalFilename.substring(0, lastIndex);
			String fileName = fileNameWithoutExtension.concat(uuid.toString());
			String extension = originalFilename.substring(lastIndex, originalFilename.length());

			String fullFileName = fileName.concat(extension);
			log.info(fullFileName);

			String storePath = path.concat(fullFileName);

			File savefile = new File(path);
			if (!savefile.exists()) {
				savefile.mkdir();
			}

			Files.copy(file.getInputStream(), Paths.get(storePath));
			log.info("Image Store Path : {}",Paths.get(storePath));
			return true;
		} catch (Exception e) {
			log.error("Error : {}", e.getMessage());
		}
		return false;
	}

}
