package com.one.Shout.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "CoachingDetails")
public class CoachingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String description;
	private String meta;
	private String democlasses;
	private String demoVedioUrl;
	private String parking;

	private Boolean isApproved;
	
	private String addressUrl;
	
	private String type;
	private String city;

	@JsonManagedReference
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "address_id")
	private CoachingAddress coachingAddress;

	@JsonManagedReference
	@OneToMany(mappedBy = "coachingDetails", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CoachingSubjectFee> coachingSubjectFee;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id")
	private CoachingContact coachingContact;

	private String password;
	
	private Integer noOfStudents;
	

}
