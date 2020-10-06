package com.one.Shout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.Shout.domain.CoachingDetails;
import com.one.Shout.exception.RecordNotFoundException;
import com.one.Shout.repository.CoachingDetailsrepo;

@Service
public class CoachingDetailServiceImpl implements CoachingDetailService {

	@Autowired
	private CoachingDetailsrepo coachingDetailsrepo;

	@Override
	public CoachingDetails addCoachingDetails(CoachingDetails coachingDetails) {

		CoachingDetails coachingDetailsobj = null;
		try {
			coachingDetails.setIsApproved(false);
			coachingDetailsobj = coachingDetailsrepo.save(coachingDetails);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return coachingDetailsobj;
	}

	@Override
	public List<String> getCitySuggestions(String city) {

		List<String> coachingNames = coachingDetailsrepo.getCities(city);
		if (coachingNames.isEmpty()) {
			throw new RecordNotFoundException("No Suggestion Found");
		}
		return coachingNames;
	}

	@Override
	public CoachingDetails getCoachingByCityAndName(String city, String name) {

		Long coachingid = coachingDetailsrepo.getCoachingid(city, name);
		if (coachingid == null) {
			throw new RecordNotFoundException("No Data Found");
		}
		return coachingDetailsrepo.findById(coachingid).orElse(null);
	}

	@Override
	public List<CoachingDetails> getCoachingDetailsByCityAndType(String city, String type) {

		List<CoachingDetails> coachingDetails = coachingDetailsrepo.getCoachingDetails(city, type, true);
		if (coachingDetails.isEmpty()) {
			throw new RecordNotFoundException("No Coaching Found For Selected City and Type");
		}
		return coachingDetails;
	}

	@Override
	public List<CoachingDetails> getCoachingDetails() {

		return (List<CoachingDetails>) coachingDetailsrepo.findAll();
	}

	@Override
	public CoachingDetails getCoachingDetailById(Long id) {

		return coachingDetailsrepo.findById(id).orElse(null);
	}

	@Override
	public void updateApproval(CoachingDetails coachingDetails) {

		CoachingDetails coachingdetail = coachingDetailsrepo.findById(coachingDetails.getId()).orElse(null);
		coachingdetail.setIsApproved(coachingDetails.getIsApproved());
		coachingDetailsrepo.save(coachingdetail);
	}

	@Override
	public CoachingDetails updateCoachingDetails(CoachingDetails coachingDetails) {

		CoachingDetails coachingdetail = coachingDetailsrepo.findById(coachingDetails.getId()).orElse(null);
		if (coachingdetail != null) {
			coachingdetail.setCoachingAddress(coachingDetails.getCoachingAddress());
			coachingdetail.setCoachingContact(coachingDetails.getCoachingContact());
			coachingdetail.setType(coachingDetails.getType());
			coachingdetail.setDescription(coachingDetails.getDescription());
			coachingdetail.setCity(coachingDetails.getCity());
			coachingdetail.setName(coachingDetails.getName());
		}

		return coachingDetailsrepo.save(coachingdetail);

	}

	@Override
	public void deleteCoachingDetail(Long id) {

		coachingDetailsrepo.deleteById(id);
	}

	@Override
	public List<CoachingDetails> getRecentCoachings() {
		return coachingDetailsrepo.getRecentlyAddedCoachings();
	}

}
