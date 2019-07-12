package johann.designPattern.creativeDesignPatterns.builder_5;
import	java.util.Map;

/**
 * @ClassName BuilderTest
 * @Description 建造者模式
 * @Author Johann
 * @Date 2019-7-12 16:09
 **/
public class BuilderTest {
    public static  void main(String [] args){
        Builder builder=new ConcreteBuilder();
        Director director=new Director(builder);
        Product product=director.construct();
        product.show();
    }
}


    /**
     * @Author Johann
     * @Description 产品角色：包含多个组成部件的复杂对象
     * @Date 16:10 2019-7-12
     * @Param
     * @return
     **/
    class Product
    {
        private String partA;
        private String partB;
        private String partC;
        public void setPartA(String partA)
        {
            this.partA=partA;
        }
        public void setPartB(String partB)
        {
            this.partB=partB;
        }
        public void setPartC(String partC)
        {
            this.partC=partC;
        }
        public void show()
        {
            System.out.println("SHOW: "+partA+"--"+partB+"--"+partC);
        }
    }

    /**
     * @Author Johann
     * @Description  抽象建造者：包含创建产品各个子部件的抽象方法
     * @Date 16:11 2019-7-12
     * @Param 
     * @return 
     **/
    abstract class Builder
    {
        //创建产品对象
        protected Product product=new Product();
        public abstract void buildPartA();
        public abstract void buildPartB();
        public abstract void buildPartC();
        /**
         * @Author Johann
         * @Description 返回产品对象
         * @Date 16:20 2019-7-12
         * @Param []
         * @return johann.designPattern.creativeDesignPatterns.builder_5.Product
         **/
        public Product getResult()
        {
            return product;
        }
    }

    /**
     * @Author Johann
     * @Description  具体建造者：实现了抽象建造者接口
     * @Date 16:12 2019-7-12
     * @Param
     * @return
     **/
    class ConcreteBuilder extends Builder
    {
        @Override
        public void buildPartA()
        {
            product.setPartA("建造 PartA");
        }
        @Override
        public void buildPartB()
        {
            product.setPartB("建造 PartB");
        }
        @Override
        public void buildPartC()
        {
            product.setPartC("建造 PartC");
        }
    }

    /**
     * @Author Johann
     * @Description 指挥者：调用建造者中的方法完成复杂对象的创建
     * @Date 16:13 2019-7-12
     * @Param
     * @return
     **/
    class Director
    {
        private Builder builder;
        public Director(Builder builder)
        {
            this.builder=builder;
        }
        /**
         * @Author Johann
         * @Description 产品构建与组装方法
         * @Date 16:13 2019-7-12
         * @Param []
         * @return johann.designPattern.creativeDesignPatterns.builder_5.BuilderTest.Product
         **/
        public Product construct()
        {
            builder.buildPartA();
            builder.buildPartB();
            builder.buildPartC();
            return builder.getResult();
        }
    }
