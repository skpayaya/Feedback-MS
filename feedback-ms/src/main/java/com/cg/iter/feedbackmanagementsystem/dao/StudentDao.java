package com.cg.iter.feedbackmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.feedbackmanagementsystem.dto.Student;

@Repository
public interface StudentDao extends JpaRepository<Student,String>{

}
