package qwer;

import basic.ComputeArea;

/**
 * Created by samo on 2017/3/21.
 *
 * @author samo
 * @date 2017/03/21
 */
public class HelloJava {
    public static void main(String[] args) {
        System.out.println("hello xiaohua");
        ComputeArea circle = new ComputeArea(Double.valueOf("3"));
        System.out.println(circle.getArea());
    }
}
