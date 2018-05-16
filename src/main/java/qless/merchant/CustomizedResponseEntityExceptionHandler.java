package qless.merchant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import qless.merchant.model.APIError;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<List<APIError>> handleUserNotFoundException(ConstraintViolationException ex, WebRequest request) {
		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		List<APIError> errors = new ArrayList<>();
		for (ConstraintViolation<?> constraintViolation : constraintViolations) {
			APIError apiError = new APIError(constraintViolation.getMessage());
			errors.add(apiError);
		}
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

}
