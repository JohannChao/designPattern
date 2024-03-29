package johann.designPattern.creativeDesignPatterns.singleton_1;

/**
 * @ClassName LazySingletonTest
 * @Description TODO
 * @Author Johann
 * @Date 2019-7-10 16:49
 **/
public class LazySingletonTest
{
    public static void main(String[] args)
    {
        President zt1=President.getInstance();
        zt1.getName();    //输出总统的名字
        President zt2=President.getInstance();
        zt2.getName();    //输出总统的名字
        if(zt1==zt2)
        {
            System.out.println("他们是同一人！");
        }
        else
        {
            System.out.println("他们不是同一人！");
        }
    }
}
class President
{
    /**
     * @Author Johann
     * @Description  保证instance在所有线程中同步
     * @Date 17:20 2019-7-11
     * @Param
     * @return 
     **/
    private static volatile President instance=null;
    /**
     * @Author Johann
     * @Description private避免类在外部被实例化
     * @Date 17:20 2019-7-11
     * @Param []
     * @return
     **/
    private President()
    {
        System.out.println("产生一个总统！");
    }
    public static synchronized President getInstance()
    {
        //在getInstance方法上加同步
        if(instance==null)
        {
            instance=new President();
        }
        else
        {
            System.out.println("已经有一个总统，不能产生新总统！");
        }
        return instance;
    }
    public void getName()
    {
        System.out.println("我是美国总统：特朗普。");
    }
}
