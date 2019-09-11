/*
 * Copyright (C) 2019 pfares
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.cofares.model;

import net.cofares.visiteur.eval.EvalNum;
import net.cofares.visiteur.eval.EvalShow;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pfares
 */
public class ConstTest {
    Const instance;
    public ConstTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //System.out.println("Before class");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
          System.out.println("Before Each");
          instance = Const.create(10);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class Const.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Integer i = 10;
        Integer expResult = i;
        Const result = Const.create(i);
        assertEquals(expResult, result.evalNum());
    }

    /**
     * Test of eval method, of class Const.
     */
    @Test
    public void testEval() {
        System.out.println("eval");
 
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

        Integer expResult = 10;
        Integer result = instance.evalNum();
        assertEquals(expResult, result);
        
    }

  

    /**
     * Test of evalAccept method, of class Const.
     * 
     */
    @Test
    public void testEvalAccept() {
        System.out.println("evalAccept");

        Integer expResult = 10;
        Integer result = instance.evalAccept(new EvalNum());
        assertEquals(expResult, result);
        
        String expsresult="Const:10";
        String sresult = instance.evalAccept(new EvalShow());
        assertEquals(expsresult, sresult);

    }
    
}
