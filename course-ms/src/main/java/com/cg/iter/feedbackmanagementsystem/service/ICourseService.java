package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;

import com.cg.iter.feedbackmanagementsystem.dto.Course;

public interface ICourseService {


	List<Course> getAllCourse();


	String updateCourse(Course course);

}
