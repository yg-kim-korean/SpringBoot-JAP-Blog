package com.cos.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.Blog.model.User;

//Data Access Object(DAO)
// 자동으로 bin으로 등록이 된다.
//@Repository --> 생략가능해짐.
public interface UserRepository extends JpaRepository<User, Integer>{//user 테이블이 관리하는 테이블/ 프라이머리 키가 integer다
	
}
