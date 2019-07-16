package johann.designPattern.structuralDesignPatterns.adapter_7;

/**
 * @ClassName TwoWayAdapterTest
 * @Description 双向适配器模式。双向适配器类既可以把适配者接口转换成目标接口，也可以把目标接口转换成适配者接口
 * @Author Johann
 * @Date 2019-7-16 18:10
 **/
public class TwoWayAdapterTest {

    public static void main(String[] args)
    {
        System.out.println("目标通过双向适配器访问适配者：");
        TwoWayAdaptee adaptee=new AdapteeRealize();
        TwoWayTarget target=new TwoWayAdapter(adaptee);
        target.request();
        System.out.println("-------------------");
        System.out.println("适配者通过双向适配器访问目标：");
        target=new TargetRealize();
        adaptee=new TwoWayAdapter(target);
        adaptee.specificRequest();
    }
}

/**
 * @Author Johann
 * @Description 目标接口
 * @Date 18:11 2019-7-16
 * @Param
 * @return
 **/
interface TwoWayTarget
{
    public void request();
}
/**
 * @Author Johann
 * @Description 适配者接口
 * @Date 18:12 2019-7-16
 * @Param
 * @return
 **/
interface TwoWayAdaptee
{
    public void specificRequest();
}
/**
 * @Author Johann
 * @Description 目标实现
 * @Date 18:12 2019-7-16
 * @Param
 * @return
 **/
class TargetRealize implements TwoWayTarget
{
    @Override
    public void request()
    {
        System.out.println("目标代码被调用！");
    }
}
/**
 * @Author Johann
 * @Description 适配者实现
 * @Date 18:12 2019-7-16
 * @Param
 * @return
 **/
class AdapteeRealize implements TwoWayAdaptee
{
    @Override
    public void specificRequest()
    {
        System.out.println("适配者代码被调用！");
    }
}
/**
 * @Author Johann
 * @Description 双向适配器
 * @Date 18:12 2019-7-16
 * @Param
 * @return
 **/
class TwoWayAdapter  implements TwoWayTarget,TwoWayAdaptee
{
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;
    public TwoWayAdapter(TwoWayTarget target)
    {
        this.target=target;
    }
    public TwoWayAdapter(TwoWayAdaptee adaptee)
    {
        this.adaptee=adaptee;
    }
    @Override
    public void request()
    {
        adaptee.specificRequest();
    }
    @Override
    public void specificRequest()
    {
        target.request();
    }
}