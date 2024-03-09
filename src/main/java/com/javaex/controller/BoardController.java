package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 리스트
	@RequestMapping(value = "/board", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("BoardController.list()");

		List<BoardVo> bList = boardService.exeList();

		model.addAttribute("bList", bList);

		return "board/list";
	}

	// 삭제
	@RequestMapping(value = "/board/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("BoardController.delete()");

		boardService.exeDelete(no);

		return "redirect:/board/list";
	}

	// 등록폼
	@RequestMapping(value = "/board/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("BoardController.writeForm()");

		return "board/writeForm";
	}

	// 등록
	@RequestMapping(value = "/board/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController.write()");

		boardService.exeInsert(boardVo);

		return "redirect:/board/list";
	}

	// 읽기
	@RequestMapping(value = "/board/read", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(@RequestParam(value = "no") int no, Model model) {
		System.out.println("BoardController.read()");

		BoardVo boardVo=boardService.exeSelectOne(no);
		
		model.addAttribute("boardVo", boardVo );
		
		return "board/read";
	}
	
	// 수정폼
	@RequestMapping(value = "/board/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int no, Model model) {
		System.out.println("BoardController.modifyForm()");

		BoardVo boardVo=boardService.exeSelectOne(no);
		model.addAttribute("boardVo",boardVo);
		
		return "board/modifyForm";
	}
	
	// 수정
	@RequestMapping(value = "/board/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController.modify()");
		
		boardService.exeModify(boardVo);
		System.out.println(boardVo);
		
		return "redirect:/board/list";
	}
	

}
