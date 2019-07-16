package johann.designPattern.structuralDesignPatterns.proxy_6;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxyTest
 * @Description 动态代理
 * @Author Johann
 * @Date 2019-7-15 16:26
 **/
public class DynamicProxyTest {

    public static void main(String [] args){
        StarAgentProxy starAgentProxy = new StarAgentProxy();
        ProxySub proxySub = starAgentProxy.getProxy();

        proxySub.makeAMovie();
        proxySub.endorsement();

        //查看生成的代理类class
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", RealMovieStar.class.getInterfaces());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("Proxy0.class"));
            fos.write(classFile);
            fos.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * @Author Johann
 * @Description 抽象对象
 * @Date 16:08 2019-7-15
 * @Param
 * @return
 **/
interface ProxySub{

    void makeAMovie();

    void endorsement();
}

/**
 * @Author Johann
 * @Description 真实对象
 * @Date 16:22 2019-7-15
 * @Param
 * @return
 **/
class RealMovieStar implements ProxySub{

    @Override
    public void makeAMovie() {
        System.out.println("MovieStar make a movie.");
    }

    @Override
    public void endorsement() {
        System.out.println("MovieStar endorse a product.");
    }
}
/**
 * @Author Johann
 * @Description
 * 动态代理模式，代理类在程序运行时创建的代理被成为动态代理。
 * 静态代理的例子中，代理类是自己定义好的，在程序运行之前就已经编译完成。
 * 动态代理，代理类并不是在Java代码中定义的，而是在运行时根据我们在Java代码中的"指示"动态生成的。
 *相比于静态代理， 动态代理的优势在于可以很方便的对代理类的函数进行统一的处理，而不用修改每个代理类中的方法。
 *
 * java在JDK1.5之后提供了一个"java.lang.reflect.Proxy"类，通过"Proxy"类提供的一个newProxyInstance方法用来创建一个对象的代理对象
 * static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
 *          1）ClassLoader loader用来指明生成代理对象使用哪个类装载器
 *          2）Class<?>[] interfaces用来指明生成哪个对象的代理对象，通过接口指定
 *          3）InvocationHandler h用来指明产生的这个代理对象要做什么事情
 *
 * @Date 16:33 2019-7-15
 * @Param
 * @return
 **/
class StarAgentProxy {

    RealMovieStar movieStar = new RealMovieStar();

    ProxySub getProxy(){
        return (ProxySub) Proxy.newProxyInstance(RealMovieStar.class.getClassLoader(), RealMovieStar.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("makeAMovie")){
                            System.out.println("经纪人出面谈电影拍摄细节......");
                            return method.invoke(movieStar,args);
                        }else if (method.getName().equals("endorsement")){
                            beforeEndorsement();
                            System.out.println("经纪人出面谈代言......");
                            return method.invoke(movieStar,args);
                        }

                        return null;
                    }
                });
    }

    private  void beforeEndorsement(){
        System.out.println("确定代言什么产品，是否违规...... 预付款........");
    }

    private  void afterEndorsement(){
        System.out.println("结余款.......是否续约.......");
    }
}