package com.company.instructionexception;

public class InstructionArithmeticException extends InstructionException {
    InstructionArithmeticException(String message) {
        super("Problem with executing Instructions arithmetic "+message);
    }
}