package qwer;

public class CaseTest {

	public static void main(String[] args) {
		System.out.println("hello");
		testBinarySearch();
	}
	
	public static void testBinarySearch() {
		int v = 9;
		int[] arr = {1, 4, 6, 9, 11, 102, 111, 222, 333};
		System.out.println( Test.binarySearch(v, arr));
	}
}
