package learnclass;

/**
 * Created by samo on 2018/4/18.
 *
 * @author samo
 * @date 2018/04/18
 */
public class OuterClass {
    private String name ;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    class InnerClass{
        public InnerClass(){
            name = "chenssy";
            age = 23;
        }
    }

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
    }
}
