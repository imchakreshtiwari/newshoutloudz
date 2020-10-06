package com.one.Shout.controller;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.one.Shout.domain.CoachingDetails;
import com.one.Shout.domain.MailData;
import com.one.Shout.service.CoachingDetailService;
import com.one.Shout.service.SendMailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/rest")
public class CoachingDetailController {

	@Autowired
	private CoachingDetailService coachingDetailService;
	
	@Autowired
	private SendMailService sendMailService;

	@RequestMapping("/env")
	public @ResponseBody Map<String, String> env() {
	    return System.getenv();
	}
	
	@PostMapping(value = "/coachingdetails")
	public CoachingDetails addCoachingDetails(@RequestBody CoachingDetails coachingDetails) {
	
		log.info("Calling api to add coaching details");
		
		return coachingDetailService.addCoachingDetails(coachingDetails);
	}
	
    //get city suggestions
	@GetMapping(value = "/coachingdetails/citysuggestion/{city}")
	public List<String> getCityList(@PathVariable("city") String city) {
		log.info("Calling api to get city suggesstions");
		
		return coachingDetailService.getCitySuggestions(city);
	}

	@GetMapping(value = "/coachingdetailsByCityAndName/{city}/{name}")
	public CoachingDetails getCoachingid(@PathVariable("city") String city, @PathVariable("name") String name) {
		
		log.info("Calling api to get coaching by city and name");
		
		return coachingDetailService.getCoachingByCityAndName(city, name);
	}

	// Get detail by city and type
	@GetMapping(value = "/coachingdetailsByCityAndType/{city}/{type}")
	public List<CoachingDetails> detailByCityandName(@PathVariable("city") String city, @PathVariable("type") String type) {
		
		log.info("Calling api to get All coachings by city and type");
		return coachingDetailService.getCoachingDetailsByCityAndType(city, type);
	}

	@GetMapping(value = "/coachingdetails")
	public List<CoachingDetails> getCoachingDetails() {
		
		log.info("Calling api to get All coachings");
		return coachingDetailService.getCoachingDetails();
	}

	@GetMapping(value = "/coachingdetails/{id}")
	public CoachingDetails getCoachingDetailsById(@PathVariable("id") Long id) {
		
		log.info("Calling api to get coaching By id");
		return coachingDetailService.getCoachingDetailById(id);
	}


	@PutMapping(value = "/coachingdetails/approval")
	public void updateStatus(@RequestBody CoachingDetails coachingDetails) {
		try {
			
			log.info("Calling api to update coaching status Approve/Reject");
			coachingDetailService.updateApproval(coachingDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PutMapping(value = "/coachingdetails")
	public CoachingDetails updateDetail(@RequestBody CoachingDetails coachingDetails) {

		CoachingDetails coachingDetailsResponse = null;
		try {
			
			log.info("Calling api to update coaching by id");
			coachingDetailsResponse = coachingDetailService.updateCoachingDetails(coachingDetails);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return coachingDetailsResponse;
	}

	@DeleteMapping(value = "/coachingdetails/{id}")
	public void deleteDetail(@PathVariable("id") Long id) {

		try {
			coachingDetailService.deleteCoachingDetail(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostMapping(value = "/sendMail/{to}")
	public ResponseEntity<String> mailsent(HttpSession session, @RequestBody MailData mailData,
			@PathVariable("to") String to) {
		String subject = "Enquiry Mail From ShoutLoudz";
		String body = "Hi , My Name is  "+mailData.getName() + "    And  My Contact Number  is   " + mailData.getMno() + "    and email is   "
				 + mailData.getFrom()+ "  And  My Query is   ===    " + mailData.getQuery() + "   Thanks from Shoutloudz";
		
		try {
			sendMailService.sendingMail(to, subject, body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("Email Sent Successfully! Will Contact You Soon ");

	}
	
	@GetMapping(value = "/coachingdetails/recent")
	public List<CoachingDetails> getRecentCoachings(){
		
		log.info("Calling api to get recently added Coachings");
		return coachingDetailService.getRecentCoachings();
	}
}
