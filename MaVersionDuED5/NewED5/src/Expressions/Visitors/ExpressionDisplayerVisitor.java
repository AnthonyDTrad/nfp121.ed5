package Expressions.Visitors;

import Expressions.ExpressionVisitor;
import Operands.BinaryOperande;
import Operands.NumberOperande;

public class ExpressionDisplayerVisitor implements ExpressionVisitor<String>
{
    public static final String SYMBOLE_OUVRANT="(";
    public static final String SYMBOLE_FERMANT=")";

    @Override
    public String visitNumber(NumberOperande op) {
        return String.valueOf(op.Value());
    }

    private String GetValue(BinaryOperande bop,char op)
    {
        StringBuilder builder = new StringBuilder();

        return String.valueOf(builder.append(SYMBOLE_OUVRANT)
                .append(builder.append(bop.GetLeftOperande().Accept(this)))
                .append(op)
                .append(bop.GetRightOperande().Accept(this))
                .append(SYMBOLE_FERMANT));
    }

    @Override
    public String visitBinary(BinaryOperande bop)
    {

        switch (bop.GetOperator())
        {
            case Add:
                return GetValue(bop,'+');
            case Sub:
                return GetValue(bop,'-');
            case Mul:
                return GetValue(bop,'*');
            case Div:
                return GetValue(bop,'/');
        }
        return null;
    }

}
