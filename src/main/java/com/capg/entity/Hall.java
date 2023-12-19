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
public class Hall {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hall_id")
	private int hallId;
	
	@Column(name="hall_desc")
	private String hallDescription;
	
	@Column(name="total_capacity")
	private int totalCapacity;
	
    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    @JsonManagedReference(value="hall_id")
    @JsonProperty(access=Access.WRITE_ONLY)
    private List<Show> show;

    
	public Hall() {
	}

	public Hall(int hallId, String hallDescription, int totalCapacity,  List<Show> show) {
		super();
		this.hallId = hallId;
		this.hallDescription = hallDescription;
		this.totalCapacity = totalCapacity;
		this.show = show;
	}





	public int getHallId() {
		return hallId;
	}


	public void setHallId(int hallId) {
		this.hallId = hallId;
	}


	public String getHallDescription() {
		return hallDescription;
	}


	public void setHallDescription(String hallDescription) {
		this.hallDescription = hallDescription;
	}


	public int getTotalCapacity() {
		return totalCapacity;
	}


	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}


	public List<Show> getShow() {
		return show;
	}


	public void setShow(List<Show> show) {
		this.show = show;
	}
	
	@Override
	public String toString() {
		return "Hall [hallId=" + hallId + ", hallDescription=" + hallDescription + ", totalCapacity=" + totalCapacity
				+ ", show=" + show + "]";
	}
	
	

}