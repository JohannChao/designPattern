package johann.designPattern.structuralDesignPatterns.adapter_7;

/**
 * @ClassName ClassAdapterTest
 * @Description 类适配器模式
 * @Author Johann
 * @Date 2019-7-16 13:59
 **/
public class ClassAdapterTest {

    public static void main(String[] args){
        TargetClass targetClass = new ClassAdapter();
        targetClass.request();
    }
}

/**
 * @Author Johann
 * @Description 目标接口
 * @Date 14:00 2019-7-16
 * @Param
 * @return
 **/
interface TargetClass
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
class AdapteeClass
{
    public void adapteeRequest()
    {
        System.out.println("现存组件库已实现的功能......");
    }
}

/**
 * @Author Johann
 * @Description 类适配器模式：适配器类
 * @Date 14:08 2019-7-16
 * @Param
 * @return
 **/
class ClassAdapter extends AdapteeClass implements TargetClass
{
    @Override
    public void request()
    {
        System.out.println("类适配器模式：适配器类尝试连接......");
        adapteeRequest();
    }
}



