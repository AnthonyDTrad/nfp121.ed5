/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lb.edu.isae.model;


public class ConstBuilder {

    private Integer i;

    public ConstBuilder() {
    }

    /**
     * setter de builder (retourne ConstBuilder pour
     * pouvoir enchainer les setters
     */
    public ConstBuilder setI(Integer i) {
        this.i = i;
        return this;
    }

    public Const createConst() {
        return new Const(i);
    }
    
}
