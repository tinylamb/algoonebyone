package basic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by samo on 2017/10/20.
 *
 * @author samo
 * @date 2017/10/20
 */
public class DictTest {
    public static DictTest aDict = new DictTest();

    private Set<String> dict;

    public DictTest() {
        dict = new HashSet<String>();
        dict.add("1");
        dict.add("2");
    }

    public Set<String> getDict() {
        return dict;
    }

    public void setDict(Set<String> dict) {
        this.dict = dict;
    }

    public void updateDict(Set<String> update) {
        dict = update;
    }

    public static void main(String[] args) {
        Set<String> tmp = DictTest.aDict.getDict();
        if (tmp.contains("1")) {
            System.out.println("contains 1");
        }
        DictTest.aDict.updateDict(new HashSet<String>());
        if (tmp.contains("1")) {
            System.out.println("contains 1");
        }
        System.out.println(DictTest.aDict.getDict());
        System.out.println(tmp);

    }
}
