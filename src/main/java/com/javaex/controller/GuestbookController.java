package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestService guestService;

	// 리스트
	@RequestMapping(value = "/guest", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("GuestController.list()");

		List<GuestVo> guestList = guestService.exeList();

		model.addAttribute("gList", guestList);

		return "guestbook/addList";

	}

	// 추가
	@RequestMapping(value = "/guest/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute GuestVo guestVo) {
		System.out.println(guestVo);

		guestService.exeInsert(guestVo);

		return "redirect:/guest";
	}

	// 삭제폼
	@RequestMapping(value = "/guest/deleteform", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm() {

		return "guestbook/deleteForm";
	}

	// 삭제
	@RequestMapping(value = "/guest/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestVo guestVo) {

		guestService.exeDelete(guestVo);

		return "redirect:/guest";
	}
	
	
	
	
	
	
	// ajax방명록 메인
		@RequestMapping(value = "/ajaxindex", method = { RequestMethod.GET, RequestMethod.POST })
		public String ajaxIndex() {
			System.out.println("GuestController.ajaxIndex()");

			return "ajaxindex";
		}
}
