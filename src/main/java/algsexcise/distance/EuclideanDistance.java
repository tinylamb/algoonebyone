package algsexcise.distance;

/**
 * Created by samo on 2018/3/21.
 *
 * @author samo
 * @date 2018/03/21
 */
public class EuclideanDistance implements Distance<double[]> {
    private double[] weight = null;

    public EuclideanDistance() {
    }

    public EuclideanDistance(double[] weight) {
        for (double tmp : weight) {
            if (tmp < 0 || Double.isNaN(tmp)) {
                throw new IllegalArgumentException(String.format("Weight has to be nonnegative: %f", tmp));
            }
        }
        this.weight = weight;
    }

    @Override
    public double d(double[] x, double[] y) {
        double dist = 0.0;
        int n = x.length;
        for (int i = 0; i < n; i++) {
            double w = (weight == null) ? 1 : weight[i];
            double d = x[i] - y[i];
            dist += w * d * d;
        }
        return Math.sqrt(dist);
    }
}
