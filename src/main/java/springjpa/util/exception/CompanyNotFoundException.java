package springjpa.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends RuntimeException {

    public CompanyNotFoundException(Object value) {
        super(String.format("Company not found with id : '%s'", value));
    }
}
