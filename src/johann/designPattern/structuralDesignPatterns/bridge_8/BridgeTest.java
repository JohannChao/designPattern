package johann.designPattern.structuralDesignPatterns.bridge_8;

/**
 * @ClassName BridgeTest
 * @Description 桥接模式实现
 * @Author Johann
 * @Date 2019-7-17 10:54
 **/
public class BridgeTest {

    public static void main(String[] args)
    {
        Implementor imple=new ConcreteImplementor();
        Abstraction abs=new RefinedAbstraction(imple);
        abs.Operation();
    }

}

/**
 * @Author Johann
 * @Description 实现化角色
 * @Date 10:55 2019-7-17
 * @Param
 * @return
 **/
interface Implementor
{
    public void OperationImpl();
}

/**
 * @Author Johann
 * @Description 具体实现化角色
 * @Date 10:56 2019-7-17
 * @Param 
 * @return 
 **/
class ConcreteImplementor implements Implementor
{
    @Override
    public void OperationImpl()
    {
        System.out.println("具体实现化(Concrete Implementor)角色被访问......" );
    }
}

/**
 * @Author Johann
 * @Description 抽象化角色类
 * @Date 10:58 2019-7-17
 * @Param 
 * @return 
 **/
abstract class Abstraction
{
    protected Implementor imple;
    protected Abstraction(Implementor imple)
    {
        this.imple=imple;
    }
    public abstract void Operation();
}

/**
 * @Author Johann
 * @Description 扩展抽象化角色类
 * @Date 10:59 2019-7-17
 * @Param 
 * @return 
 **/
class RefinedAbstraction extends Abstraction
{
    protected RefinedAbstraction(Implementor imple)
    {
        super(imple);
    }
    @Override
    public void Operation()
    {
        System.out.println("扩展抽象化(Refined Abstraction)角色类被访问......" );
        imple.OperationImpl();
    }
}