package com.capg.dto;

import java.time.LocalDate;

import com.capg.entity.Hall;

public class MovieDto 
{
	private String movieName;
	private String genre;
	private String slotNo;
	private LocalDate fromDate;
	private LocalDate toDate;
	
	public MovieDto()
	{
		
	}
	public MovieDto(String movieName, String genre, String slotNo, LocalDate fromDate, LocalDate toDate) {
		super();
		this.movieName = movieName;
		this.genre = genre;
		this.slotNo = slotNo;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
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
	@Override
	public String toString() {
		return "MovieDto [movieName=" + movieName + ", genre=" + genre + ", slotNo=" + slotNo + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}
	
}
