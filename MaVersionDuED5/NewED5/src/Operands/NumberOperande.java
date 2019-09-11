package Operands;

import Expressions.Expression;
import Expressions.ExpressionVisitor;

public class NumberOperande implements Expression
{
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

    @Override
    public <T> T Accept(ExpressionVisitor<T> visitor) {
        return visitor.visitNumber(this);
    }
}
