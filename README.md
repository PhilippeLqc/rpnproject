# Reverse Polish notation calculator

An angular based page which uses a REST Web Service to evaluate a based RPN expression

[http://en.wikipedia.org/wiki/Reverse_Polish_notation](http://en.wikipedia.org/wiki/Reverse_Polish_notation)

## Intro

An angular page that 
- can accept a RPN expression
- sends the expression to a REST controller that will be evaluated by a service calculator method
- displays the computed value or displays an error in case of problems
  
The calculator expects to receive a string containing whitespace separated list of numbers (double) and operators.
 
Available operators are `+`, `-`, `*`, `/`, `sqrt`

- `sqrt` performs a square root

- The `+`, `-`, `*`, `/` operators perform addition, subtraction, multiplication and division respectively
 
After processing an input string, the calculator returns the computed result, or an error if something goes wrong.

## Examples

    1 2 +           => 3
    5.2 7.1 + 2 *   => 24.6
    2 9 sqrt -      => -1
    2 3 + -         => error
    1 2             => error

## Requirements

- Implemented and tested using Java (both spring-boot and angular project templates are given)

- Tests required with JUnit and Mockito
