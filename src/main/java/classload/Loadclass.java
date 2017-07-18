package classload;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by samo on 2017/7/18.
 *
 * @author samo
 * @date 2017/07/18
 */
public class Loadclass {
    public static void main(String[] args) throws Exception{
        testreadclassLoader();
    }

    public static void testgetResource() {
        System.out.println(Loadclass.class.getResource(""));
        System.out.println(Loadclass.class.getResource("/"));
    }



    public static void testreadResource() throws Exception{
        //InputStream stream = Loadclass.class.getResourceAsStream("hanlp.properties");
        InputStream stream = Loadclass.class.getResourceAsStream("/hanlp.properties");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(streamReader);
        String s = "";
        while ( (s = br.readLine()) != null ) {
            System.out.println(s);
        }
    }

    public static void testclassLoader() {
        Loadclass t = new Loadclass();
        System.out.println(t.getClass());
        System.out.println(t.getClass().getClassLoader());
        System.out.println(t.getClass().getClassLoader().getResource(""));
        System.out.println(t.getClass().getClassLoader().getResource("/"));//null
    }

    public static void testreadclassLoader() throws Exception{
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader == null) {
            loader = Loadclass.class.getClassLoader();
        }
        InputStream in = loader.getResourceAsStream("hanlp.properties");
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        String s = "";
        do {
            s = br.readLine();
            System.out.println(s);
        } while (s != null);
    }

    public static void refer() {
        String r1 = "http://www.cnblogs.com/pixy/p/4798089.html";
    }
}
