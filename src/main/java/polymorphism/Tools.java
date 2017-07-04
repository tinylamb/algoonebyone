package polymorphism;

/**
 * Created by samo on 2017/6/20.
 *
 * @author samo
 * @date 2017/06/20
 */
public class Tools {

    private Tools() {
        System.out.println("private tools");
    }

    public int x = 10;

    //private static Tools instance = null;
    private static Tools instance = new Tools();

    public static Tools getInstance() {
        //if (instance == null) {
        //    //return new Tools();
        //    instance = new Tools();
        //}
        return instance;
    }

    //Exception in thread "main" java.lang.StackOverflowError
    //at polymorphism.Tools.<init>
    //refer: https://stackoverflow.com/questions/42994581/exception-in-thread-main-java-lang-stackoverflowerror-why
    //private Tools instance2 = new Tools();

}
