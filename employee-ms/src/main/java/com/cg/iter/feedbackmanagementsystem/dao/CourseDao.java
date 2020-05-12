package com.cg.iter.feedbackmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.feedbackmanagementsystem.dto.Course;

@Repository
public interface CourseDao extends JpaRepository<Course,String> {

}
