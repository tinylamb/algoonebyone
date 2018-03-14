package generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by samo on 2017/9/7.
 *
 * @author samo
 * @date 2017/09/07
 */
public class LearnArrayList implements Comparable<Integer>{
    public static void check() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==10) {
                list.remove(integer);   //注意这个地方
            }
        }
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }

    public static void main(String[] args) {
        check();
    }
}
