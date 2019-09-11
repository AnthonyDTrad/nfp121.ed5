/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.visiteur.eval;

import net.cofares.model.Add;
import net.cofares.model.Const;
import net.cofares.model.Sous;

/**
 * Le visiteur EvalNum
 * les methde eval sont la méthode visit du pattern visiteur
 * @author Pascal Fares
 */
public class EvalNum implements Eval<Integer> {
    @Override
    public Integer eval(Const c){
        return c.getI();
    }
    
    @Override
    public Integer eval(Add a){
        return a.getE1().evalNum()+a.getE2().evalNum();
    }
    
    @Override
    public Integer eval(Sous a){
        return a.getE1().evalNum()-a.getE2().evalNum();
    }
}
