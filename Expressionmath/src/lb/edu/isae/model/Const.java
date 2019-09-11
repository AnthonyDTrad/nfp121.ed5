
package lb.edu.isae.model;

/**
 *
 * @author Pascal Fares (c) Cnam Liban
 */
public class Const implements Expression {
    Integer i;
    
    public Const(Integer i){
        this.i=i;
    }
    
    @Override
    public Expression eval() {
      return this; 
    }

    @Override
    public String show() {
       return "Const:"+i;
    }

    @Override
    public Integer evalNum() {
       return i;
    }
    
    public static void main(String args[]) {
       
        Const instance = new ConstBuilder().setI(10).createConst();
        System.out.println("show = "+instance.eval());
        System.out.println("show = "+instance.show());
        System.out.println("EvalNum = "+instance.evalNum());
    }
    
}
