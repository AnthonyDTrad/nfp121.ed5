package Expressions;

public interface Expression
{
    <T> T Accept(ExpressionVisitor<T> visitor);
}