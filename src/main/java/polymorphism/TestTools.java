package polymorphism;

/**
 * Created by samo on 2017/6/20.
 *
 * @author samo
 * @date 2017/06/20
 */
public class TestTools {
    public static void main(String[] args) {
        Tools t1 = Tools.getInstance();
        Tools t2 = Tools.getInstance();
        t1.x = t1.x + 10;
        System.out.println("Value of t1.x = " + t1.x);
        System.out.println("Value of t2.x = " + t2.x);

        //Problem p = new Problem();
    }
}
