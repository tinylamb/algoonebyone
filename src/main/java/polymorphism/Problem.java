package polymorphism;

/**
 * Created by samo on 2017/6/20.
 *
 * @author samo
 * @date 2017/06/20
 */
public class Problem {
    //Exception in thread "main" java.lang.StackOverflowError
    //at polymorphism.Tools.<init>
    Problem prob = new Problem();
    int[] x = new int[10];

    public Problem() {
        System.out.println("Problem constructor");
    }
}
