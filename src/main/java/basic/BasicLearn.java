package basic;

/**
 * Created by samo on 2017/4/3.
 *
 * @author samo
 * @date 2017/04/03
 */
public class BasicLearn {
    public static class Circle {
        private double r;

        public Circle(double r) {
            this.r = r;
        }

        public double getR() {
            return r;
        }

        public void setR(double r) {
            this.r = r;
        }

        public double getArea() {
            return Math.PI * r * r;
        }
    }
}
