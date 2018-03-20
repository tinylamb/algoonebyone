package nlp.mysuggest.myscorer;

/**
 * Created by samo on 2018/3/18.
 *
 * @author samo
 * @date 2018/03/18
 */
public interface IMySentenceKey<T> {
    Double similarity(T other);
}
