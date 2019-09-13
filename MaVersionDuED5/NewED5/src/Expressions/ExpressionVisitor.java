package Expressions;
import Operands.BinaryOperande;
import Operands.NumberOperande;


/**
 * This is the base of any visitor
 */
public interface ExpressionVisitor<T>
{
    /**
     * @param op A single expression
     * @return The value in this single expression
     */
    T visitNumber(NumberOperande op);

    /**
     * @param op A group of expressions
     * @return The value in this group of expressions
     */
    T visitBinary(BinaryOperande op);
}