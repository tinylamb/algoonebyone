package designpattern;

/**
 * Created by samo on 2018/4/18.
 *
 * @author samo
 * @date 2018/04/18
 */
public class SingletonV {
    //https://javadoop.com/post/design-pattern#%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F
    private SingletonV() { }

    // 主要是使用了 嵌套类可以访问外部类的静态属性和静态方法 的特性
    private static class Holder {
        private static SingletonV instance = new SingletonV();
    }

    public static SingletonV getInstance() {
        return Holder.instance;
    }
}
