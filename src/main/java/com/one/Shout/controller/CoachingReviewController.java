package com.one.Shout.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.one.Shout.domain.CoachingReviewmain;
import com.one.Shout.service.CoachingReviewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/rest")
public class CoachingReviewController {

	@Autowired
	private CoachingReviewService coachingReviewService;

	@PostMapping(value = "/coachingReview")
	public CoachingReviewmain addCoachingReview(@RequestBody CoachingReviewmain coachingReviewmain) {

		CoachingReviewmain coachingReviewmainResponse = null;
		try {

			log.info("Calling Api to add coaching Review");
			coachingReviewmainResponse = coachingReviewService.addReview(coachingReviewmain);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return coachingReviewmainResponse;
	}

	// Get coaching review based on name and city response can be list or one based
	// on that user can select.
	@GetMapping(value = "/coachingReview/{coachingcity}/{coachingname}")
	public List<CoachingReviewmain> reviewByCityandName(@PathVariable("coachingcity") String coachingCity,
			@PathVariable("coachingname") String coachingName) {

		log.info("Calling get coaching Reviews by caoching city and name");
		return coachingReviewService.getCoachingReviewsByCityAndName(coachingCity, coachingName);
	}

	@GetMapping(value = "/coachingReview")
	public List<CoachingReviewmain> geAllReviews() {

		log.info("Calling API to get all coaching Reviews");
		return coachingReviewService.getAllReviews();
	}

	@GetMapping(value = "/coachingReviewById/{id}")
	public CoachingReviewmain getCoachingReviewById(@PathVariable("id") Long id) {

		log.info("Calling API to get coaching Review By id");
		return coachingReviewService.reviewById(id);
	}

	@GetMapping(value = "/coachingReview/{coachingname}")
	public List<CoachingReviewmain> getCoachingDetailsById(@PathVariable("coachingname") String coachingName) {

		log.info("Calling API to get coaching Review By coaching Name");
		return coachingReviewService.coachingReviewByName(coachingName);
	}

	@PutMapping(value = "/coachingReview/status")
	public CoachingReviewmain updateStatus(@RequestBody CoachingReviewmain coachingReviewmain) {

		CoachingReviewmain coachingReview = null;
		try {

			log.info("Calling API to update approval status");
			coachingReview = coachingReviewService.updateApproval(coachingReviewmain);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coachingReview;
	}

	@PutMapping(value = "/coachingReview")
	public CoachingReviewmain updateDetail(@RequestBody CoachingReviewmain coachingReviewmain) {
		CoachingReviewmain coachingReviewmainResponse = null;
		try {

			log.info("Calling API to update coaching review.");
			coachingReviewmainResponse = coachingReviewService.updateReview(coachingReviewmain);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coachingReviewmainResponse;
	}

	@DeleteMapping(value = "/coachingReview/{id}")
	public ResponseEntity<String> deleteDetail(@PathVariable("id") Long id) {

		try {
			log.info("Calling API to delete coaching review.");
			coachingReviewService.deleteReview(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("Coaching review Deleted");
	}

	@GetMapping(value = "/coachingReview/recent")
	public List<CoachingReviewmain> getRecentlyAddedReviews() {
		return coachingReviewService.getRecentlyAddedReviews();
	}

}
