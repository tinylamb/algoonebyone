package Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by samo on 2017/4/19.
 *
 * @author samo
 * @date 2017/04/19
 */
public class BasicTimeService {
    public static Date transStringToDate(final String str, SimpleDateFormat sdf) {
        Date d = null;
        try {
            d = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }
}
