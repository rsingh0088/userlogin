package com.login.exchange.userlogin.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.login.exchange.userlogin.entity.Usr;

@Repository
public interface UserRepository extends JpaRepository<Usr, Integer> {

	Usr findByUserName(String userName);

	@Transactional
	@Modifying
	@Query(value="update USR set LOGIN_KEY=?2 where USER_NAME=?1", nativeQuery=true)
	void updateLoginKey(String userName, String loginKey);

}
