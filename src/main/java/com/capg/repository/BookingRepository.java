package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
