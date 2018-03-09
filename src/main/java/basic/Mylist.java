package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samo on 2018/3/9.
 *
 * @author samo
 * @date 2018/03/09
 */
public class Mylist {

    private List<String> ls;

    public Mylist(List<String> ls) {
        List<String> t = new ArrayList<>(ls);
        this.ls = t;
    }

    public List<String> getLs() {
        return ls;
    }

    public void setLs(List<String> ls) {
        this.ls = ls;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("a");
        Mylist mylist = new Mylist(test);
        System.out.println(mylist.getLs());
        test.add("b");
        System.out.println(mylist.getLs());
    }
}
