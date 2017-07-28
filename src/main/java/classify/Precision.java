package classify;

/**
 * Created by samo on 2017/7/22.
 *
 * @author samo
 * @date 2017/07/22
 */
public class Precision implements ClassificationMeasure {

    @Override
    public double measure(int[] truth, int[] prediction) {
        if (truth.length != prediction.length) {
            throw new IllegalArgumentException(String.format("truth %d != prediction %d", truth.length, prediction.length));
        }
        int tp = 0;
        int p = 0;
        for (int i = 0; i < truth.length; i++) {
            if (prediction[i] == 1) {
                ++p;
                if (truth[i] == 1) {
                    ++tp;
                }
            }
        }
        if (p == 0) {
            return -1;
        } else {
            return Math.round((double) tp / p * 100) / 100.0;
        }
    }

    public static double compute(int[] truth, int[] prediction) {
        Precision p = new Precision();
        return p.measure(truth, prediction);
    }

    public static void main(String[] args) {
        int[] truth = {1, 1, 1, 1, 1, 1, 0, 0};
        int[] prediction = {1, 1, 1, 0, 1, 1, 1, 1};
        System.out.println(Precision.compute(truth, prediction));
    }
}
