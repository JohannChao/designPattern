package johann.designPattern.structuralDesignPatterns.adapter_7;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @ClassName MotorAdapterTest
 * @Description TODO
 * @Author Johann
 * @Date 2019-7-16 14:27
 **/
public class MotorAdapterTest {
    public static void main(String[] args)
    {
        System.out.println("适配器模式测试：");
        Motor motor=(Motor)ReadXml.getObject();
        motor.drive();
    }
}

/**
 * @Author Johann
 * @Description 目标接口：发动机启动
 * @Date 14:28 2019-7-16
 * @Param
 * @return
 **/
interface Motor
{
    public void drive();
}

/**
 * @Author Johann
 * @Description 适配者1：电能发动机
 * @Date 14:28 2019-7-16
 * @Param
 * @return
 **/
class ElectricMotor
{
    public void electricDrive()
    {
        System.out.println("电能发动机驱动汽车！");
    }
}
/**
 * @Author Johann
 * @Description 适配者2：光能发动机
 * @Date 14:28 2019-7-16
 * @Param
 * @return
 **/
class OpticalMotor
{
    public void opticalDrive()
    {
        System.out.println("光能发动机驱动汽车！");
    }
}
/**
 * @Author Johann
 * @Description 电能适配器
 * @Date 14:29 2019-7-16
 * @Param
 * @return
 **/
class ElectricAdapter implements Motor
{
    private ElectricMotor emotor;
    public ElectricAdapter()
    {
        emotor=new ElectricMotor();
    }
    @Override
    public void drive()
    {
        emotor.electricDrive();
    }
}
/**
 * @Author Johann
 * @Description 光能适配器
 * @Date 14:29 2019-7-16
 * @Param
 * @return
 **/
class OpticalAdapter implements Motor
{
    private OpticalMotor omotor;
    public OpticalAdapter()
    {
        omotor=new OpticalMotor();
    }
    @Override
    public void drive()
    {
        omotor.opticalDrive();
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
            doc=builder.parse(new File("src/readXmlConfig.xml"));
            //获取包含类名的文本节点
            NodeList nl=doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName="johann.designPattern.structuralDesignPatterns.adapter_7."+classNode.getNodeValue();
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