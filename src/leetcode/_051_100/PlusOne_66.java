package leetcode._051_100;

public class PlusOne_66 {

    public int[] plusOne(int[] digits) {
    	int len = digits.length+1;
    	for(int data: digits) {
    		if(data != 9) {
    			len--;
    			break;
    		}
    	}
    	int[] result = new int[len];
    	int pos = len-1;
    	boolean isAdd = true;
    	for(int i = digits.length-1; i >= 0; i--) {
    		if(isAdd) {
    			if(digits[i] == 9) {
    				result[pos--] = 0;
    			} else {
    				result[pos--] = digits[i] + 1;
    				isAdd = false;
    			}
    		} else {
    			result[pos--] = digits[i];
    		}
    	}
    	if(isAdd) {
    		result[0] = 1;
    	}
    	return result;
    }
}
