package com.company;

import com.company.instructions.*;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.NamingException;

public class InstructionsTests {
    public InstructionsTests() throws NamingException {
        /*Minus();
        Plus();
        Multiple();
        Division();
        SQRT();
        Print();
        Push();
        Pop();*/
    }
    @Test
    public void testMinus () throws NamingException {
        CalculatorContext ctx = new CalculatorContext();
        ctx.getStack().addFirst(5.0);
        ctx.getStack().addFirst(2.0);
        CalculatorContext normal_ctx = new CalculatorContext();
        normal_ctx.getStack().addFirst(3.0);

        Minus forTest = new Minus();
        try {
            forTest.Execute(null, ctx);
        }
        catch (Exception ex) {
            Assert.assertEquals("Exception!", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);

        }
        Assert.assertEquals("Minus doesn't work correctly", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);
    }

    @Test
    public void testPlus() throws NamingException {
        CalculatorContext ctx = new CalculatorContext();
        ctx.getStack().addFirst(5.0);
        ctx.getStack().addFirst(2.0);
        CalculatorContext normal_ctx = new CalculatorContext();
        normal_ctx.getStack().addFirst(7.0);

        Plus forTest = new Plus();
        try {
            forTest.Execute(null, ctx);
        }
        catch (Exception ex) {
            Assert.assertEquals("Exception!", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);

        }
        Assert.assertEquals("Plus doesn't work correctly", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);
    }

    @Test
    public void testMultiple() throws NamingException {
        CalculatorContext ctx = new CalculatorContext();
        ctx.getStack().addFirst(5.0);
        ctx.getStack().addFirst(2.0);
        CalculatorContext normal_ctx = new CalculatorContext();
        normal_ctx.getStack().addFirst(10.0);

        Multiple forTest = new Multiple();
        try {
            forTest.Execute(null, ctx);
        }
        catch (Exception ex) {
            Assert.assertEquals("Exception!", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);

        }
        Assert.assertEquals("Multiple doesn't work correctly", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);
    }

    @Test
    public void testDivision() throws NamingException {
        CalculatorContext ctx = new CalculatorContext();
        ctx.getStack().addFirst(5.0);
        ctx.getStack().addFirst(2.0);
        CalculatorContext normal_ctx = new CalculatorContext();
        normal_ctx.getStack().addFirst(2.5);

        Division forTest = new Division();
        try {
            forTest.Execute(null, ctx);
        }
        catch (ZeroDivisionException divbyzero){
            Assert.fail("Division by zero!");
        }
        catch (Exception ex) {
            Assert.assertEquals("Exception!", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);
        }
        Assert.assertEquals("Division doesn't work correctly", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);
    }

    @Test
    public void testPrint() throws NamingException {
        CalculatorContext ctx = new CalculatorContext();
        ctx.getStack().addFirst(5.0);
        ctx.getStack().addFirst(2.0);
        CalculatorContext normal_ctx = new CalculatorContext();
        normal_ctx.getStack().addFirst(5.0);
        normal_ctx.getStack().addFirst(2.0);

        Print forTest = new Print();
        try {
            forTest.Execute(null, ctx);
        }
        catch (Exception ex) {
            Assert.assertEquals("Exception!", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);

        }
        while (!ctx.getStack().isEmpty() && !normal_ctx.getStack().isEmpty()) {
            Assert.assertEquals("Print doesn't work correctly", ctx.getStack().pop(), normal_ctx.getStack().pop());
        }
    }

    @Test
    public void testSQRT() throws NamingException {
        CalculatorContext ctx = new CalculatorContext();
        ctx.getStack().addFirst(4.0);
        CalculatorContext normal_ctx = new CalculatorContext();
        normal_ctx.getStack().addFirst(2.0);

        SQRT forTest = new SQRT();
        try {
            forTest.Execute(null, ctx);
        }
        catch (Exception ex) {
            Assert.assertEquals("Exception!", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);

        }
        Assert.assertEquals("SQRT doesn't work correctly", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);
    }

    @Test
    public void testPush() throws NamingException {
        CalculatorContext ctx = new CalculatorContext();
        //ctx.getStack().addFirst(4.0);
        CalculatorContext normal_ctx = new CalculatorContext();
        normal_ctx.getStack().addFirst(2.0);
        String[] args = {"PUSH", "2.0"};

        Push forTest = new Push();
        try {
            forTest.Execute(args, ctx);
        }
        catch (Exception ex) {
            Assert.assertEquals("Exception!", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);

        }
        Assert.assertEquals("Push doesn't work correctly", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001)
    }

    @Test
    public void testPop() throws NamingException {
        CalculatorContext ctx = new CalculatorContext();
        ctx.getStack().addFirst(2.0);
        ctx.getStack().addFirst(4.0);
        CalculatorContext normal_ctx = new CalculatorContext();
        normal_ctx.getStack().addFirst(2.0);
        //String args[] = {"PUSH", "2.0"};

        Pop forTest = new Pop();
        try {
            forTest.Execute(null, ctx);
        }
        catch (Exception ex) {
            Assert.assertEquals("Exception!", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);

        }
        Assert.assertEquals("Pop doesn't work correctly", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);
    }

    @Test
    public void testDefine() throws NamingException {
        CalculatorContext ctx = new CalculatorContext();
        CalculatorContext normal_ctx = new CalculatorContext();
        normal_ctx.getMap().put("a", 4.0);
        String[] args = {"Define", "a","4.0"};

        Define forTest = new Define();
        try {
            forTest.Execute(args, ctx);
        }
        catch (Exception ex) {
            Assert.assertEquals("Exception!", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);

        }
        Assert.assertEquals("Define doesn't work correctly", ctx.getMap().get("a"), normal_ctx.getMap().get("a"), 0.00001);
    }
    
    @Test
    public void testEXP() throws NamingException {
        CalculatorContext ctx = new CalculatorContext();
        ctx.getStack().addFirst(2.0);
        ctx.getStack().addFirst(4.0);
        CalculatorContext normal_ctx = new CalculatorContext();
        normal_ctx.getStack().addFirst(16.0);

        EXP forTest = new EXP();
        try {
            forTest.Execute(null, ctx);
        }
        catch (Exception ex) {
            Assert.assertEquals("Exception!", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);

        }
        Assert.assertEquals("EXP doesn't work correctly", ctx.getStack().pop(), normal_ctx.getStack().pop(), 0.00001);
    }
    
   @Test
    public void testDivisionByZero() throws NamingException{
        CalculatorContext ctx = new CalculatorContext();
        ctx.getStack().addFirst(5.0);
        Double first = ctx.getStack().pop();
        ctx.getStack().addFirst(0.0);
        Double second = ctx.getStack().pop();

        Assert.assertThrows(ZeroDivisionException.class, () -> {
            ctx.getStack().addFirst(second/first);
        });
    } 
}
