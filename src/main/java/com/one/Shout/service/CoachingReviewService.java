package com.one.Shout.service;

import java.util.List;

import com.one.Shout.domain.CoachingReviewmain;

public interface CoachingReviewService {

	public CoachingReviewmain addReview(CoachingReviewmain coachingReviewmain);
	
	public List<CoachingReviewmain> getCoachingReviewsByCityAndName(String coachngCity, String coachingName);
	
	public List<CoachingReviewmain> getAllReviews();
	
	public CoachingReviewmain reviewById(Long id);
	
	public List<CoachingReviewmain> coachingReviewByName(String coachingName);
	
	public CoachingReviewmain updateApproval(CoachingReviewmain coachingReviewmain);
	
	public CoachingReviewmain updateReview(CoachingReviewmain coachingReviewmain);
	
	public void deleteReview(Long id);
	
	public List<CoachingReviewmain> getRecentlyAddedReviews();
}
