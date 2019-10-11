package johann.designPattern.structuralDesignPatterns.decorator_9;

/**
 * @ClassName DecoratorTest
 * @Description 装饰模式---实现
 * @Author Johann
 * @Date 2019-7-18 10:55
 **/
public class DecoratorTest {

    public static void main(String[] args)
    {
        Component p=new ConcreteComponent();
        p.operation();
        System.out.println("---------------------------------");
        Component d=new ConcreteDecorator(p);
        d.operation();
    }
}

/**
 * @Author Johann
 * @Description 抽象构件角色
 * @Date 10:56 2019-7-18
 * @Param
 * @return
 **/
interface  Component
{
    public void operation();
}

/**
 * @Author Johann
 * @Description 具体构件角色
 * @Date 10:56 2019-7-18
 * @Param
 * @return
 **/
class ConcreteComponent implements Component
{
    public ConcreteComponent()
    {
        System.out.println("创建具体构件角色");
    }
    @Override
    public void operation()
    {
        System.out.println("调用具体构件角色的方法operation()");
    }
}
/**
 * @Author Johann
 * @Description 抽象装饰角色
 * @Date 10:56 2019-7-18
 * @Param
 * @return
 **/
class Decorator implements Component
{
    private Component component;
    public Decorator(Component component)
    {
        this.component=component;
    }
    @Override
    public void operation()
    {
        component.operation();
    }
}
/**
 * @Author Johann
 * @Description 具体装饰角色
 * @Date 10:58 2019-7-18
 * @Param
 * @return
 **/
class ConcreteDecorator extends Decorator
{
    public ConcreteDecorator(Component component)
    {
        super(component);
    }
    @Override
    public void operation()
    {
        super.operation();
        addedFunction();
    }
    public void addedFunction()
    {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }
}