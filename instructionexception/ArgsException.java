package com.company.instructionexception;

public class ArgsException extends InstructionException {
    public ArgsException(String message) {
        super("Problem with arguments: "+message);
    }
}