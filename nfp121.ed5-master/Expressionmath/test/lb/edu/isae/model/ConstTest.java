/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lb.edu.isae.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Acer
 */
public class ConstTest {
    
    public ConstTest() {
    }

    /**
     * Test of eval method, of class Const.
     */
    @Test
    public void testEval() {
        System.out.println("eval");
        Const instance = new ConstBuilder().setI(10).createConst();
        Expression expResult = instance;
        Expression result = instance.eval();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of show method, of class Const.
     */
    @Test
    public void testShow() {
        System.out.println("show");
       Const instance = new ConstBuilder().setI(10).createConst();
        String expResult = "Const:10";
        String result = instance.show();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of evalNum method, of class Const.
     */
    @Test
    public void testEvalNum() {
        System.out.println("evalNum");
        Const instance = new ConstBuilder().setI(10).createConst();
        Number expResult = 10;
        Number result = instance.evalNum();
        assertEquals(expResult, result);
       
    }
    
}
