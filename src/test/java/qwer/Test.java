package qwer;

import java.util.ArrayList;
import java.util.List;

public class Test {
    
	public static void main(String[] args) {
		Double t = 101d;
		List<Double> interval = new ArrayList<Double>();
		interval.add(2d);
		interval.add(6d);
		interval.add(100d);
		System.out.println(binarySearch(t, interval));
	}
	
    public static int getGCD(int p, int q) {
		if(q == 0) {
			return p;
		} else {
			return getGCD(q, p % q);
		}
	}
    
    public static int binarySearch(Double fval, List<Double> interval) {
        if(interval.size() == 0) {
            return -1;
        }
        int left = 0;
        int right = interval.size() - 1;
        int mid = left + ((right - left) >> 1);
        int pos = 0;
        Double tmp;
        while(left != right) {
            mid = left + ((right - left) >> 1);
            tmp = interval.get(mid);
            if(fval == tmp) {
                return mid + 1;
            } else if (fval > tmp) {
                left = mid + 1;
            } else {
//                right = mid - 1;
            	right = mid;
            }

        }
        mid = right;
        if(fval > interval.get(mid)) {
            return mid + 2;
        } else {
            return mid + 1;
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
