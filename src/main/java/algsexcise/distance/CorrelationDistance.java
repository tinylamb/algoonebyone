package algsexcise.distance;

/**
 * Created by samo on 2018/3/21.
 * Correlation distance is defined as 1 - correlation coefficient.
 * 相关系数距离应用到什么场景呢?
 * @author samo
 * @date 2018/03/21
 */
public class CorrelationDistance implements Distance<double[]>{

    @Override
    public double d(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException(
                String.format("Arrays have different length: x[%d], y[%d]", x.length, y.length));
        }
        return 0;
    }

    public <T> double d(T[] x, T[] y) {
        return 0.0;
    }



}
