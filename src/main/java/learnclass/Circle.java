package learnclass;

/**
 * Created by samo on 2017/4/13.
 *
 * @author samo
 * @date 2017/04/13
 */
public class Circle {
    private double r;

    public Circle() {
        r = 1.0;
    }

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
        double s = Math.PI * r * r;
        return Double.parseDouble(String.format("%.2f", s));
    }

    public double getPerimeter() {
        return 2 * Math.PI * r;
    }

    public static void main(String[] args) {
        Circle c = new Circle(3.0);
        System.out.println(c.getArea());
        System.out.println(c.getClass());
    }
}
