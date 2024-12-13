package vn.techzen.academy_pnv_25;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CalculatorController {

    @GetMapping("/calculator")
    public ResponseEntity<String> calculate(
            @RequestParam(value = "firstNumber", required = true) String firstNumberStr,
            @RequestParam(value = "secondNumber", required = true) String secondNumberStr,
            @RequestParam(value = "operator", required = true) String operator) {

        // Validate and parse input numbers
        Optional<Double> firstNumberOpt = parseDouble(firstNumberStr);
        Optional<Double> secondNumberOpt = parseDouble(secondNumberStr);

        if (firstNumberOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("First number must be numeric.");
        }

        if (secondNumberOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Second number must be numeric.");
        }

        double firstNumber = firstNumberOpt.get();
        double secondNumber = secondNumberOpt.get();
        double result;

        // Perform calculation based on operator
        switch (operator) {
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "*" -> result = firstNumber * secondNumber;
            case "/" -> {
                if (secondNumber == 0) {
                    return ResponseEntity.badRequest().body("Division by zero is not allowed.");
                }
                result = firstNumber / secondNumber;
            }
            default -> {
                return ResponseEntity.badRequest().body("Invalid operator. Supported operators are: +, -, *, /.");
            }
        }

        return ResponseEntity.ok("Result: " + result);
    }

    // Utility method to validate and parse a string into a double
    private Optional<Double> parseDouble(String str) {
        try {
            return Optional.of(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
