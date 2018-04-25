package learnclass;

/**
 * Created by samo on 2018/4/22.
 *
 * @author samo
 * @date 2018/04/22
 */
public class AbstractHouseImp extends AbstractHouse {
    public static void main(String[] args) {
        AbstractHouse abstractHouseImp = new AbstractHouseImp();
        abstractHouseImp.price();
        int i = 1;
        System.out.println(abstractHouseImp.returnVal(i));
    }
}
