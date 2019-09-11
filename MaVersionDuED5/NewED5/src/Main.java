import Expressions.Expression;
import Expressions.ExpressionBuilder;
import Expressions.ExpressionContext;
import Expressions.Visitors.ExpressionDisplayerVisitor;
import Expressions.Visitors.ExpressionEvaluatorVisitor;
import Operands.Operations;

public class Main
{
    public static void main(String[] args)
    {
        Expression e1= ExpressionBuilder.CREATE(123);
        Expression e2= ExpressionBuilder.CREATE(456);
        Expression e3= ExpressionBuilder.CREATE(789);

        Expression ge1=ExpressionBuilder.CREATE(e1, Operations.Add,e2);
        Expression ge2=ExpressionBuilder.CREATE(e1, Operations.Sub,e2);

        Expression ge3=ExpressionBuilder.CREATE(e2, Operations.Mul,e3);
        Expression ge4=ExpressionBuilder.CREATE(e2, Operations.Div,e3);

        Expression fge=ExpressionBuilder.CREATE(ge1,Operations.Mul,ge4);

        ExpressionContext contextE1=new ExpressionContext(e1,new ExpressionEvaluatorVisitor());
        ExpressionContext contextE2=new ExpressionContext(e2,new ExpressionDisplayerVisitor());

        ExpressionContext contextGe1=new ExpressionContext(ge1,new ExpressionEvaluatorVisitor());
        ExpressionContext contextGe2=new ExpressionContext(ge2,new ExpressionDisplayerVisitor());

        ExpressionContext contextFge=new ExpressionContext(fge,new ExpressionEvaluatorVisitor());
        ExpressionContext contextFge2=new ExpressionContext(fge,new ExpressionDisplayerVisitor());

        System.out.println(contextE1.Execute().toString());
        System.out.println(contextE2.Execute().toString());
        System.out.println(contextGe1.Execute().toString());
        System.out.println(contextGe2.Execute().toString());
        System.out.println(contextFge.Execute().toString());
        System.out.println(contextFge2.Execute().toString());
    }
}
