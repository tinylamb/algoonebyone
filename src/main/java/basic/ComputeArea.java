package basic;

import java.util.Scanner;

import com.google.common.collect.HashMultimap;

/**
 * Created by samo on 2017/4/2.
 *
 * @author samo
 * @date 2017/04/02
 */
public class ComputeArea {
    /**
     * S = PI * r * r
     * @param args
     */
    private Double r;

    public ComputeArea(Double r) {
        this.r = r;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Double getArea() {
        Double s = Math.PI * r * r * 100;
        return s.intValue() / 100.0;
    }

    public static void main(String[] args) {
        HashMultimap.create();
        String r = args[0];
        Scanner input = new Scanner(System.in);
        System.out.println("input r : ");
        Double r1 = input.nextDouble();
        ComputeArea circle = new ComputeArea(Double.valueOf(r1));
        System.out.println(circle.getArea());

    }
}
