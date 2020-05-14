package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.feedbackmanagementsystem.dao.CourseDao;
import com.cg.iter.feedbackmanagementsystem.dto.Course;

@Service
public class CourseService implements ICourseService {

	@Autowired
	private CourseDao courseDao;

	/**
	 * return all the course details
	 */
	@Override
	public List<Course> getAllCourse() {
		return courseDao.findAll();

	}
	/**
	 * used to update course
	 */
	@Override
	public String updateCourse(Course course) {
		Optional<Course> findById = courseDao.findById(course.getCourseId());

		if(course.getNoOfDays()<1) {
			return "Invalid no of days";
		}
		if(findById.isPresent()) {
			courseDao.save(course);
			return "Updated course";
		}
		return "Not Updated course";
		
	}

}
