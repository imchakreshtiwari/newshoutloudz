package com.one.Shout.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.one.Shout.domain.CoachingReviewmain;

@Repository
public interface CoachingReviewmainRepo  extends JpaRepository<CoachingReviewmain, Long>{

	public List<CoachingReviewmain> findBycoachingname(String coachingname);
	
	@Query(value ="select * from coachingreviewmain where coachingcity=:coachingcity AND coachingname=:coachingname AND is_approved=:isApproved",nativeQuery = true)
	public List<CoachingReviewmain> getCoachingReviews(@Param("coachingcity") String coachingcity,@Param("coachingname") String coachingname, @Param("isApproved") Boolean isApproved);

	@Query(value = "SELECT * FROM coachingreviewmain ORDER BY id DESC LIMIT 10", nativeQuery = true)
	public List<CoachingReviewmain> getRecentlyAddedReviews();

}
