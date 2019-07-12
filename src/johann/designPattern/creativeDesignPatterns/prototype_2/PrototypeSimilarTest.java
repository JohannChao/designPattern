package johann.designPattern.creativeDesignPatterns.prototype_2;

/**
 * @ClassName PrototypeSimilarTest
 * @Description 用原型模式生成相似的对象
 * @Author Johann
 * @Date 2019-7-10 17:35
 **/
public class PrototypeSimilarTest
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Citation obj1=new Citation("张三","同学：在2016学年第一学期中表现优秀，被评为三好学生。","韶关学院");
        obj1.display();
        Citation obj2=(Citation) obj1.clone();
        obj2.setName("李四");
        obj2.display();
    }
}
/**
 * @Author Johann
 * @Description 奖状类
 * @Date 17:21 2019-7-11
 * @Param 
 * @return 
 **/
class Citation implements Cloneable
{
    String name;
    String info;
    String college;
    Citation(String name,String info,String college)
    {
        this.name=name;
        this.info=info;
        this.college=college;
        System.out.println("奖状创建成功！");
    }
    void setName(String name)
    {
        this.name=name;
    }
    String getName()
    {
        return(this.name);
    }
    void display()
    {
        System.out.println(name+info+college);
    }
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        System.out.println("奖状拷贝成功！");
        return (Citation)super.clone();
    }
}
