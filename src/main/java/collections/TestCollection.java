package collections;

import java.util.ArrayList;

/**
 * Created by samo on 2017/11/29.
 *
 * @author samo
 * @date 2017/11/29
 */
public class TestCollection {
    public static void main(String[] args) {
        //集合初始化时，指定集合初始值大小
        ArrayList<String> c1 = new ArrayList<>(16);
        c1.add("tianjin"); // breakpoint force step into
        c1.add("wuhan");
        c1.add("shenzhen");
        c1.add("hangzhou");
        System.out.println("c1 length : " + c1.size());
        System.out.println("a list of cities : " + c1);
        System.out.println("is wuhan is c1? : " + c1.contains("wuhan"));
        c1.remove("shanghai"); // 感觉remove应用场景不多, remove适用链表
        System.out.println("c1 length : " + c1.size());


    }
}
