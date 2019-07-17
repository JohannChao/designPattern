package johann.designPattern.structuralDesignPatterns.bridge_8;

/**
 * @ClassName AutomotiveTest
 * @Description 桥接模式---汽车
 * @Author Johann
 * @Date 2019-7-17 18:07
 **/
public class AutomotiveTest {

    public static void main(String[] args)
    {
        Automotive auto1 = new Pickup();
        Automotive auto2 = new Car();
        Color color1 = new White();
        Color color2 = new Black();
        Engine engine1 = new DieselEngine();
        Engine engine2 = new PetrolEngine();
        auto1.setColor(color1);
        auto1.setEngine(engine1);
        System.out.println(auto1.getDetails());

        auto1.setColor(color1);
        auto1.setEngine(engine2);
        System.out.println(auto1.getDetails());

        auto1.setColor(color2);
        auto1.setEngine(engine1);
        System.out.println(auto1.getDetails());

        auto1.setColor(color2);
        auto1.setEngine(engine2);
        System.out.println(auto1.getDetails());

        auto2.setColor(color1);
        auto2.setEngine(engine1);
        System.out.println(auto2.getDetails());

        auto2.setColor(color1);
        auto2.setEngine(engine2);
        System.out.println(auto2.getDetails());

        auto2.setColor(color2);
        auto2.setEngine(engine1);
        System.out.println(auto2.getDetails());

        auto2.setColor(color2);
        auto2.setEngine(engine2);
        System.out.println(auto2.getDetails());
    }
}

/**
 * @Author Johann
 * @Description 实现化角色---- 发动机
 * @Date 18:09 2019-7-17
 * @Param
 * @return
 **/
interface Engine
{
    String getEngine();
}

/**
 * @Author Johann
 * @Description 具体实现化角色---汽油发动机
 * @Date 18:10 2019-7-17
 * @Param
 * @return
 **/
class PetrolEngine implements Engine
{
    @Override
    public String getEngine()
    {
        return "汽油发动机";
    }
}

/**
 * @Author Johann
 * @Description 具体实现化角色---柴油发动机
 * @Date 18:11 2019-7-17
 * @Param
 * @return
 **/
class DieselEngine implements Engine
{
    @Override
    public String getEngine()
    {
        return "柴油发动机";
    }
}

/**
 * @Author Johann
 * @Description 实现化角色---颜色
 * @Date 18:12 2019-7-17
 * @Param
 * @return
 **/
interface Color
{
    String getColor();
}
/**
 * @Author Johann
 * @Description 具体实现化角色---白色
 * @Date 18:12 2019-7-17
 * @Param
 * @return
 **/
class White implements Color
{
    @Override
    public String getColor()
    {
        return "雪域白";
    }
}
/**
 * @Author Johann
 * @Description 具体实现化角色---黑色
 * @Date 18:12 2019-7-17
 * @Param
 * @return
 **/
class Black implements Color
{
    @Override
    public String getColor()
    {
        return "尊贵黑";
    }
}

/**
 * @Author Johann
 * @Description  抽象化角色---汽车
 * @Date 18:15 2019-7-17
 * @Param 
 * @return 
 **/
abstract class Automotive
{
    protected Engine engine;
    public void setEngine(Engine engine)
    {
        this.engine=engine;
    }

    protected Color color;
    public void setColor(Color color)
    {
        this.color=color;
    }

    public abstract String getDetails();
}

/**
 * @Author Johann
 * @Description 扩展抽象化角色---小轿车
 * @Date 18:19 2019-7-17
 * @Param 
 * @return 
 **/
class Car extends Automotive
{
    @Override
    public String getDetails() {
        String details = "汽车种类：小轿车\r\n颜色："+color.getColor()+"\r\n发动机种类："+engine.getEngine()+"\n";
        return details;
    }
}

/**
 * @Author Johann
 * @Description 扩展抽象化角色---皮卡
 * @Date 18:19 2019-7-17
 * @Param
 * @return
 **/
class Pickup extends Automotive
{
    @Override
    public String getDetails() {
        String details = "汽车种类：皮卡\r\n颜色："+color.getColor()+"\r\n发动机种类："+engine.getEngine()+"\n";
        return details;
    }
}