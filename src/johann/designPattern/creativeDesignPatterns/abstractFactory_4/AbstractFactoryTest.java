package johann.designPattern.creativeDesignPatterns.abstractFactory_4;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @Author Johann
 * @Description 抽象工厂方法测试
 * @Date 15:01 2019-7-12
 * @Param
 * @return
 **/
public class AbstractFactoryTest{
    public static void main(String[] args)
    {
        try
        {
            Product a1;
            Product a2;
            AbstractFactory af;
            af=(AbstractFactory) ReadXml.getObject();
            a1=af.newProduct1();
            a1.show();
            a2=af.newProduct2();
            a2.show();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

interface Product
{
    public void show();
}
/**
 * @Author Johann
 * @Description 具体产品1：实现抽象产品中的抽象方法
 * @Date 15:07 2019-7-12
 * @Param
 * @return
 **/
class ConcreteProduct1 implements Product
{
    @Override
    public void show()
    {
        System.out.println("具体产品1显示...");
    }
}
/**
 * @Author Johann
 * @Description 具体产品2：实现抽象产品中的抽象方法
 * @Date 15:06 2019-7-12
 * @Param 
 * @return 
 **/
class ConcreteProduct2 implements Product
{
    @Override
    public void show()
    {
        System.out.println("具体产品2显示...");
    }
}

/**
 * @Author Johann
 * @Description 具体产品3：实现抽象产品中的抽象方法
 * @Date 15:05 2019-7-12
 * @Param
 * @return
 **/
class ConcreteProduct3 implements Product
{
    @Override
    public void show()
    {
        System.out.println("具体产品3显示...");
    }
}
/**
 * @Author Johann
 * @Description 具体产品4：实现抽象产品中的抽象方法
 * @Date 15:05 2019-7-12
 * @Param
 * @return
 **/
class ConcreteProduct4 implements Product
{
    @Override
    public void show()
    {
        System.out.println("具体产品4显示...");
    }
}
/**
 * @Author Johann
 * @Description 抽象工厂：提供了厂品的生成方法
 * @Date 17:05 2019-7-11
 * @Param
 * @return
 **/
interface AbstractFactory
{
    public Product newProduct1();

    public Product newProduct2();
}
/**
 * @Author Johann
 * @Description 具体工厂1：实现了厂品的生成方法
 * @Date 17:05 2019-7-11
 * @Param
 * @return
 **/
class ConcreteFactory1 implements AbstractFactory
{
    @Override
    public Product newProduct1()
    {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }

    @Override
    public Product newProduct2()
    {
        System.out.println("具体工厂1生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}
/**
 * @Author Johann
 * @Description 具体工厂2：实现了厂品的生成方法
 * @Date 17:05 2019-7-11
 * @Param
 * @return
 **/
class ConcreteFactory2 implements AbstractFactory
{
    @Override
    public Product newProduct1()
    {
        System.out.println("具体工厂2生成-->具体产品3...");
        return new ConcreteProduct3();
    }
    @Override
    public Product newProduct2()
    {
        System.out.println("具体工厂2生成-->具体产品4...");
        return new ConcreteProduct4();
    }
}


class ReadXml
{
    /**
     * @Author Johann
     * @Description  该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
     * @Date 15:08 2019-7-12
     * @Param []
     * @return java.lang.Object
     **/
    public static Object getObject()
    {
        try
        {
            //创建文档对象
            DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=dFactory.newDocumentBuilder();
            Document doc;
            doc=builder.parse(new File("src/factoryMethodConfig1.xml"));
            //获取包含类名的文本节点
            NodeList nl=doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName="johann.designPattern.creativeDesignPatterns.abstractFactory_4."+classNode.getNodeValue();
            System.out.println("新类名："+cName);
            //通过类名生成实例对象并将其返回
            Class<?> c=Class.forName(cName);
            Object obj=c.newInstance();
            return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
