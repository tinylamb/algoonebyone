package nlp;

import java.util.Arrays;

/**
 * Created by samo on 2017/6/23.
 *
 * @author samo
 * @date 2017/06/23
 */
public class NGram implements Comparable<NGram> {

    //关注Arrays

    public final String[] words;

    public int freq;

    public NGram(String[] words) {
        this(words, 0);
    }

    public NGram(String[] words, int freq) {
        this.words = words;
        this.freq = freq;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("(")
            .append(Arrays.toString(words))
            .append(", ")
            .append(freq)
            .append(")");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(words);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NGram other = (NGram) obj;
        return Arrays.equals(words, other.words);
    }

    @Override
    public int compareTo(NGram o) {
        return 0;
    }
}
