package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	// 로그인
	public UserVo exeLogin(UserVo userVo) {
		System.out.println("UserService.exeLogin()");

		UserVo authUser = userDao.userSelectByIdPw(userVo);

		return authUser;
	}

	// 회원가입
	public int exeUserInsert(UserVo userVo) {
		System.out.println("UserService.exeUserInsert()");

		int count = userDao.userInsert(userVo);

		return count;

	}

	//수정폼
	public UserVo exeModifyForm(int no) {
		System.out.println("UserService.exeModifyForm()");
		
		UserVo userVo=userDao.userSelectOne(no);

		return userVo;
	}
	
	
	// 수정
	public int exeModify(UserVo userVo) {
		System.out.println("UserService.exeModify()");

		int count = userDao.userUpdate(userVo);

		return count;
	}

}
