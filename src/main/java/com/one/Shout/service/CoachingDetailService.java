package com.one.Shout.service;

import java.util.List;

import com.one.Shout.domain.CoachingDetails;

public interface CoachingDetailService {

	public CoachingDetails addCoachingDetails(CoachingDetails coachingDetails);
	
	public List<String> getCitySuggestions(String city);
	
	public CoachingDetails getCoachingByCityAndName(String city, String name);
	
	public List<CoachingDetails> getCoachingDetailsByCityAndType(String city, String type);
	
	public List<CoachingDetails> getCoachingDetails();
	
	public CoachingDetails getCoachingDetailById(Long id);
	
	public void updateApproval(CoachingDetails coachingDetails);
	
	public CoachingDetails updateCoachingDetails(CoachingDetails coachingDetails);
	
	public void deleteCoachingDetail(Long id);
}
