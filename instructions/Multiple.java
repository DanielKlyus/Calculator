package com.company.instructions;

import com.company.CalculatorContext;
import com.company.instructionexception.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Multiple implements Instruction {
    public void Execute(Object[] args, CalculatorContext ctx) throws ArgsException {
        if (ctx.getStack().isEmpty())
            throw new ArgsException("there isn't such operands in stack (Multiple)");
        Double first = ctx.getStack().pop();
        if (ctx.getStack().isEmpty())
            throw new ArgsException("there isn't such operands in stack (Multiple)");
        Double second = ctx.getStack().pop();

        ctx.getStack().addFirst(first*second);

        Logger.getGlobal().log(Level.FINEST, second+" MULTIPLY "+first);
    }
}