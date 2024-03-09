package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 로그인폼
	@RequestMapping(value = "/user/loginform", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		return "user/loginForm";
	}

	// 로그인
	@RequestMapping(value = "/user/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login()");

		UserVo authUser = userService.exeLogin(userVo);

		session.setAttribute("authUser", authUser);
		System.out.println(authUser);
		return "redirect:/main";
	}


	// 로그아웃
	@RequestMapping(value = "/user/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/main";
	}

	// 회원가입폼
	@RequestMapping(value = "/user/joinform", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		System.out.println("UserController.joinForm()");

		return "user/joinForm";
	}

	// 회원가입
	@RequestMapping(value = "/user/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.join()");

		userService.exeUserInsert(userVo);

		return "user/joinOk";
	}

	// 수정폼
	@RequestMapping(value = "/user/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(Model model, HttpSession session) {
		System.out.println("UserController.modifyForm()");

		// 세션으로 값 받아오기
		UserVo uV = (UserVo) session.getAttribute("authUser");
		int no = uV.getNo();

		UserVo userVo=userService.exeModifyForm(no);
		
		model.addAttribute("userVo", userVo);
		return "user/modifyForm";
	}

	// 수정
	@RequestMapping(value = "/user/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.modify()");

		UserVo userVo1 = (UserVo) session.getAttribute("authUser");

		int no = userVo1.getNo();

		userVo.setNo(no);

		userService.exeModify(userVo);
		userVo.setName(userVo.getName());

		return "redirect:/main";
	}

}
