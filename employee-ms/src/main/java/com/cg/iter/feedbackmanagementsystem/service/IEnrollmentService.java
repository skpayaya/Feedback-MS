package com.cg.iter.feedbackmanagementsystem.service;


public interface IEnrollmentService {

	/**
	 * used to enroll user to a training program
	 * takes id of user and program id to enroll in
	 * checks if already enrolled
	 * if already enrolled,return false
	 * if not enrolled,enrolls the user and return true
	 */
	boolean addEnrollment(int userId, String programId);

}
