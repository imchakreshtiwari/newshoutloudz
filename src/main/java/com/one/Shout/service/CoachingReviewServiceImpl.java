package com.one.Shout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.Shout.domain.CoachingReviewmain;
import com.one.Shout.exception.RecordAlreadyExistException;
import com.one.Shout.repository.CoachingReviewmainRepo;

@Service
public class CoachingReviewServiceImpl implements CoachingReviewService{

	@Autowired
	private CoachingReviewmainRepo coachingReviewmainRepo;
	
	@Override
	public CoachingReviewmain addReview(CoachingReviewmain coachingReviewmain) {
		
		coachingReviewmain.setIsApproved(false);
		CoachingReviewmain coachingReviewmainobj = coachingReviewmainRepo.save(coachingReviewmain);
		if (coachingReviewmainobj == null) {
			throw new RecordAlreadyExistException("Record Not Saved in DB");
		}
		return coachingReviewmainobj;
	}
	
	@Override
	public List<CoachingReviewmain> getCoachingReviewsByCityAndName(String coachngCity, String coachingName) {
		
		return coachingReviewmainRepo.getCoachingReviews(coachngCity,coachingName, false);
	}
	
	@Override
	public List<CoachingReviewmain> getAllReviews() {
		
		return coachingReviewmainRepo.findAll();
	}
	
	@Override
	public CoachingReviewmain reviewById(Long id) {
		return coachingReviewmainRepo.findById(id).orElse(null);
	}
	
	@Override
	public List<CoachingReviewmain> coachingReviewByName(String coachingName){
		
		return coachingReviewmainRepo.findBycoachingname(coachingName);
	}
	
	@Override
	public CoachingReviewmain updateApproval(CoachingReviewmain coachingReviewmain) {
		
		CoachingReviewmain coachingReviewObj = coachingReviewmainRepo.findById(coachingReviewmain.getId()).orElse(null);
		coachingReviewObj.setIsApproved(coachingReviewmain.getIsApproved());
		CoachingReviewmain coachingreviewobjResponse = coachingReviewmainRepo.save(coachingReviewObj);
		return coachingreviewobjResponse;
		
	}
	
	@Override
	public CoachingReviewmain updateReview(CoachingReviewmain coachingReviewmain) {
		
		CoachingReviewmain coachingReviewObj = coachingReviewmainRepo.findById(coachingReviewmain.getId()).orElse(null);
		CoachingReviewmain coachingreviewobjResponse = null;
		if (coachingReviewObj != null) {
			coachingReviewObj.setCoachingname(coachingReviewmain.getCoachingname());
			coachingReviewObj.setReviewHeadLine(coachingReviewmain.getReviewHeadLine());
			coachingReviewObj.setPros(coachingReviewmain.getPros());
			coachingReviewObj.setCons(coachingReviewmain.getCons());
			coachingReviewObj.setSuggestions(coachingReviewmain.getSuggestions());
			coachingReviewObj.setOverAllRating(coachingReviewmain.getOverAllRating());
			coachingreviewobjResponse = coachingReviewmainRepo.save(coachingReviewObj);
		}

		return coachingreviewobjResponse;
	}
	
	@Override
	public void deleteReview(Long id) {
		
		coachingReviewmainRepo.deleteById(id);
	}
	
	@Override
	public List<CoachingReviewmain> getRecentlyAddedReviews(){
		
		return coachingReviewmainRepo.getRecentlyAddedReviews();
	}
}
