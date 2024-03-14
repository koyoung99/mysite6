package com.javaex.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
public class ApiGuestbookController {

	@Autowired
	private GuestService guestService;

	// 리스트
	@ResponseBody // return의 데이타를 json방식으로변경해서 응답문서(response)의 바디(body)에 붙여서 보내줘
	@RequestMapping(value = "/api/guestbooks", method = RequestMethod.GET)
	public List<GuestVo> list() {
		System.out.println("ApiGuestbookController.list()");

		List<GuestVo> guestList = guestService.exeList();
		System.out.println(guestList);

		return guestList;
	}

	// 등록
	@ResponseBody
	@RequestMapping(value = "/api/guestbooks", method = RequestMethod.POST)
	public GuestVo add(@ModelAttribute GuestVo guestVo) {
		System.out.println("ApiGuestbookController.add()");
		System.out.println(guestVo);
		GuestVo gVo = guestService.exeAddandGuest(guestVo);
		System.out.println(gVo);
		return gVo;
	}
	
}
