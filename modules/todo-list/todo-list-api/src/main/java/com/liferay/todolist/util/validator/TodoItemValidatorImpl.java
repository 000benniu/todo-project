package com.liferay.todolist.util.validator;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.todolist.exception.TodoItemValidationException;
import com.liferay.todolist.validator.TodoItemValidator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		service = TodoItemValidator.class)
public class TodoItemValidatorImpl implements TodoItemValidator {

	@Override
	public void validate(String title,
			Map<Locale, String> descriptionMap,
			Date dueDate) throws TodoItemValidationException {

		List<String> errors = new ArrayList<String>();

		if (!TodoItemValid(title, dueDate, errors)) {
			throw new TodoItemValidationException(errors);
		}
	}

	@Override
	public void validate(String title,
			Map<Locale, String> descriptionMap,
			Date dueDate,
			double progress) throws TodoItemValidationException {

		List<String> errors = new ArrayList<String>();

		if (!TodoItemValid(title, dueDate, progress, errors)) {
			throw new TodoItemValidationException(errors);
		}

	}

	private boolean TodoItemValid(String title,
			Date dueDate,
			double progress,
			List<String> errors) {

		boolean result = true;

		result &= isTitleValid(title, errors);
		result &= isDueDateValid(dueDate, errors);
		result &= isProgressValid(progress, errors);

		return result;
	}

	private boolean isProgressValid(double progress,
			List<String> errors) {

		boolean result = true;

		if (progress > 1 && progress < 0) {
			errors.add("ProgressOutOfScope");
			result = false;
		}

		return result;
	}

	private boolean TodoItemValid(String title,
			Date dueDate,
			List<String> errors) {
		boolean result = true;

		result &= isTitleValid(title, errors);
		result &= isDueDateValid(dueDate, errors);

		return result;
	}

	private boolean isDueDateValid(Date dueDate,
			List<String> errors) {

		boolean result = true;

		if (Validator.isNull(dueDate)) {
			errors.add("TodoDueDateNotSet");
			result = false;
		}

		return result;
	}

	private boolean isTitleValid(String title,
			List<String> errors) {
		boolean result = true;

		if (title.length() == 0) {
			errors.add("TitleEmpty");
			result = false;
		} else if (title.length() <= 3) {
			errors.add("TitleTooShort");
			result = false;
		}

		return result;
	}

}
