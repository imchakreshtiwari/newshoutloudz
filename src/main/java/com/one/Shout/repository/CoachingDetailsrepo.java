package com.one.Shout.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.one.Shout.domain.CoachingDetails;

@Repository
public interface CoachingDetailsrepo extends CrudRepository<CoachingDetails, Long> {
	
	//CoachingDetails findByEmailAndPassword(String email, String password);

	public CoachingDetails findByName(String name);

	@Query(value = "select * from coaching_details where city=:city AND type=:type AND is_approved=:isApproved", nativeQuery = true)
	public List<CoachingDetails> getCoachingDetails(@Param("city") String city, @Param("type") String type, @Param("isApproved") Boolean isApproved);

	@Query(value = "select city from coaching_details where city LIKE %:city%", nativeQuery = true)
	public List<String> getCities(@Param("city") String city);

	@Query(value = "select id from coaching_details where city=:city AND name=:name", nativeQuery = true)
	public Long getCoachingid(@Param("city") String city, @Param("name") String name);
}
