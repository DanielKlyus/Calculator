package com.company.instructions;

import com.company.CalculatorContext;
import com.company.instructionexception.*;

public interface Instruction {
    void Execute(Object[] args, CalculatorContext ctx) throws InstructionException;
}