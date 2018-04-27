package effective.builderpattern;

/**
 * Created by samo on 2018/4/27.
 *
 * @author samo
 * @date 2018/04/27
 */
public class TestNutritionFacts {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts
            .NutritionFactsBuilder(240, 8)
            .calories(100).calories(10).carbohydrate(50).build();
    }
}
