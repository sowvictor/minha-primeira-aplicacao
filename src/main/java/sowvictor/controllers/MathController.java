package sowvictor.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sowvictor.exception.UnsupportedMathOparationException;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {

    //http:localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOparationException("please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    //http:localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOparationException("please set a numeric value!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }


    //http  :localhost:8080/math/multplication/3/5
    @RequestMapping("/multplication/{numberOne}/{numberTwo}")
    public Double multplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOparationException("please set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    //http:localhost:8080/math/division/3/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOparationException("please set a numeric value!");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }
    //http:localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOparationException("please set a numeric value!");
        return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
    }
    //http:localhost:8080/math/squareroot/81
    @RequestMapping("/squareroot/{number}")
    public Double squareroot(
            @PathVariable("number") String number
    ) throws Exception {
        if (!isNumeric(number))
            throw new UnsupportedMathOparationException("please set a numeric value!");
        return Math.sqrt(convertToDouble(number));
    }

    private Double convertToDouble(String strNumber) throws Exception {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOparationException("please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);

    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


}




