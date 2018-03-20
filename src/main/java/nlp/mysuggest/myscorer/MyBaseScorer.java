package nlp.mysuggest.myscorer;

import java.util.Map;

/**
 * Created by samo on 2018/3/18.
 *
 * @author samo
 * @date 2018/03/18
 */
public abstract class MyBaseScorer<T extends IMySentenceKey> implements IMyScorer {
    @Override
    public Map<String, Double> computeScore(String outerSentence) {
        return null;
    }

    @Override
    public void addSentence(String sentence) {

    }

    @Override
    public void removeAllSentences() {

    }
}
