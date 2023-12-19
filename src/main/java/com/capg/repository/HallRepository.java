package com.capg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Hall;

public interface HallRepository extends JpaRepository<Hall, Integer> {


	Optional<Hall> findByhallDescriptionIgnoreCase(String hallDescription);

	

}
