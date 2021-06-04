package com.company.instructionexception;

public class ZeroDivisionException extends InstructionArithmeticException{
    public ZeroDivisionException(String message) {
        super("division by zero:"+message);
    }
}