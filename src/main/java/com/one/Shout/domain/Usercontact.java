package com.one.Shout.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usercontact")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Usercontact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonProperty
	private String email;
	
	@JsonProperty
	private String phoneno;
	
	@JsonProperty
	@OneToOne
	@JoinColumn(name="userid")
	private Users user;
}