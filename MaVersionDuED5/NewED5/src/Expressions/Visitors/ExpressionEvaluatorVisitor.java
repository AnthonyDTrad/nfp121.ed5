package Expressions.Visitors;
import Expressions.ExpressionVisitor;
import Operands.BinaryOperande;
import Operands.NumberOperande;

public class ExpressionEvaluatorVisitor implements ExpressionVisitor<Double>
{
    @Override
    public Double visitNumber(NumberOperande op) {
        return Double.valueOf(op.Value());
    }

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
