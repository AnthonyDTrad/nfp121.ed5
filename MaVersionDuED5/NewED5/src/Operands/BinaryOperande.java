package Operands;

import Expressions.Expression;
import Expressions.ExpressionVisitor;

/**
 * This is a group of expression with a specific operation to be done to those groups
 */
public class BinaryOperande implements Expression
{
    /**
     * @param e1 The first operande
     * @param op The operation that will be executed
     * @param e2 The second operande
     * @return A group of expressions from the first,second expression
     */
    public static BinaryOperande CREATE(Expression e1, Operations op, Expression e2)
    {
        return new BinaryOperande(e1,op,e2);
    }

    Expression ex1=null,ex2=null;
    Operations ops=null;
    private BinaryOperande(Expression e1, Operations op, Expression e2)
    {
        ex1=e1;ex2=e2;ops=op;
    }

    public  Expression GetLeftOperande(){return  ex1;}
    public  Expression GetRightOperande(){return  ex2;}
    public  Operations GetOperator(){return  ops;}

    /**
     * @param visitor The visitor that will evaluate an expression in his specific way
     * @param <T>
     * @return
     */
    @Override
    public <T> T Accept(ExpressionVisitor<T> visitor)
    {
        return visitor.visitBinary(this);
    }
}
