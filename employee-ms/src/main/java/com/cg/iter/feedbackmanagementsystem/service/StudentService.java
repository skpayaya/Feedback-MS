package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.feedbackmanagementsystem.dao.StudentDao;
import com.cg.iter.feedbackmanagementsystem.dto.Student;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentDao studentDao;


	@Override
	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}
}
