package com.company.instructions;

import com.company.CalculatorContext;
import com.company.instructionexception.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Minus implements Instruction {
    public void Execute(Object[] args, CalculatorContext ctx) throws ArgsException {
        if (ctx.getStack().isEmpty())
            throw new ArgsException("there isn't such operands in stack (Minus)");
        Double first = ctx.getStack().pop();
        if (ctx.getStack().isEmpty())
            throw new ArgsException("there isn't such operands in stack (Minus)");
        Double second = ctx.getStack().pop();

        ctx.getStack().addFirst(second-first);
        Logger.getGlobal().log(Level.FINEST, second+"MINUS"+first);
    }
}