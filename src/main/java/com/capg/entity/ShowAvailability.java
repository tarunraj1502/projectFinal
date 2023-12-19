package com.capg.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class ShowAvailability {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="availability_id")
	private int availabilityId;
	
	@ManyToOne
	@JoinColumn(name = "show_id")
	@JsonBackReference(value = "show_id")
	private Show show;

	
	@ManyToOne
	@JoinColumn(name = "hall_id")
	@JsonBackReference(value = "hall_id")
	private Hall hall;

	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	@JsonBackReference(value = "movie_id")
	private Movie movie;

	
	@ManyToOne
	@JoinColumn(name = "seat_type_id")
	@JsonBackReference(value = "seat_type_id")
	private SeatType seatType;

	@Column(name="available_date")
	private LocalDate availableDate;
		
	@Column(name="remaining_seat")
	private int remainingSeat;

	public ShowAvailability() {
		super();
	}

	public ShowAvailability(int availabilityId, Show show, Hall hall, Movie movie, SeatType seatType, LocalDate availableDate,
			int remainingSeat) {
		super();
		this.availabilityId = availabilityId;
		this.show = show;
		this.hall = hall;
		this.movie = movie;
		this.seatType = seatType;
		this.availableDate = availableDate;
		this.remainingSeat = remainingSeat;
	}

	public int getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public LocalDate getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
	}

	public int getRemainingSeat() {
		return remainingSeat;
	}

	public void setRemainingSeat(int remainingSeat) {
		this.remainingSeat = remainingSeat;
	}

	@Override
	public String toString() {
		return "ShowAvailability [availabilityId=" + availabilityId + ", show=" + show + ", hall=" + hall + ", movie="
				+ movie + ", seatType=" + seatType + ", availableDate=" + availableDate + ", remainingSeat="
				+ remainingSeat + "]";
	}

	
	
	

}
