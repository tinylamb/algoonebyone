package qwer;

public class Test {
	
	public static void main(String[] args) {
		
	}
	
	public static int getGCD(int p, int q) {
		if(q == 0) {
			return p;
		} else {
			return getGCD(q, p % q);
		}
	}
	
	public static int binarySearch(int val, int[] arr) {
		if(arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		int mid = left + (right - left) / 2;
		int tmp = 0;
		int cnt = 0;
		while(left <= right) {
			++cnt;
//			mid = left + (right - left) / 2;
			mid = left + ( (right - left) >> 1 ); // 注意这里的运算符优先级, 明确
			System.out.println("left : " + left + " right : " + right + " mid : " + mid);
		    tmp = arr[mid];
		    if(tmp == val) {
		    	return mid;
		    } else if (tmp > val) {
		    	right = mid - 1;
		    } else {
		    	left = mid + 1;
		    }
		    if(cnt > 10) {
		    	break;
		    }
		}
		return -1;
	}
	
	
}
