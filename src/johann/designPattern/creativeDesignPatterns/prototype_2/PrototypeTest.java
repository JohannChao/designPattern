package johann.designPattern.creativeDesignPatterns.prototype_2;

/**
 * @Author Johann
 * @Description 具体原型类。
 * 原型模式的克隆分为浅克隆和深克隆，Java 中的 Object 类提供了浅克隆的 clone() 方法，具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆，这里的 Cloneable 接口就是抽象原型类。
 * @Date 17:14 2019-7-11
 * @Param
 * @return
 **/
class Realizetype implements Cloneable
{
    Realizetype()
    {
        System.out.println("具体原型创建成功！");
    }
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        System.out.println("具体原型复制成功！");
        return (Realizetype)super.clone();
    }
}
/**
 * @Author Johann
 * @Description 原型模式的测试类
 * @Date 17:13 2019-7-11
 * @Param
 * @return
 **/
public class PrototypeTest
{
    public static void main(String[] args)throws CloneNotSupportedException
    {
        Realizetype obj1=new Realizetype();
        Realizetype obj2=(Realizetype)obj1.clone();
        System.out.println("obj1==obj2?"+(obj1==obj2));
    }
}
