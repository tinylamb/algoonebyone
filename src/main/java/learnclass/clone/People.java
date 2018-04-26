package learnclass.clone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

/**
 * Created by samo on 2018/4/25.
 *
 * @author samo
 * @date 2018/04/25
 */
@Data
public class People implements Cloneable {

    public People() {
    }

    private String name;
    private List<String> skills;

    public static void main(String[] args) {
        People p1 = new People();
        p1.setName("p1");
        List<String> skills = new ArrayList<>(Arrays.asList("eat", "drink", "play"));
        p1.setSkills(skills);
        People p2 = null;
        try {
            p2 = (People)p1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(p2.toString());
        skills.add("happy");
        System.out.println(p2.toString());
    }
}
