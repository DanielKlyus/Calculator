package com.company.instructionexception;

public class DefineException extends InstructionException {
    public DefineException(String message) {
        super("Problem with define: "+message);
    }
}