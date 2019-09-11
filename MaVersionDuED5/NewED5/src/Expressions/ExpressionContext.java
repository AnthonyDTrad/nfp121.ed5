package Expressions;

public class ExpressionContext
{
    Expression _exp=null;
    ExpressionVisitor _visitor=null;
    public  ExpressionContext(Expression exp,ExpressionVisitor visitor)
    {
        _exp=exp;
        _visitor=visitor;
    }

    public <T> T Execute()
    {
        if((T)_exp.Accept(_visitor)!=null)
            return (T)_exp.Accept(_visitor);
        return  null;
    }
}
