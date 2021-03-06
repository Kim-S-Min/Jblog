package com.bitacademy.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "D:/upload";
	private static Logger logger = LoggerFactory.getLogger(FileUploadService.class);
	
	
	public String store(MultipartFile multipartFile) {
		String saveFileName= "";
		try {
			String originalFileName = multipartFile.getOriginalFilename();
			Long size = multipartFile.getSize();
			
			
			logger.debug("Multipart-원본파일명:" + originalFileName);
			logger.debug("Multipart-파일크기:" + size);
			
			String extName = originalFileName.substring(originalFileName.lastIndexOf("."));
			logger.debug("파일 확장자 : " + extName);
			
			saveFileName = getSaveFileName(extName);
			logger.debug("실제 저장될 파일명 : " + saveFileName);
			
			writeFile(multipartFile, saveFileName);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return saveFileName;
	}
	
	private String getSaveFileName(String ext) {
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.getTimeInMillis() / 1000) + ext.toLowerCase();
	}
	
	private void writeFile(MultipartFile mFile, String saveFileName) throws IOException {
		
		byte[] fileData = mFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		
		fos.write(fileData);
		fos.flush();
		fos.close();
	}
}

