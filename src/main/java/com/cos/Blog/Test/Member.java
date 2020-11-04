package com.cos.Blog.Test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
	private int id; //데베에서 가져와서 변경할 일 없으니까 final 함
	private String username;
	private String password;
	private String email;
	
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	

}
