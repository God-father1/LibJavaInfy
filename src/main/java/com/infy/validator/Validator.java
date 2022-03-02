package com.infy.validator;

import java.time.LocalDate;
import java.time.Period;

import com.infy.dto.BookDTO;
import com.infy.exception.InfyBookException;

public class Validator {

	public static void validate(BookDTO bookDTO) throws InfyBookException {
		if(!validateYear(bookDTO.getPublishedYear())) {
			throw new InfyBookException("Validator.INVALID_YEAR");
		}
	}

	public static boolean validateYear(LocalDate year) {
		LocalDate now=LocalDate.now();
		Period period = Period.between(year, now);
		if(period.getYears()>0) {
			return true;
		}
		return false;
	}

}
