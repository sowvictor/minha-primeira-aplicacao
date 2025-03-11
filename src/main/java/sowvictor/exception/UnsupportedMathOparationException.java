package sowvictor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOparationException extends RuntimeException {
    public UnsupportedMathOparationException(String message) {
        super(message);
    }
}
