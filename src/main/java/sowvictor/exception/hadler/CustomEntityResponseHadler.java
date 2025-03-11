package sowvictor.exception.hadler;

import com.sun.source.tree.ReturnTree;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sowvictor.exception.ExecptionResponse;
import sowvictor.exception.UnsupportedMathOparationException;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomEntityResponseHadler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExecptionResponse> hadlerAllException(Exception ex, WebRequest request){

        ExecptionResponse response = new ExecptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }   @ExceptionHandler(UnsupportedMathOparationException.class)
    public final ResponseEntity<ExecptionResponse> hadlerBadRequestException(Exception ex, WebRequest request){

        ExecptionResponse response = new ExecptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
                return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}
