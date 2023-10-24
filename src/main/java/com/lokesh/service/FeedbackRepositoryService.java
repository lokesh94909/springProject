package com.lokesh.service;

import java.util.List;

import com.lokesh.model.Feedback;

public interface FeedbackRepositoryService {
	
List<Feedback> getAllFeedbacks();
	
	Feedback saveFeedback(Feedback proposal);
	
//	Feedback getFeedbackById(Long id);
//	
//	//Feedback updateFeedback(Feedback proposal);
//	
//	void deleteFeedbackById(Long id);


}
