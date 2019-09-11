package Expressions;

import Operands.BinaryOperande;
import Operands.NumberOperande;

public interface ExpressionVisitor<T>
{
    T visitNumber(NumberOperande op);
    T visitBinary(BinaryOperande op);
}