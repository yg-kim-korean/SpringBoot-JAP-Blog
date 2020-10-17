package com.cos.Blog.Test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답(HtML파일)
// @Controller

//사용자가 요청 -> 응답해주는게 컨트롤러임(Data)
@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpController Test : ";
	@GetMapping("/http/lombokTest")
	public String lombokTest() {
		//순서 안지키고 넣어도 상관없고, 넣고싶은거만 넣어도 상관없다.
		Member m = Member.builder().username("ssar").password("1234").email("asdw").build();
		System.out.println(TAG+"getter : "+m.getUsername());
		m.setUsername("yg");
		System.out.println(TAG+"getter : "+m.getUsername());
		return "lombok Test 완료  : " + m.getId() +" , " + m.getUsername()+" , " +m.getPassword()+" , " +m.getEmail();
		
	}
	
	//인터넷 브라우저 요청은 무조건 get 요청밖에 허용되지 않음
	//http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest(Member m) {//http/get?id=1&username=S&password=1234&email=ss@naver.com

		return "get 요청 : " + m.getId() +" , " + m.getUsername()+" , " +m.getPassword()+" , " +m.getEmail();
	}
	
	@PostMapping("/http/post") // text/plain, application/json
	public String postTest(@RequestBody Member m) {// MessageConverter (스프링부트가 자동으로 해줌) 
		return "post 요청 : " + m.getId() +" , " + m.getUsername()+" , " +m.getPassword()+" , " +m.getEmail();
//		return text;
	}
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
//		return "put 요청";
		return "put 요청 : " + m.getId() +" , " + m.getUsername()+" , " +m.getPassword()+" , " +m.getEmail();
	}
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
