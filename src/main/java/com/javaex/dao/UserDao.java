package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	// 로그인
	public UserVo userSelectByIdPw(UserVo userVo) {
		System.out.println("UserDao.userSelectByIdPw()");

		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);

		return authUser;
	}

	// 회원가입
	public int userInsert(UserVo userVo) {
		System.out.println("UserDao.userInsert()");

		int count = sqlSession.insert("user.insert", userVo);

		return count;
	}
	// 수정폼
	public UserVo userSelectOne(int no) {
		System.out.println("UserDao.userSelectOne()");
		
		UserVo userVo=sqlSession.selectOne("user.selectOne",no);
		System.out.println(userVo);
		
		return userVo;
	}
	
	
	// 수정
	public int userUpdate(UserVo userVo) {
		System.out.println("UserDao.userUpdate()");

		int count = sqlSession.update("user.update", userVo);
		System.out.println(userVo);
		return count;
	}

}
