package johann.designPattern.creativeDesignPatterns.prototype_2;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName PrototypeSameTest
 * @Description 用原型模式生成相同的对象
 * @Author Johann
 * @Date 2019-7-10 17:31
 **/
class SunWukong extends JPanel implements Cloneable
{
    private static final long serialVersionUID = 5543049531872119328L;
    public SunWukong()
    {
        System.out.println("新建原型成功");
        JLabel l1=new JLabel(new ImageIcon("src/resources/img/PrototypeSameTest.jpg"));
        this.add(l1);
    }
    @Override
    public Object clone()
    {
        SunWukong w=null;
        try
        {
            w=(SunWukong)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            System.out.println("拷贝悟空失败!");
        }
        if(w != null){
            System.out.println("拷贝原型成功");
        }
        return w;
    }
}
/**
 * @Author Johann
 * @Description //TODO
 * @Date 17:13 2019-7-11
 * @Param 
 * @return 
 **/
public class PrototypeSameTest
{
    public static void main(String[] args)
    {
        JFrame jf=new JFrame("原型模式测试");
        jf.setLayout(new GridLayout(1,2));
        Container contentPane=jf.getContentPane();
        SunWukong obj1=new SunWukong();
        contentPane.add(obj1);
        SunWukong obj2=(SunWukong)obj1.clone();
        contentPane.add(obj2);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
