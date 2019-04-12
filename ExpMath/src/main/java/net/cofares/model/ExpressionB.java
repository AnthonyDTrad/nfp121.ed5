/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.model;

/**
 * omolememte composition, Abstract Factory + template
 * @author Acer
 */
public abstract class ExpressionB implements Expression{

    Expression e1;
    Expression e2;

    /**
     * C'est une abstract facroty en focntion op choix de la factory
     * @param op
     * @param e1
     * @param e2
     * @return 
     */
    public static Expression create(String op, Expression e1, Expression e2) {
        if (op.equals("+")) {
            return Add.create(e1, e2);
        }
        return null;
    }

    
}
