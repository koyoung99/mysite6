package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;

	public List<BoardVo> boardSelect() {
		System.out.println("BoardDao.boardSelect()");

		List<BoardVo> bList = sqlSession.selectList("board.select");

		return bList;
	}

	public int boardDelete(int no) {
		System.out.println("BoardDao.boardDelete()");

		int count = sqlSession.delete("board.delete", no);

		return count;
	}

	public int boardInsert(BoardVo boardVo) {
		System.out.println("BoardDao.boardInsert()");

		int count = sqlSession.insert("board.insert", boardVo);

		return count;
	}

	public BoardVo boardSelectOne(int no) {
		System.out.println("BoardDao.selectOne()");
		
		BoardVo boardVo = sqlSession.selectOne("board.selectOne", no);

		return boardVo;
	}
	
	public int boardModify(BoardVo boardVo) {
		System.out.println("BoardDao.boardModify()");
		
		int count = sqlSession.update("board.update", boardVo);
		
		return count;
	}



}
