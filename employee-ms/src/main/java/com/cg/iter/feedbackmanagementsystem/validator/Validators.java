package com.cg.iter.feedbackmanagementsystem.validator;

import java.util.Set;

import com.cg.iter.feedbackmanagementsystem.dto.Skills;
import com.cg.iter.feedbackmanagementsystem.dto.Trainer;

public class Validators {

	public static void validateSkill(Trainer trainer) {
		Set<String> skill = trainer.getSkill();

		for (String string : skill) {


			for (Skills skills : Skills.values()) {
				
			}
		}

	}

}
