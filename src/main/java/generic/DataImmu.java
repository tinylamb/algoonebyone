package generic;

import java.sql.Timestamp;

/**
 * Created by samo on 2017/6/29.
 *
 * @author samo
 * @date 2017/06/29
 */
public class DataImmu <E> {

    /**
     * immutable object
     */
    public final E x;

    /**
     * Class label or real-valued response. NaN means unknown label/response.
     */
    public double y = Double.NaN;

    /**
     * Optional weight of this datum. By default, it is 1.0. The particular
     * meaning of weight depends on applications and machine learning algorithms.
     * Although there are on explicit requirements on the weights, in general,
     * they should be positive.
     */
    public double weight = 1.0;

    /**
     * Name of datum.
     */
    public String name;
    /**
     * Optional detailed description.
     */
    public String description;

    /**
     * Timestamp of datum in case of transactional data.
     * Transactional data are time-stamped data collected over time at no
     * particular frequency. Some examples of transactional data are
     * <ul>
     * <li> Internet data </li>
     * <li> Point of Sales (POS) data </li>
     * <li> Inventory data </li>
     * <li> Call Center data </li>
     * <li> Trading data </li>
     * </ul>
     */
    public Timestamp timestamp;


    public DataImmu(E x) {
        this.x = x;
    }

    public DataImmu(E x, double y) {
        this.x = x;
        this.y = y;
    }

    public DataImmu(E x, double y, double weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}
