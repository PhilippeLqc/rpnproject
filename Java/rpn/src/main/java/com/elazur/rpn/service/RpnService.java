package com.elazur.rpn.service;

import org.springframework.stereotype.Service;
import java.util.Stack;

@Service
public class RpnService {
    public String transformToRpn(String expressionToTransform) {

        // Remove double quotes from the expression
        expressionToTransform = expressionToTransform.replace("\"", "");
        //verify if expressionToTransform is a valid expression
        if (expressionToTransform.isEmpty()) {
            return "Expression invalide. Doit contenir au moins deux nombres et un opérateur, ou un nombre et un opérateur sqrt.";
        }
        //split the expression into tokens using space as delimiter and store them in an array.
        String[] tokens = expressionToTransform.split("\\s+");

        //initialize the stack
        Stack<Double> stack = new Stack<>();

        if (tokens.length < 2) {
            return "Expression invalide. Doit contenir au moins deux nombres et un opérateur, ou un nombre et un opérateur sqrt.";
        }

        for (String token: tokens) {
            //verify if token is a number first
            if (isValidNumber(token)) {
                //push the number to the stack if it's a number
                stack.push(Double.parseDouble(token));
            } else if (isValidOperator(token)){
                //verify if token is an sqrt operator
                if (token.equals("sqrt")) {
                    // if true, verify if stack is empty
                    if (stack.isEmpty()) {
                        // empty ? return error message
                        return "Expression invalide. Doit contenir au moins deux nombres et un opérateur, ou un nombre et un opérateur sqrt.";
                    }
                    //pop the number from the stack and push the square root of the number to the stack
                    Double operand = stack.pop();
                    stack.push(Math.sqrt(operand));
                } else {
                    // if stack size is less than 2, return error message
                    if (stack.size() < 2) {
                        return "Expression invalide. Doit contenir au moins deux nombres et un opérateur, ou un nombre et un opérateur sqrt.";
                    }

                    Double recentNumber = stack.pop(); // last number pushed to the stack
                    Double previousNumber = stack.pop(); // second last number pushed to the stack

                    switch (token) {
                        case "+":
                            stack.push(recentNumber + previousNumber);
                            break;
                        case "-":
                            stack.push(previousNumber - recentNumber);
                            break;
                        case "*":
                            stack.push(recentNumber * previousNumber);
                            break;
                        case "/":
                            stack.push(previousNumber / recentNumber);
                            break;
                    }
                }
            } else {
                return "Invalid expression. Contains unknown character.";
            }
        }
        //return the result of the RPN expression
        return stack.pop().toString();
    }

    private boolean isValidNumber(String token) {
        //verify if token is a number by trying to parse it to a double
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
    private boolean isValidOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("sqrt");
    }
}
