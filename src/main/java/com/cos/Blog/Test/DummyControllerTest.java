package com.cos.Blog.Test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.Blog.model.RoleType;
import com.cos.Blog.model.User;
import com.cos.Blog.repository.UserRepository;

//html 파일이 아니라 data를 리턴해주는 Controller다
@RestController
public class DummyControllerTest {
	
	@Autowired // dummy 컨트롤러 테스트가 메모리에 뜰때 user레파지토리도 메모리에 뜨도록 해줌 // -> 의존성 주입(DI)
	private UserRepository userRepository; 
	
	@GetMapping("/dummy/user/{id}") //{id}주소로 파라메터를 전달받을 수 있음 //http://localhost:8000/blog/dummy/user/3
	public User detail(@PathVariable int id) {
		
		//user -> 4를 찾았을 경우 데이터베이스에 없으면 user가 null 이면 안되지 않니?
		// 그럼 return null 이면 이 시스템에 문제생기자나
		//Optional로 너의 User객체를 감싸서 가져올테니 null 인지 아닌지 판단해서 return 해!
		//User user =  userRepository.findById(id).get();
		
//		User user =  userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override //supplier 함수가 가지고 있는 get 함수 오버라이딩 하기.
//			public User get() { // 만약에 데이터베이스에 없는 것을 넣으면 이놈이 실행됨
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});

//		// 없으면 다 null 로 나옴
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				// TODO Auto-generated method stub
//				return new User();
//			}
//		});
		
//		// 스프링에서 선호하는것
//		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//			@Override
//			public IllegalArgumentException get() {
//				// TODO Auto-generated method stub
//				return new IllegalArgumentException("해당 유저는 없습니다. ID : " + id);
//			}
//		});
		
		// 위에꺼랑 똑같은거 람다식 
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 유저는 없습니다. ID : " + id);
		});
		//요청 : 웹브라우저
		// user 객체 = 자바 오브젝트
		// 변환해야된다 ( 웹 브라우저가 이해할 수 있는데이터) ->json 으로 (예전에는 gson라이브러리 사용했음)
		//스프링 부트는 MessageConverter 라는애가 응답시에 자동 작동한다.
		// 만약 자바 오브젝트를 리턴하게되면 MessageConverter가 Jackson 라이브러리를 호출해서
		// user 오브젝트를 json으로 변환해서 브라우저에게 던져줍니다.
		return user;
		
	}
	
	//http://localhost:8000/blog/dummy/join (요청)
	//http의 body에 username, password, email 데이터를 가지고 요청
	@PostMapping("/dummy/join")
	public String join(User user) { //key = value (규칙) 제대로 변수명만 똑같이 해주면 알아 서 집어넣어 줌.
		System.out.println("username : " + user.getUsername() );
		System.out.println("password : " + user.getPassword() );
		System.out.println("email : " + user.getEmail() );
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 완료";
		
	}
}
