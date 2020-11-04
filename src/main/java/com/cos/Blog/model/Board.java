package com.cos.Blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob//대용량 데이터
	private String content; //섬머 노트 라이브러리 <html>태그가 섞여서 디자인 됨.
	
	@ColumnDefault("0")
	private int count;//조회수
		
	//private int userId; //DB는 오브젝트를 저장할 수 없다. 외부키는 자바는 오브젝트를 저장할 수 있다. 이렇게 사용불가
	@ManyToOne(fetch = FetchType.EAGER) //Board 와 user와의 관계 Many == Board , one == user -> 많은 유저가 여러개의 게시글 쓸 수 있음.
	@JoinColumn(name = "userId")
	private User user;// JPA가 자동으로 해줌;
	
	@OneToMany(mappedBy = "board",fetch = FetchType.EAGER) //mappedBy 연관관계의 주인이 아니다(난 FK가 아니에요) DB에 컬럼 만들지 마세요//board 는 reply 클래스에 만든 객체 이름을 넣은 거임
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
