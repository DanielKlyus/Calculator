package com.company.instructionexception;

public class InstructionException extends Exception {
    InstructionException(String message) {
        super("Problem with executing Instruction: "+message);
    }
}