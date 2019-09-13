package Operands;

import Expressions.Expression;
import Expressions.ExpressionVisitor;

/**
 * This is a NUMBER expression
 */
public class NumberOperande implements Expression
{
    /**
     * @param val Initialize a single expression with a specific value
     * @return the initialized expression
     */
    public static NumberOperande CREATE(double val)
    {
        return new NumberOperande(val);
    }

    private double _val;
    private NumberOperande(double val)
    {
        _val=val;
    }
    public double Value(){return _val;}

    /**
     * @param visitor The visitor that will evaluate an expression in his specific way
     * @param <T>
     * @return
     */
    @Override
    public <T> T Accept(ExpressionVisitor<T> visitor) {
        return visitor.visitNumber(this);
    }
}
