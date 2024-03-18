package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.AttachDao;
import com.javaex.vo.AttachVo;

@Service
public class AttachService {

	@Autowired
	private AttachDao attachDao;

	public String exeUpload(MultipartFile file) {

		System.out.println("AttachService.exeUpload()");

		// 파일저장 폴더
		String saveDir = "C:\\javaStudy\\upload";

		// (0) 파일관련 정보수집
		// 오리지널 파일명
		String orgName = file.getOriginalFilename();
		System.out.println("orgName:" + orgName);

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println("exName:" + exName);

		// 저장파일명(겹치지않아야한다)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName:" + saveName);

		// 파일사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize:" + fileSize);

		// 파일 전체 경로(저장파일명 포함)
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath:" + filePath);

		// (1) 파일정보를 DB에저장
		// vo로 묶어
		AttachVo attachVo = new AttachVo(orgName, saveName, filePath, fileSize);
		System.out.println(attachVo);

		// db에 저장 Dao--> 의 메소드호출해서 저장
		System.out.println("db저장완료");
		attachDao.exeSave(attachVo);

		// (2) 파일을 하드디스크에 저장
		// 파일저장
		try {

			byte[] fileData = file.getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return saveName;
	}

}
