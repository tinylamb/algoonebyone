package nlp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.hankcs.hanlp.suggest.Suggester;
import com.hankcs.hanlp.suggest.scorer.BaseScorer;
import com.hankcs.hanlp.suggest.scorer.IScorer;
import com.hankcs.hanlp.suggest.scorer.editdistance.EditDistanceScorer;
import com.hankcs.hanlp.suggest.scorer.lexeme.IdVectorScorer;
import com.hankcs.hanlp.suggest.scorer.pinyin.PinyinScorer;

/**
 * Created by samo on 2017/6/8.
 *
 * @author samo
 * @date 2017/06/08
 */
public class SuggesterWithScore extends Suggester {

    List<BaseScorer> scorerList;

    public SuggesterWithScore()
    {
        scorerList = new ArrayList<BaseScorer>();
        scorerList.add(new IdVectorScorer());
        scorerList.add(new EditDistanceScorer());
        scorerList.add(new PinyinScorer());
    }

    @Override
    public void addSentence(String sentence) {
        for (IScorer scorer : scorerList)
        {
            scorer.addSentence(sentence);
        }
    }

    @Override
    public List<String> suggest(String key, int size) {
        return super.suggest(key, size);
    }

    private static TreeMap<Double ,Set<String>> sortScoreMap(TreeMap<String, Double> scoreMap)
    {
        TreeMap<Double, Set<String>> result = new TreeMap<Double, Set<String>>(Collections.reverseOrder());
        for (Map.Entry<String, Double> entry : scoreMap.entrySet())
        {
            Set<String> sentenceSet = result.get(entry.getValue());
            if (sentenceSet == null)
            {
                sentenceSet = new HashSet<String>();
                result.put(entry.getValue(), sentenceSet);
            }
            sentenceSet.add(entry.getKey());
        }
        System.out.println(result);

        return result;
    }

    private static Double max(Map<String, Double> map)
    {
        Double theMax = 0.0;
        for (Double v : map.values())
        {
            theMax = Math.max(theMax, v);
        }

        return theMax;
    }

    public List<String> suggest(String key, int size, Double min) {
        List<String> resultList = new ArrayList<String>(size);
        TreeMap<String, Double> scoreMap = new TreeMap<String, Double>();
        for (BaseScorer scorer : scorerList)
        {
            Map<String, Double> map = scorer.computeScore(key);
            //System.out.println(map);
            // 用于正规化一个map
            Double max = max(map);
            for (Map.Entry<String, Double> entry : map.entrySet())
            {
                Double score = scoreMap.get(entry.getKey());
                if (score == null) {
                    score = 0.0;
                }
                scoreMap.put(entry.getKey(), score / max + entry.getValue() * scorer.boost);
            }
            System.out.println(scoreMap);

            for (Map.Entry<Double, Set<String>> entry : sortScoreMap(scoreMap).entrySet())
            {
                if (entry.getKey() < min) {
                    continue;
                }
                for (String sentence : entry.getValue())
                {
                    if (resultList.size() >= size) {
                        return resultList;
                    }
                    resultList.add(sentence);
                }
            }
            System.out.println(resultList + " " + resultList.size());

            return resultList;
        }


        return null;
    }

    public static void main(String[] args) {
        SuggesterWithScore suggester = new SuggesterWithScore();
        List<String> sentence = new ArrayList<String>();
        sentence.add("维权瓦力服务量");
        sentence.add("万象咨询服务量");
        for (String s : sentence) {
            suggester.addSentence(s);
        }
        suggester.suggest("万象咨询服务量", sentence.size(), 1.0);
    }
}
