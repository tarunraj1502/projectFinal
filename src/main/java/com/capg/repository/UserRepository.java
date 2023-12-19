package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.User1;

public interface UserRepository extends JpaRepository<User1, Integer> {



	User1 findByUserId(int userId);

	User1 findByEmailId(String lowerCase);



	

}
