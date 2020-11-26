package firstjavarestful.first.java.restful.Controller;

import firstjavarestful.first.java.restful.error.NotFoundException;
import firstjavarestful.first.java.restful.error.UnAutorhizedException;
import firstjavarestful.first.java.restful.model.WebResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = ConstraintViolationException.class)
    public WebResponse<String> exceptionHandler(ConstraintViolationException constraintViolationException){
        return new WebResponse<String>(
                400,
                "BAD REQUEST",
                constraintViolationException.getMessage()
        );
    }

    @ExceptionHandler(value = NotFoundException.class)
    public WebResponse<String> notFound(NotFoundException e){
        return new WebResponse<String>(
                400,
                "NOT FOUND",
                "not found"
        );
    }

    @ExceptionHandler(value = UnAutorhizedException.class)
    public WebResponse<String> unauthorized(UnAutorhizedException e){
        return new WebResponse<String>(
                401,
                "NOT FOUND",
                "Please Input Your Secret Key"
        );
    }

}
