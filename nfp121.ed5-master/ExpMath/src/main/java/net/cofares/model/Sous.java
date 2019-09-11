package net.cofares.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.cofares.visiteur.eval.Eval;

/**
 * Pattern composite + Factory Appelé par la super classe ExpressionB qui
 * implémente la composition + Abstract factory en fonction de l'opération
 *
 * @author Acer
 */
public class Sous extends ExpressionB {

    public static Sous create(Expression e1, Expression e2) {
        return new Sous(e1, e2);
    }

    private Sous(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    //L'evaluation par visiteur
    @Override
    public <T> T evalAccept(Eval<T> e) {
        return e.eval(this);
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
