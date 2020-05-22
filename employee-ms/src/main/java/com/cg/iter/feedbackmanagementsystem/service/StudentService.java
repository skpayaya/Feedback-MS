package com.cg.iter.feedbackmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.feedbackmanagementsystem.dao.UserDao;
import com.cg.iter.feedbackmanagementsystem.dto.User;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private UserDao userDao;


	/**
	 * returns the list of all the students
	 */
	@Override
	public List<User> getAllStudents() {
		 List<User> studentList = userDao.findAll();
		 List<User> returnList = new ArrayList<>();
		 for (User user : studentList) {
			if(user.getRoles().contains("ROLE_STUDENT")) {
				returnList.add(user);
			}
		}
		 return returnList;
		 
		
	}
}
