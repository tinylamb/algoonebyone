package classify;

/**
 * Created by samo on 2017/7/21.
 * An interface to measure the classification performance.
 * @author samo
 * @date 2017/07/21
 */
public interface ClassificationMeasure {

    /**
     * Returns an index to measure the quality of classification.
     * @param truth
     * @param prediction
     * @return
     */
    public double measure(int[] truth, int[] prediction);

}
