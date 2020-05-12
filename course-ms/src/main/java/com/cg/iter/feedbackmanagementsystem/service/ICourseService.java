package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;

import com.cg.iter.feedbackmanagementsystem.dto.Course;

public interface ICourseService {


	Course addCourse(Course course);

	List<Course> getAllCourse();

	String updateCourse(Course course);


	void deleteCourse(String id);

	Course getCourseDetails(String id);

}
