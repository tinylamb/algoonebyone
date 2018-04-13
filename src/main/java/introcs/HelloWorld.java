package introcs;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by samo on 2018/4/13.
 *
 * @author samo
 * @date 2018/04/13
 */
public class HelloWorld {

    private String name;

    public HelloWorld() {
        System.out.println("HelloWorld Constructor");
    }

    public HelloWorld(String name) {
        this.name = name;
        System.out.println("hello " + name);
    }

    public static void main(String[] args) {
        String name = null;
        if (args.length > 0) {
            name = args[0];
        }
        if (!StringUtils.isEmpty(name)) {
            HelloWorld hwn = new HelloWorld(name);
        }
        HelloWorld hw = new HelloWorld();
        System.out.println("Hello, World");
        kdw();
        /**
         * javac HelloWorld.java   生成   HelloWorld.class
         * javap -c HelloWorld.class
         * cd ..;java introcs.HelloWorld
         */
    }

    public static void kdw() {
        System.out.println("**        ***    **********      **             *             **");
        System.out.println("**      ***      **        **     **           ***           ** ");
        System.out.println("**    ***        **         **     **         ** **         **  ");
        System.out.println("**  ***          **          **     **       **   **       **   ");
        System.out.println("*****            **          **      **     **     **     **    ");
        System.out.println("**  ***          **          **       **   **       **   **     ");
        System.out.println("**    ***        **         **         ** **         ** **      ");
        System.out.println("**      ***      **        **           ***           ***       ");
        System.out.println("**        ***    **********              *             *        ");
    }
}
