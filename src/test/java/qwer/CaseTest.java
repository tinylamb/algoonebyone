package qwer;

import java.util.ArrayList;
import java.util.List;

public class CaseTest {

	public static void main(String[] args) {
		System.out.println("hello");
//		testBinarySearch();
		testBS2();
	}
	
	public static void testBinarySearch() {
		int v = 9;
		int[] arr = {1, 4, 6, 9, 11, 102, 111, 222, 333};
		System.out.println( Test.binarySearch(v, arr));
	}
	
	public static void testBS() {
		Double t1 = -1d;
		Double t2 = 2d;
		Double t3 = 5d;
		Double t4 = 6d;
		Double t5 = 9d;
		Double t6 = 100d;
		Double t7 = 151d;
		List<Double> interval = new ArrayList<Double>();
		interval.add(2d);
		interval.add(6d);
		interval.add(100d);
		System.out.println(t1 + " : " + Test.binarySearch(t1, interval));
		System.out.println(t2 + " : " + Test.binarySearch(t2, interval));
		System.out.println(t3 + " : " + Test.binarySearch(t3, interval));
		System.out.println(t4 + " : " + Test.binarySearch(t4, interval));
		System.out.println(t5 + " : " + Test.binarySearch(t5, interval));
		System.out.println(t6 + " : " + Test.binarySearch(t6, interval));
		System.out.println(t7 + " : " + Test.binarySearch(t7, interval));
	}
	
	public static void testBS2() {
		List<Double> interval = new ArrayList<Double>();
		interval.add(-1d);
		interval.add(3d);
		Double t1 = -5d;
		Double t2 = -1d;
		Double t3 = 2d;
		Double t4 = 3d;
		Double t5 = 8d;
		
		System.out.println(t1 + " : " + Test.binarySearch(t1, interval));
		System.out.println(t2 + " : " + Test.binarySearch(t2, interval));
		System.out.println(t3 + " : " + Test.binarySearch(t3, interval));
		System.out.println(t4 + " : " + Test.binarySearch(t4, interval));
		System.out.println(t5 + " : " + Test.binarySearch(t5, interval));

		
	}
}
