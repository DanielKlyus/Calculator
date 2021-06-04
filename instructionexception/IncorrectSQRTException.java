package com.company.instructionexception;

public class IncorrectSQRTException extends InstructionArithmeticException {
    public IncorrectSQRTException(String message) {
        super("can't take root: "+message);
    }
}