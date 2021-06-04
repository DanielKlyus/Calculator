package com.company.instructions;
import com.company.instructionexception.*;
import com.company.CalculatorContext;

public class Define implements Instruction {
    public void Execute(Object[] args, CalculatorContext ctx) throws InstructionException {
        //System.out.println(args[2]);
        try {
            ctx.getMap().put(args[1].toString(), Double.valueOf(args[2].toString()));
        }
        catch (NumberFormatException e) {
            throw new DefineException("bad 2nd argument");
        }
        //System.out.println(Double.valueOf(args[2].toString())*2);
    }
}