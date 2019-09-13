package Expressions.Visitors;

import Expressions.ExpressionVisitor;
import Operands.BinaryOperande;
import Operands.NumberOperande;

/**
 * This visitor convert an expression to a string int this pattern : (op1 operator op2)
 */
public class ExpressionDisplayerVisitor implements ExpressionVisitor<String>
{
    public static final String SYMBOLE_OUVRANT="(";
    public static final String SYMBOLE_FERMANT=")";

    /**
     * @param op A single expression
     * @return Returns the number inside this expression
     */
    @Override
    public String visitNumber(NumberOperande op)
    {
        return String.valueOf(op.Value());
    }


    /**
     * @param bop A group of expressions
     * @param op Char equivalent of an operation
     * @return the toString() value of the expression
     */
    private String GetValue(BinaryOperande bop,char op)
    {
        StringBuilder builder = new StringBuilder();

        return String.valueOf(builder.append(SYMBOLE_OUVRANT)
                .append(builder.append(bop.GetLeftOperande().Accept(this)))
                .append(op)
                .append(bop.GetRightOperande().Accept(this))
                .append(SYMBOLE_FERMANT));
    }

    /**
     * @param bop A group of expressions
     * @return the toString() value of the expression
     */
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
