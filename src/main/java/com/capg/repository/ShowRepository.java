package com.capg.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.entity.Hall;
import com.capg.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Integer> {

	List<Show> findByHallAndSlotNoAndFromDateGreaterThanEqualAndToDateLessThanEqual(Hall hall, String slotNo,
			LocalDate fromDate, LocalDate toDate);

	@Query("SELECT s FROM Show s WHERE s.fromDate>=:fromDate AND s.toDate<=:toDate")
	List<Show> findShowsByDateRange(@Param("fromDate") LocalDate fromDate,@Param("toDate") LocalDate toDate);
}

	

	



