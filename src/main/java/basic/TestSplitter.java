package basic;

import java.util.StringTokenizer;

import org.junit.Test;

/**
 * Created by samo on 2018/3/26.
 *
 * @author samo
 * @date 2018/03/26
 */
public class TestSplitter {

    private static final String line = "12 34";
    private static final int RUNS = 10000000;//000000;

    public final void testSplit() {
        long start = System.currentTimeMillis();
        for (int i=0;i<RUNS;i++){
            String[] st = line.split(" ");
            int x = Integer.parseInt(st[0]);
            int y = Integer.parseInt(st[1]);
        }
        System.out.println("Split: "+(System.currentTimeMillis() - start)+"ms");
    }

    public final void testFastSplit() {
        long start = System.currentTimeMillis();
        for (int i=0;i<RUNS;i++) {
            String[] arr = basic.Test.fastSplitv2(line, "#");
        }
        System.out.println("FastSplit: "+(System.currentTimeMillis() - start)+"ms");
    }

    public final void testIndexOf() {
        long start = System.currentTimeMillis();
        for (int i=0;i<RUNS;i++){
            int index = line.indexOf(' ');
            int x = Integer.parseInt(line.substring(0,index));
            int y = Integer.parseInt(line.substring(index+1));
        }
        System.out.println("IndexOf: "+(System.currentTimeMillis() - start)+"ms");
    }

    public final void testTokenizer() {
        long start = System.currentTimeMillis();
        for (int i=0;i<RUNS;i++){
            StringTokenizer st = new StringTokenizer(line, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
        }
        System.out.println("StringTokenizer: "+(System.currentTimeMillis() - start)+"ms");
    }

    @Test
    public final void testAll() {
        this.testSplit();
        this.testIndexOf();
        this.testTokenizer();
        this.testSplit();
        this.testIndexOf();
        this.testTokenizer();
        this.testFastSplit();
    }

}
