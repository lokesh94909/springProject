package com.lokesh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lokesh.dao.FeedbackRepository;
import com.lokesh.model.Feedback;
import com.lokesh.model.Feedback;
import com.lokesh.service.FeedbackRepositoryService;


@Service
public class FeedbackRepositoryServiceImpl implements FeedbackRepositoryService {

private FeedbackRepository feedbackRepository;
	
	public FeedbackRepositoryServiceImpl(FeedbackRepository feedbackRepository) {
		super();
		this.feedbackRepository = feedbackRepository;
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackRepository.findAll();
	}

	@Override
	public Feedback saveFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

//	@Override
//	public Feedback getFeedbackById(Long id) {
//		return feedbackRepository.findById(id).get();
//	}
//
//	//@Override
//	//public Feedback updateFeedback(Feedback feedback) {
//		//return feedbackRepository.save(feedback);
//	//}
//
//	@Override
//	public void deleteFeedbackById(Long id) {
//		feedbackRepository.deleteById(id);	
//	}
	
}
