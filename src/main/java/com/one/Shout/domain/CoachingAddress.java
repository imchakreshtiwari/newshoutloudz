package com.one.Shout.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CoachinhgAddress")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CoachingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String fullAddress;
	private String landmark;
	private String city;
	private String state;

	@JsonBackReference
	@OneToOne(mappedBy = "coachingAddress")
	private CoachingDetails coachingDetails;

}
