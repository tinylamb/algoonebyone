package polymorphism;

/**
 * Created by samo on 2017/6/12.
 *
 * @author samo
 * @date 2017/06/12
 */
public class JncWine extends Wine {

    //重写
    @Override
    public void func2() {
        //super.func2();
        System.out.println("JncWine func2");
    }

    //重载
    public void func1(String s) {
        System.out.println("JncWine func1");
        func2();
    }

    public static void main(String[] args) {
        Wine w = new JncWine();
        w.func1();
        //w.func1("test"); 不可以


        System.out.println("############");

        w.func2();
    }
}
