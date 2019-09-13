package Expressions;

/**
 * This is the base of any expression
 */
public interface Expression
{
    /**
     * @param visitor The visitor that will evaluate an expression in his specific way
     * @param <T> the type of the data that will be operated on
     * @return the evaluated data
     */
    <T> T Accept(ExpressionVisitor<T> visitor);
}