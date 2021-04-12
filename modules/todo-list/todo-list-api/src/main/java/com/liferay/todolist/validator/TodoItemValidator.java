package com.liferay.todolist.validator;

import com.liferay.todolist.exception.TodoItemValidationException;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

public interface TodoItemValidator {

	public void validate(
			String title,
			Map<Locale, String> descriptionMap,
			Date dueDate) throws TodoItemValidationException;

	public void validate(
			String title,
			Map<Locale, String> descriptionMap,
			Date dueDate,
			double progress) throws TodoItemValidationException;
}
