package HyperQuiz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Product name exists.")
public class QuizNameExistsException extends RuntimeException {

	 private int statusCode;

	    public QuizNameExistsException() {
	        this.statusCode = 409;
	    }

	    public QuizNameExistsException(String message) {
	        super(message);
	        this.statusCode = 409;
	    }

	    public int getStatusCode() {
	        return statusCode;
	    }
	
}
