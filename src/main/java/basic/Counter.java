package basic;

/**
 * Created by samo on 2017/3/19.
 *
 * @author samo
 * @date 2017/03/19
 */
public class Counter {
    /**
     * a counter used to count
     */
    private int cnt = 0;
    private String cntname;

    public Counter(String cntname) {
        this.cntname = cntname;
    }

    public int getCnt() {
        return cnt;
    }

    public String getCntname() {
        return cntname;
    }


    public void increCnt() {
        ++cnt;
    }

    @Override
    public String toString() {
        return "Counter{" +
            "cnt=" + cnt +
            ", cntname='" + cntname + '\'' +
            '}';
    }
}
