package introcs;

/**
 * Created by samo on 2018/4/13.
 *
 * @author samo
 * @date 2018/04/13
 */
public class HelloWorld {

    public HelloWorld() {
        System.out.println("HelloWorld Constructor");
    }

    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        System.out.println("Hello, World");
        /**
         * javac HelloWorld.java   生成   HelloWorld.class
         * javap -c HelloWorld.class
         * cd ..;java introcs.HelloWorld
         */
    }
}
