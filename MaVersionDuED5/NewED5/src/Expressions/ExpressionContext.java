package Expressions;

/**
 * This is a semi strategy pattern, this context takes an expression and a visitor to execute
 */
public class ExpressionContext
{
    Expression _exp=null;
    ExpressionVisitor _visitor=null;

    /**
     * @param exp The expression to be executed
     * @param visitor The visitor that execute a specific operation to this expression
     */
    public  ExpressionContext(Expression exp,ExpressionVisitor visitor)
    {
        _exp=exp;
        _visitor=visitor;
    }


    /**
     * @param <T> The evaluated data type
     * @return The evaluated data
     */
    public <T> T Execute()
    {
        if((T)_exp.Accept(_visitor)!=null)
            return (T)_exp.Accept(_visitor);
        return  null;
    }
}
