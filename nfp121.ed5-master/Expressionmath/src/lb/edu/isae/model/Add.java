/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lb.edu.isae.model;

/**
 *
 * @author Acer
 */
public class Add implements Expression {
    Expression e1;
    Expression e2;
    @Override
    public Integer evalNum() {
        return e1.evalNum() + e2.evalNum();
    }

    @Override
    public Expression eval() {
      return new Const(e1.evalNum()+e2.evalNum());
    }

    @Override
    public String show() {
        return "(" + e1.show() + "+" + e2.show() + ")" ;
    }
    
}
