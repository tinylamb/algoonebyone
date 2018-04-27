package effective.builderpattern;

import lombok.Data;

/**
 * Created by samo on 2018/4/27.
 *
 * @author samo
 * @date 2018/04/27
 */
@Data
public class NutritionFacts {
    //final should be initialized? of course!
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    private NutritionFacts(NutritionFactsBuilder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }


    public static class NutritionFactsBuilder implements Builder<NutritionFacts> {
        // Required parameters
        private int servingSize;
        private int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public NutritionFactsBuilder(int servingSize, int servings) {
            if (servingSize < 0) {
                throw new IllegalArgumentException();
            }
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public NutritionFactsBuilder calories(int val) {
            this.calories = val;
            if (val < 0) {
                throw new IllegalArgumentException();
            }
            return this;
        }

        public NutritionFactsBuilder fat(int val) {
            this.fat = val;
            return this;
        }

        public NutritionFactsBuilder carbohydrate(int val) {
            this.carbohydrate = val;
            return this;
        }

        public NutritionFactsBuilder sodium(int val) {
            this.sodium = val;
            return this;
        }

        @Override
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }
}
