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
public interface Expression {
    public Integer evalNum();
    public Expression eval();
    public String show();
}
