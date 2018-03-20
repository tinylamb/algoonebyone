package nlp.mysuggest;

import java.util.List;

/**
 * Created by samo on 2018/3/18.
 *
 * @author samo
 * @date 2018/03/18
 */
public interface IMySuggester {

    void addSentence(String sentence);

    void removeAllSentences();

    List<String> suggest(String key, int size);
}
