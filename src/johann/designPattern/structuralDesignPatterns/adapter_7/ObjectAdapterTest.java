package johann.designPattern.structuralDesignPatterns.adapter_7;

/**
 * @ClassName ObjectAdapterTest
 * @Description 对象适配器模式
 * @Author Johann
 * @Date 2019-7-16 14:13
 **/
public class ObjectAdapterTest {

    public static void main(String[] args)
    {
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}

/**
 * @Author Johann
 * @Description 目标接口
 * @Date 14:00 2019-7-16
 * @Param
 * @return
 **/
interface Target
{
    public void request();
}

/**
 * @Author Johann
 * @Description 适配者类，现有组件库中已经实现的组件
 * @Date 14:01 2019-7-16
 * @Param
 * @return
 **/
class Adaptee
{
    public void adapteeRequest()
    {
        System.out.println("现存组件库已实现的功能......");
    }
}

/**
 * @Author Johann
 * @Description 对象适配器模式：适配器类
 * @Date 14:14 2019-7-16
 * @Param
 * @return
 **/
class ObjectAdapter implements Target{

    private Adaptee adaptee;
    public ObjectAdapter(Adaptee adaptee)
    {
        this.adaptee=adaptee;
    }
    @Override
    public void request() {
        System.out.println("对象适配器模式：适配器类尝试连接......");
        adaptee.adapteeRequest();
    }
}