package net.cofares.model;

import net.cofares.visiteur.eval.Eval;
import net.cofares.visiteur.eval.EvalNum;
import net.cofares.visiteur.eval.EvalShow;
import net.cofares.visiteur.eval.EvalToExp;

/**
 * La grammaire
 * 
 * Expression ::= Const | ExpressionB
 * <br/>
 * Const ::= Integer Java (final)
 * <br/>
 * ExpressionB ::= (Expression op Expression)
 * <br/>
 * op symbole final prenant une des valeurs suivantes: + | - | ...
 * <br/>
 * OU
 * <br/>
 * ExpressionB :== Addition | Soustraction | ...
 * <br/>
 * Addition :== (Expression + Expression)
 * <br/>
 * Soustraction ::= (Expression + Expression)
 * <br/>
 * <hr/>
 * Quand on utilise le pattern composite pour créer une Expression. En fait 
 * On créer l'AST l'arbre sémantquee Abstrait 
 * (Abstaract Semantic Tree en anglais)
 * ...
 * @author Pascal Fares
 */
public abstract class Expression {
    //Les visiteurs prévus
    /**
     * Visiteur d'évaluation en Integer Expression &rarr; Integer
     */
    static EvalNum en = new EvalNum(); //Les visiteur 
    /**
     * Visiteur d'évaluation simplification Expression &rarr; Expression
     */
    static EvalToExp e = new EvalToExp();
    /**
     * Visiteur d'évaluation affichage normal exemple
     * (e1 op e2)
     */
    static EvalShow es = new EvalShow();
    // à injecter apr un setter, à la création une evaluateur par defaut.

    //Factory Expression create : style visiteur
    /**
     * Factory de crátion d'une expression constante
     * @param i l'entier
     * @return une expression instance de Const
     */
    public static Expression create(Integer i) {
        return Const.create(i);
    }
    /**
     * Factory de crátion d'une expression "binaire"
     * @param op l'opération
     * @param e1 l'expression gauche
     * @param e2 l expression droite
     * @return Une expression instance de ExpressionB
     */
    public static Expression create(String op, Expression e1, Expression e2) {
        return ExpressionB.create(op, e1, e2);
    }
    /**
     * Evaluation numérique
     * Utilisation du pattern visiteur + template method
     * Visisteur = EvalNum , accept = evalAccept
     * @return 
     */
    public Integer evalNum() {
        return evalAccept(en);
    }
    /**
     * Avaluation de symplification Expression donne Une autre expression
     * Utilisation du pattern visiteur + template method
     * Visisteur = EvalToExp , accept = evalAccept
     * @return 
     */
    public Expression eval() {
        return evalAccept(e);
    }
    /**
     * Evaluation affichage de l'arbre sémantique (ou traduction)
     * Utilisation du pattern visiteur + template method
     * Visisteur = EvalShow , accept = evalAccept
     * @return 
     */
    public String show(){
        return evalAccept(es);
    }
    
    /**
     * la method evalAccept inmplementée par les sous class
     * @param <T>
     * @param e
     * @return 
     */
    abstract public <T> T evalAccept(Eval<T> e); 
}
