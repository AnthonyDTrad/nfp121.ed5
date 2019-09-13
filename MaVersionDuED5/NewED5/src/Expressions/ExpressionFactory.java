package Expressions;

import Operands.BinaryOperande;
import Operands.NumberOperande;
import Operands.Operations;

/**
 * This factory creates a binary or single expression based on the params
 */
public  class ExpressionFactory
{
    /**
     * @param val Initialize a single expression with a specific value
     * @return the initialized expression
     */
    public static Expression CREATE(double val)
    {
        return  NumberOperande.CREATE(val);
    }


    /**
     * @param e1 The first operande
     * @param op The operation that will be executed
     * @param e2 The second operande
     * @return A group of expressions from the first,second expression
     */
    public static Expression CREATE(Expression e1, Operations op, Expression e2)
    {
        return  BinaryOperande.CREATE(e1,op,e2);
    }
}
