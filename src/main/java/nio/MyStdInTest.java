package nio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        String path = "/Users/samo/Documents/github/algoonebyone/src/main/resources/";
        String filename = "userid.txt";
        String fileall = MyStdIn.readFileAll(new File(path + filename));
        System.out.println(fileall.length());
        System.out.println(fileall.substring(0,11));
        //System.out.println(fileall);
    }

    private static void testWriter() {
        String userid = "xxxxxxxxxx,";
        BufferedWriter output = null;
        String path = "/Users/samo/Documents/github/algoonebyone/src/main/resources/";
        try {
            File file = new File(path + "userid.txt");
            output = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < 700000; i++) {
                output.write(userid);
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        testreadFileAll();
    }
}
