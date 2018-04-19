package polymorphism;

/**
 * Created by samo on 2018/4/16.
 *
 * @author samo
 * @date 2018/04/16
 */
public interface Operator {
    //public void oper();

    default public void oper() {
        System.out.println("oper");
    }

}
