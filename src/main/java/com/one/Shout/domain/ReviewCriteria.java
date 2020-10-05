package com.one.Shout.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "criteriadetail")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ReviewCriteria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// Fix criteria name like clealiness ,value of money,fees,teacher quality
	private String criterianame;
	// value out of 5
	private String criteriaValue;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "reviewmain_id")
	@JsonBackReference
	private CoachingReviewmain coachingreviewmain;

}
