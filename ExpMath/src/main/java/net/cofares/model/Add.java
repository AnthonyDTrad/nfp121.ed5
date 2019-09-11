package net.cofares.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.cofares.visiteur.eval.Eval;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Pattern composite + Factory
 * Appelé par la super classe ExpressionB qui implémente la composition + Abstract factory en fonction
 * de l'opération
 * @author Acer
 */
public class Add extends ExpressionB {

    public static Add create(Expression e1, Expression e2) {
        return new Add(e1, e2);
    }
   
    private Add(Expression e1, Expression e2) {
        this.e1=e1;
        this.e2=e2;
    }
    
    
    //Le plus général
    @Override
    public <T> T evalAccept(Eval<T> e) {
       return e.eval(this);
    }
    
    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	return gson.toJson(this);
    }
    
    public static void main(String args[]) {

        Const instance = Const.create(10);
        System.out.println("show = " + instance.eval());
        System.out.println("show = " + instance.show());
        System.out.println("EvalNum = " + instance.evalNum());
        System.out.println("instance = " + instance);
    }
}
