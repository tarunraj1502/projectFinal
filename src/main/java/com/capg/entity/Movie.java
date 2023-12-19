package com.capg.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Movie {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="movie_id")
private int movieId;

@Column(name="movie_name")
private String movieName;

@Column(name="genre")
private String genre;

@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
@JsonManagedReference(value="movie_id")
@JsonProperty(access=Access.WRITE_ONLY)
private List<Show> show;

public Movie() {
	super();
}

public Movie(int movieId, String movieName,String genre) {
	super();
	this.movieId = movieId;
	this.movieName = movieName;
	this.genre=genre;
}

public int getMovieId() {
	return movieId;
}

public void setMovieId(int movieId) {
	this.movieId = movieId;
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

@Override
public String toString() {
	return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", show=" + show + "]";
}



}
