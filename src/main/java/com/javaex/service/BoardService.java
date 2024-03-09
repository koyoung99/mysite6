package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	// 리스트
	public List<BoardVo> exeList() {
		System.out.println("BoardService.exeList()");

		List<BoardVo> bList = boardDao.boardSelect();

		return bList;

	}

	// 삭제
	public int exeDelete(int no) {
		System.out.println("BoardService.exeDelete()");
		int count = boardDao.boardDelete(no);

		return count;
	}

	// 등록
	public int exeInsert(BoardVo boardVo) {
		System.out.println("BoardService.exeInsert()");

		int count = boardDao.boardInsert(boardVo);

		return count;

	}

	// 읽기
	public BoardVo exeSelectOne(int no) {
		System.out.println("BoardService.exeSelectOne()");

		BoardVo boardVo = boardDao.boardSelectOne(no);

		return boardVo;
	}
	
	// 수정
	public int exeModify(BoardVo boardVo) {
		System.out.println("BoardService.exeModify()");
		
		int count=boardDao.boardModify(boardVo);
		
		return count;
	}

	
	

	

}
