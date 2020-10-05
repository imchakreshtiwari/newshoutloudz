package com.one.Shout.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coachingreviewmain")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CoachingReviewmain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String coachingname;
	private String coachingcity;
	private String coachingType;
	private String modeOfCoacing;
	
	private String reviewHeadLine;
	private String pros;
	private String cons;
	private String suggestions;

	private Boolean isApproved;

	private Integer overAllRating;
	@OneToMany(mappedBy = "coachingreviewmain", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<ReviewCriteria> reviewCriteria;
	
	private Boolean isAgrreeAllConditions;

	private Boolean isAnonymous;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private Users user;

}
