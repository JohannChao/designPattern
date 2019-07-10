package johann.designPattern.creativeDesignPatterns.singleton_1;

/**
 * @ClassName LazySingleton
 * @Description 懒汉式单例模式
 * @Author Johann
 * @Date 2019-7-10 15:24
 **/
public class LazySingleton {

    /**
     * 懒汉模式，类加载的时候，不创建实例，只有首次调用 getInstance() 方法的时候，才会首次创建实例对象。
     * 如果是在多线程中，应该保留 "volatile" 和 "synchronized"关键字，这将确保线程的安全性。这两个关键字的存在，使得每次访问都需要同步，影响了性能。
     **/
    //保证 instance 在所有线程中同步
    private static volatile LazySingleton instance = null;

    private LazySingleton(){};

    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

}
