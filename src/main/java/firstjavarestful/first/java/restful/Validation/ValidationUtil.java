package firstjavarestful.first.java.restful.Validation;

import org.springframework.stereotype.Component;

import javax.validation.*;
import java.util.Set;

@Component
public class ValidationUtil {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    public void validate(Object entity) throws ConstraintViolationException {
        Set<ConstraintViolation<Object>> violations = validator.validate(entity);
        if(violations.size() > 0){
            throw new ConstraintViolationException(violations);
        }

    }

}
