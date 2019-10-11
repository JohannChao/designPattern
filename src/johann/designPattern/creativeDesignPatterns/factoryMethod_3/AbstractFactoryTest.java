package johann.designPattern.creativeDesignPatterns.factoryMethod_3;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @ClassName AbstractFactoryTest
 * @Description 工厂方法测试
 * @Author Johann
 * @Date 2019-7-11 14:53
 **/
public class AbstractFactoryTest{
    public static void main(String[] args)
    {
        try
        {
            Product a;
            AbstractFactory af;
            af=(AbstractFactory) ReadXml.getObject();
            a=af.newProduct();
            a.show();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
/**
 * @Author Johann
 * @Description 抽象产品：提供了产品的接口
 * @Date 17:04 2019-7-11
 * @Param
 * @return
 **/
interface Product
{
    /**
     * @Author Johann
     * @Description 显示
     * @Date 17:07 2019-7-11
     * @Param []
     * @return void
     **/
    public void show();
}
/**
 * @Author Johann
 * @Description 具体产品1：实现抽象产品中的抽象方法
 * @Date 17:04 2019-7-11
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
 * @Date 17:05 2019-7-11
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
 * @Description 抽象工厂：提供了厂品的生成方法 
 * @Date 17:05 2019-7-11
 * @Param 
 * @return 
 **/
interface AbstractFactory
{
    /**
     * @Author Johann
     * @Description 生成产品
     * @Date 17:11 2019-7-11
     * @Param []
     * @return johann.designPattern.creativeDesignPatterns.factoryMethod.Product
     **/
    public Product newProduct();
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
    public Product newProduct()
    {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
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
    public Product newProduct()
    {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}


class ReadXml
{
    /**
     * @Author Johann
     * @Description 该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
     * @Date 17:06 2019-7-11
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
            doc=builder.parse(new File("src/resources/readXmlConfig.xml"));
            //获取包含类名的文本节点
            NodeList nl=doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName="johann.designPattern.creativeDesignPatterns.factoryMethod_3."+classNode.getNodeValue();
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