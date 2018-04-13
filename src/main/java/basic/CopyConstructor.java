package basic;

import java.util.ArrayList;
import java.util.List;

import com.rits.cloning.Cloner;

/**
 * Created by samo on 2018/4/12.
 *
 * @author samo
 * @date 2018/04/12
 */
public class CopyConstructor {
    private List<String> ls;

    public CopyConstructor() {
    }

    public CopyConstructor(List<String> ls) {
        this.ls = ls;
    }

    public CopyConstructor(CopyConstructor other) {
        this.ls = new ArrayList<>(other.getLs());
    }

    public List<String> getLs() {
        return ls;
    }

    public void setLs(List<String> ls) {
        this.ls = ls;
    }

    public static void main(String[] args) {
        Cloner cloner = new Cloner();
        List<String> ls = new ArrayList<>();
        ls.add("1");
        CopyConstructor c1 = new CopyConstructor(ls);
        CopyConstructor c2 = c1;
        CopyConstructor c3 = new CopyConstructor(c1);
        CopyConstructor c4 = cloner.deepClone(c1);
        c1.getLs().add("2");
        System.out.println(c2.getLs());
        System.out.println(c3.getLs());
        System.out.println(c4.getLs());
    }
}
