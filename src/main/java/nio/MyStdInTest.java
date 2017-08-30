package nio;

import java.io.File;

/**
 * Created by samo on 2017/8/29.
 *
 * @author samo
 * @date 2017/08/29
 */
public class MyStdInTest {
    private static void testreadAll() {
        String all = MyStdIn.readAll();
        System.out.println(all);


    }

    private static void testreadFileAll() {
        String path = "/Users/samo/Documents/github/algoonebyone/src/main/resources/hanlp.properties";
        String fileall = MyStdIn.readFileAll(new File(path));
        System.out.println(fileall);
    }

    public static void main(String[] args) {
        testreadFileAll();
    }
}
