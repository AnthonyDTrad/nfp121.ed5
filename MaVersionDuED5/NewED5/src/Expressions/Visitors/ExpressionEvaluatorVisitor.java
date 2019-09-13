package Expressions.Visitors;
import Expressions.ExpressionVisitor;
import Operands.BinaryOperande;
import Operands.NumberOperande;

/**
 * This visitor calculate the value of an expression ( 1+5 will be evaluated as 6)
 */
public class ExpressionEvaluatorVisitor implements ExpressionVisitor<Double>
{
    /**
     * @param op A single expression
     * @return The value in this single expression
     */
    @Override
    public Double visitNumber(NumberOperande op)
    {
        return Double.valueOf(op.Value());
    }

    /**
     * @param bop A group of expressions
     * @return The value in this group of expressions
     */
    @Override
    public Double visitBinary(BinaryOperande bop)
    {
        switch (bop.GetOperator())
        {
            case Add:
                return bop.GetLeftOperande().Accept(this) + bop.GetRightOperande().Accept(this);
            case Sub:
                return bop.GetLeftOperande().Accept(this) - bop.GetRightOperande().Accept(this);
            case Mul:
                return bop.GetLeftOperande().Accept(this) * bop.GetRightOperande().Accept(this);
            case Div:
                return bop.GetLeftOperande().Accept(this) / bop.GetRightOperande().Accept(this);
        }
        return null;
    }
}
