package net.cofares.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.cofares.visiteur.eval.Eval;


/**
 * Write a description of class Mul here.
 *
 * @author Anthony Trad
 * @version 1.0
 */
public class Mul extends ExpressionB
{
     public static Mul create(Expression e1, Expression e2) {
        return new Mul(e1, e2);
    }
   
    private Mul(Expression e1, Expression e2) {
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
