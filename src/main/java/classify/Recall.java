package classify;

/**
 * Created by samo on 2017/7/21.
 *
 * @author samo
 * @date 2017/07/21
 */
public class Recall implements ClassificationMeasure {
    @Override
    public double measure(int[] truth, int[] prediction) {
        if (truth.length != prediction.length) {
            throw new IllegalArgumentException(String.format("vector "
                + "size do not match. truth : %d != prediction : %d"
                , truth.length, prediction.length));
        }
        int tp = 0;
        int p = 0;
        for (int i = 0; i < truth.length; i++) {
            if (truth[i] == 1) {
                ++p;
                if (prediction[i] == 1) {
                    ++tp;
                }
            }
        }
        if (p == 0) {
            return -1;
        } else {
            double v = (double) tp / p;
            return Math.round(v * 100) / 100.0;
        }
    }

    public static double compute(int[] truth, int[] prediction) {
        Recall r = new Recall();
        return r.measure(truth, prediction);
    }

    public static void main(String[] args) {
        int[] truth = {1, 1, 1, 1, 1, 1, 0, 0};
        int[] prediction = {1, 1, 1, 0, 1, 1, 1, 1};
        System.out.println(Recall.compute(truth, prediction));
    }
}
