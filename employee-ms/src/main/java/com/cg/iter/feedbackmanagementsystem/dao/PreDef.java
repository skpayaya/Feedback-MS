package com.cg.iter.feedbackmanagementsystem.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.iter.feedbackmanagementsystem.dto.Course;
import com.cg.iter.feedbackmanagementsystem.dto.Enrollment;
import com.cg.iter.feedbackmanagementsystem.dto.Feedback;
import com.cg.iter.feedbackmanagementsystem.dto.Student;
import com.cg.iter.feedbackmanagementsystem.dto.Trainer;
import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;



@Component
public class PreDef {
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private FeedbackDao feedbackDao;
	@Autowired
	private TrainerDao trainerDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private TrainingProgramDao trainingProgramDao;
	@Autowired
	private EnrollmentDao enrollmentDao;

	@PostConstruct
	public void ad(){
		courseDao.save(new Course("C101","JAVA",12));
		courseDao.save(new Course("C102","C",12));


		Set<String> skillset=new HashSet<>();
		Set<String> skillset1=new HashSet<>();
		skillset.add("JAVA");
		skillset.add("C");
		trainerDao.save(new Trainer("TR1001","Sashi",skillset));
		skillset1.add("JAVA");
		skillset1.add("C");
		trainerDao.save(new Trainer("TR1002","Pradyumna",skillset1));

		studentDao.save( new Student("1","sashi","123"));
		studentDao.save( new Student("2","sashi1","123"));
		studentDao.save( new Student("3","sashi12","123"));
		studentDao.save( new Student("4","sashi123","123"));

		LocalDate today = LocalDate.now();
		LocalDate end = today.plus(30, ChronoUnit.DAYS);
		trainingProgramDao.save(new TrainingProgram("TP101",new Course("C101","",0), new Trainer("TR1001","",null), today,end));
		trainingProgramDao.save(new TrainingProgram("TP102",new Course("C102","",0),new Trainer("TR1002","",null), today,end));

		enrollmentDao.save(new Enrollment(new Student("1","",""),new TrainingProgram("TP101",null, null, null,null)));
		enrollmentDao.save(new Enrollment(new Student("1","",""),new TrainingProgram("TP102",null, null, null,null)));
		enrollmentDao.save(new Enrollment(new Student("2","",""),new TrainingProgram("TP101",null, null, null,null)));
		enrollmentDao.save(new Enrollment(new Student("2","",""),new TrainingProgram("TP102",null, null, null,null)));
		enrollmentDao.save(new Enrollment(new Student("3","",""),new TrainingProgram("TP101",null, null, null,null)));

		feedbackDao.save(new Feedback(
				new Student("1","",""),
				new TrainingProgram("TP101",null, null, null,null)
				,"5","2","3","4","4"));
		feedbackDao.save(new Feedback(
				new Student("2","",""),
				new TrainingProgram("TP102",null, null, null,null)
				,"5","2","5","4","5"));

	}

}

