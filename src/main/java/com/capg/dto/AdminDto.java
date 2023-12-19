package com.capg.dto;

public class AdminDto {
	private String addMovieUrl;
	private String deleteMovieUrl;
	private String publishMovieListUrl;
	private String addHallUrl;
	private String deleteHallUrl;
	private String addShowUrl;
	private String deleteShowUrl;
	private String updateShowUrl;
	private String addSeatTypeUrl;
	private String deletetseatTypeUrl;
	private String addShowAvailabilityUrl;
	private String deleteShowAvailabilityUrl;
	private String earningReportUrl;
	private int userId;
	private char usertype;
	
	
	
	public AdminDto(String addMovie, String deleteMovie,String publishMovieList, String addHall, String deleteHall, String addShow,
			String deleteShow, String updateShow, String addSeatType, String deletetseatType,
			String addShowAvailability, String deleteShowAvailability, String earningReport, int userId,
			char usertype) {
		super();
		this.addMovieUrl = addMovie;
		this.deleteMovieUrl = deleteMovie;
		this.publishMovieListUrl=publishMovieList;
		this.addHallUrl = addHall;
		this.deleteHallUrl = deleteHall;
		this.addShowUrl = addShow;
		this.deleteShowUrl = deleteShow;
		this.updateShowUrl = updateShow;
		this.addSeatTypeUrl = addSeatType;
		this.deletetseatTypeUrl = deletetseatType;
		this.addShowAvailabilityUrl = addShowAvailability;
		this.deleteShowAvailabilityUrl = deleteShowAvailability;
		this.earningReportUrl = earningReport;
		this.userId = userId;
		this.usertype = usertype;
	}
	
	public AdminDto()
	{
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
		this.usertype='A';
		this.addMovieUrl="localhost:9080/api/v1/admin/addMovie";
		this.deleteMovieUrl="localhost:9080/api/v1/admin/movie/{movieId}";
		this.publishMovieListUrl="localhost:9080/api/v1/admin/getAllMovie";
		this.addHallUrl="localhost:9080/api/v1/admin/addHall";
		this.deleteHallUrl="localhost:9080/api/v1/admin/getHall/{hallId}";
		this.addShowUrl="localhost:9080/api/v1/admin/addShow";
		this.deleteShowUrl="localhost:9080/api/v1/admin/shows/{showId}";
		this.updateShowUrl="localhost:9080/api/v1/admin/show/{showId}";
		this.addSeatTypeUrl="localhost:9080/api/v1/admin/addSeatType";
		this.deletetseatTypeUrl="localhost:9080/api/v1/admin/seatType/{seatId}";
		this.addShowAvailabilityUrl="localhost:9080/api/v1/admin/addShowAvail";
		this.deleteShowAvailabilityUrl="localhost:9080/api/v1/admin/showAvail/{availId}";
		this.earningReportUrl="localhost:9080/api/v1/admin/admin/earningReport";
	}
	public char getUsertype() {
		return usertype;
	}
	public void setUsertype(char usertype) {
		this.usertype = usertype;
	}
	public String getAddMovie() {
		return addMovieUrl;
	}
	public void setAddMovie(String addMovie) {
		this.addMovieUrl = addMovie;
	}
	public String getDeleteMovie() {
		return deleteMovieUrl;
	}
	public void setDeleteMovie(String deleteMovie) {
		this.deleteMovieUrl = deleteMovie;
	}
	public String getAddHall() {
		return addHallUrl;
	}
	public void setAddHall(String addHall) {
		this.addHallUrl = addHall;
	}
	public String getDeleteHall() {
		return deleteHallUrl;
	}
	public void setDeleteHall(String deleteHall) {
		this.deleteHallUrl = deleteHall;
	}
	public String getAddShow() {
		return addShowUrl;
	}
	public void setAddShow(String addShow) {
		this.addShowUrl = addShow;
	}
	public String getDeleteShow() {
		return deleteShowUrl;
	}
	public void setDeleteShow(String deleteShow) {
		this.deleteShowUrl = deleteShow;
	}
	public String getUpdateShow() {
		return updateShowUrl;
	}
	public void setUpdateShow(String updateShow) {
		this.updateShowUrl = updateShow;
	}
	public String getAddSeatType() {
		return addSeatTypeUrl;
	}
	public void setAddSeatType(String addSeatType) {
		this.addSeatTypeUrl = addSeatType;
	}
	public String getDeletetseatType() {
		return deletetseatTypeUrl;
	}
	public void setDeletetseatType(String deletetseatType) {
		this.deletetseatTypeUrl = deletetseatType;
	}
	public String getAddShowAvailability() {
		return addShowAvailabilityUrl;
	}
	public void setAddShowAvailability(String addShowAvailability) {
		this.addShowAvailabilityUrl = addShowAvailability;
	}
	public String getDeleteShowAvailability() {
		return deleteShowAvailabilityUrl;
	}
	public void setDeleteShowAvailability(String deleteShowAvailability) {
		this.deleteShowAvailabilityUrl = deleteShowAvailability;
	}
	public String getEarningReport() {
		return earningReportUrl;
	}
	public void setEarningReport(String earningReport) {
		this.earningReportUrl = earningReport;
	}
	public String getPublishMovieListUrl() {
		return publishMovieListUrl;
	}
	public void setPublishMovieListUrl(String publishMovieListUrl) {
		this.publishMovieListUrl = publishMovieListUrl;
	}
	
}
