package com.javaex.dao;

import org.springframework.stereotype.Repository;

import com.javaex.vo.AttachVo;

@Repository
public class AttachDao {

	public AttachVo exeSave(AttachVo attachVo) {
		
		System.out.println("AttachDao.exeSave()");
		
		return attachVo;
		
	}
	
}
