package Expressions;

import Operands.BinaryOperande;
import Operands.NumberOperande;
import Operands.Operations;

public  class ExpressionBuilder
{
    public static Expression CREATE(double val)
    {
        return  NumberOperande.CREATE(val);
    }
    public static Expression CREATE(Expression e1, Operations op, Expression e2)
    {
        return  BinaryOperande.CREATE(e1,op,e2);
    }
}
