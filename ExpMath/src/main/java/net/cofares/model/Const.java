package net.cofares.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Objects;
import net.cofares.visiteur.eval.Eval;

/**
 * Const ::= entier de java Redéfinition de equals() pour égalité entre 2 Const
 * //TODO redefinir aussi hashcode()
 *
 * @author Pascal Fares (c) Cnam Liban
 */
public class Const extends Expression {

    /**
     * Fabrique de Const
     *
     * @param i
     * @return
     */
    public static Const create(Integer i) {
        return new Const(i);
    }

    private final Integer i;

    /**
     * Constructeur privé : obliger le passage par la fabrique
     *
     * @param i
     */
    private Const(Integer i) {
        this.i = i;
    }

    

    /**
     * @return the i
     */
    public Integer getI() {
        return i;
    }

    //Le plus général
    @Override
    public <T> T evalAccept(Eval<T> e) {
        return e.eval(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Const)) {
            return false;
        }
        //Ceci est de la programation deffensive assert permet
        //De verifier que la pré-condition de notre traitement est comme
        //Prévu
        //Pour utiliser assert faire java -ea <pgmJava>
        assert ((o != this) && (o instanceof Const));
        //o!=this ET o instanceof Const
        Const autre = (Const) o;
        return (this.getI().intValue() == autre.i.intValue());

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.i);
        return hash;
    }
    
    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	return gson.toJson(this);
    }
    /**
     * un main d'exmple et de test simplifié
     * @param args 
     */
    public static void main(String args[]) {

        Const instance = Const.create(10);
        System.out.println("show = " + instance.eval());
        System.out.println("show = " + instance.show());
        System.out.println("EvalNum = " + instance.evalNum());
        System.out.println("instance = " + instance);
    }

}
