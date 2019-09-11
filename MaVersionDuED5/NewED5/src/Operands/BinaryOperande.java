package Operands;

import Expressions.Expression;
import Expressions.ExpressionVisitor;

public class BinaryOperande implements Expression
{
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

    @Override
    public <T> T Accept(ExpressionVisitor<T> visitor) {
        return visitor.visitBinary(this);
    }
}
