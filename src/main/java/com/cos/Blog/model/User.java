package com.cos.Blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//ORM-> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity // User 클래스가 자동으로 Mysql에 테이블이 생성된다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴 !!
//@DynamicInsert //null 인 인서트 인건 생성되는 인서트 문에 안넣는다(db 만들때 default 들어갈거니까)
public class User {
	
	@Id // primary key 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY)// identity 는 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다는 의미
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable=false, length=30)
	private String username; // id
	
	@Column(nullable=false, length=100) // 패스워드를 해쉬(비밀번호 암호화)로 하기때문에 길게 
	private String password;
	
	@Column(nullable=false, length=50)
	private String email;
	
	//@ColumnDefault("user")
	@Enumerated(EnumType.STRING) //DB는 RoleType이라는게 없으므로
	private RoleType role; //Enum을 쓰는게 좋다. // 어떤회원이 회원가입을 했을 때 역할(ADMIN, USER 등) 
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate; // 만든 날짜
}
