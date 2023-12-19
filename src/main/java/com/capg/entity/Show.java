package com.capg.entity;

import java.time.LocalDate;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Show {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "show_id")
	private int showId;

	@Column(name = "slot_no")
	private String slotNo;

	@Column(name = "from_date")
	private LocalDate fromDate;

	@Column(name = "to_date")
	private LocalDate toDate;

	@ManyToOne
	@JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
	@JsonBackReference(value = "movie_id")
	private Movie movie;

	@ManyToOne
	@JoinColumn(name="hall_id",referencedColumnName = "hall_id")
	@JsonBackReference(value="hall_id")
	private Hall hall;

	public Show() {
		super();
	}

	public Show(int showId, String slotNo, LocalDate fromDate, LocalDate toDate, Movie movie, Hall hall) {
		super();
		this.showId = showId;
		this.slotNo = slotNo;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.movie = movie;
		this.hall = hall;
	}

	public Show(int i, int j, LocalDate fromDate2, LocalDate toDate2) {
		
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public String getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

//	@Override
//	public String toString() {
//		return "Show [showId=" + showId + ", slotNo=" + slotNo + ", fromDate=" + fromDate + ", toDate=" + toDate
//				+ ", movie=" + movie + ", hall=" + hall + "]";
//	}





	}