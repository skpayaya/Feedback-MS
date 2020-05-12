package com.cg.iter.feedbackmanagementsystem.validator;

import com.cg.iter.feedbackmanagementsystem.dto.Feedback;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidFeedbackException;

public class FeedbackValidators {

	public static boolean validateRating(Feedback feedback) throws InvalidFeedbackException {

		if(!(feedback.getCriteriaFirst().equals("1") || feedback.getCriteriaFirst().equals("2") ||feedback.getCriteriaFirst().equals("3") || feedback.getCriteriaFirst().equals("4")  || feedback.getCriteriaFirst().equals("5")))
			throw new InvalidFeedbackException("Invalid rating");
		if(!(feedback.getCriteriaSecond().equals("1") || feedback.getCriteriaSecond().equals("2") ||feedback.getCriteriaSecond().equals("3")  || feedback.getCriteriaSecond().equals("4") || feedback.getCriteriaSecond().equals("5")))
			throw new InvalidFeedbackException("Invalid rating");
		if(!(feedback.getCriteriaThird().equals("1")|| feedback.getCriteriaThird().equals("2") ||feedback.getCriteriaThird().equals("3")  || feedback.getCriteriaThird().equals("4") || feedback.getCriteriaThird().equals("5")))
			throw new InvalidFeedbackException("Invalid rating");
		if(!(feedback.getCriteriaFourth().equals("1") || feedback.getCriteriaFourth().equals("2") ||feedback.getCriteriaFourth().equals("3")  || feedback.getCriteriaFourth().equals("4")|| feedback.getCriteriaFourth().equals("5")))
			throw new InvalidFeedbackException("Invalid rating");
		if(!(feedback.getCriteriaFifth().equals("1") || feedback.getCriteriaFifth().equals("2") ||feedback.getCriteriaFifth().equals("3")  || feedback.getCriteriaFifth().equals("4")|| feedback.getCriteriaFifth().equals("5")))
			throw new InvalidFeedbackException("Invalid rating");


		return true;

	}
}
