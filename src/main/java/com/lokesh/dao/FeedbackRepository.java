package com.lokesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lokesh.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
