package polymorphism;

/**
 * Created by samo on 2017/6/12.
 *
 * @author samo
 * @date 2017/06/12
 */
public class Wine {

    public void func1() {
        System.out.println("Wine func1");
        func2();
    }

    public void func2() {
        System.out.println("Wine func2");
    }

    public static void main(String[] args) {
        Wine w = new Wine();
        w.func2();
    }
}
