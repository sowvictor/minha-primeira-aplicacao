package sowvictor.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sowvictor.exception.UnsupportedMathOparationException;

@RestController
@RequestMapping("/math")
public class MathController {

    //http:localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
           @PathVariable("numberOne") String numberOne,
           @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne)||!isNumeric(numberTwo)) throw new UnsupportedMathOparationException("please set a numeric value!");
        return convertToDouble (numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) throws Exception {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOparationException("please set a numeric value!");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);

    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())return false;
        String number = strNumber.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }




    //http:localhost:8080/math/subtraction/3/5
    //http:localhost:8080/math/division/3/5

}
