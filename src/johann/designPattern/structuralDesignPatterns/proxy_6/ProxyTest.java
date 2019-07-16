package johann.designPattern.structuralDesignPatterns.proxy_6;

/**
 * @ClassName ProxyTest
 * @Description 静态代理
 * @Author Johann
 * @Date 2019-7-15 16:03
 **/
public class ProxyTest {

    public static void main(String [] args){
        StarAgent starAgent = new StarAgent(new MovieStar());
        starAgent.endorsement();
        starAgent.makeAMovie();
    }

}

/**
 * @Author Johann
 * @Description 抽象对象
 * @Date 16:08 2019-7-15
 * @Param 
 * @return 
 **/
interface ProxySubject{

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
class MovieStar implements ProxySubject{

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
 * @Description 代理对象
 * @Date 16:22 2019-7-15
 * @Param
 * @return
 **/
class StarAgent implements ProxySubject{

    MovieStar movieStar;
    StarAgent(MovieStar movieStar){
        this.movieStar = movieStar;
    }
    @Override
    public void makeAMovie() {
        System.out.println("经纪人出面谈电影拍摄细节......");
        movieStar.makeAMovie();
    }

    @Override
    public void endorsement() {
        beforeEndorsement();
        System.out.println("经纪人出面谈代言......");
        movieStar.endorsement();
        afterEndorsement();
    }

    private  void beforeEndorsement(){
        System.out.println("确定代言什么产品，是否违规...... 预付款........");
    }

    private  void afterEndorsement(){
        System.out.println("结余款.......是否续约.......");
    }
}