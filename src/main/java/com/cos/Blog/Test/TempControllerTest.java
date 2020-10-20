package com.cos.Blog.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //레스트 컨트롤러는 그냥 text 리턴하는거고 그냥 컨트롤러는 파일리턴
public class TempControllerTest {
	
	//http://localhost:8000/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("hello");
		// 스프링 파일리턴 기본경로 : src/main/resources/static
		//리턴 명 : /home.html 로 지정해야 한다.
		return "/home.html";
	}
	//jsp 처럼 유동적인 파일은 src/main/webapp/WEB-INF/views에 넣도록 yml에 mvc밑에 저장한다.
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		return "test";
	}
}
