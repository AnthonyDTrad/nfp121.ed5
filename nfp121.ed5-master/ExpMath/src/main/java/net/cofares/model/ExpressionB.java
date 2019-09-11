/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.model;

import java.util.Objects;
import net.cofares.visiteur.eval.EvalNum;
import net.cofares.visiteur.eval.EvalShow;
import net.cofares.visiteur.eval.EvalToExp;

/**
 * omolememte composition, Abstract Factory + template
 *
 * @author Acer
 */
public abstract class ExpressionB extends Expression {

    /**
     * @return the e1
     */
    public Expression getE1() {
        return e1;
    }

    /**
     * @param e1 the e1 to set
     */
    public void setE1(Expression e1) {
        this.e1 = e1;
    }

    /**
     * @return the e2
     */
    public Expression getE2() {
        return e2;
    }

    /**
     * @param e2 the e2 to set
     */
    public void setE2(Expression e2) {
        this.e2 = e2;
    }

    protected Expression e1;
    protected Expression e2;

    /**
     * C'est une abstract facroty en focntion de op ::== choix de la Fabrique
     * concrète
     *
     * @param op
     * @param e1
     * @param e2
     * @return
     */
    public static ExpressionB create(String op, Expression e1, Expression e2) {
        en = new EvalNum(); //TODO le passer en injection (c' est en fait une tratégie d'évaluation
        e = new EvalToExp();
        es = new EvalShow();

        if (op.equals("+")) {
            return Add.create(e1, e2);
        } else if (op.equals("-")) {
            return Sous.create(e1, e2);
        }
        //TODO : ajouter toutes les autres opérations permises
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ExpressionB)) {
            return false;
        }
        ExpressionB a = (ExpressionB) o;
        //Egalité de 2 expression binare (a+b) == (a+b) mais aussi par 
        //simétrie (a+b) = (b+a)
        return ((this.e1.equals(a.e1) && this.e2.equals(a.e2))
                || (this.e1.equals(a.e2) && this.e2.equals(a.e1)));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.e1);
        hash = 97 * hash + Objects.hashCode(this.e2);
        return hash;
    }

}
