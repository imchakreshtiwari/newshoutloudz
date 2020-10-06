package com.one.Shout.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CoachingContact")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoachingContact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String phoneno;
	private String email;
	private String fblink;
	private String others;

}
