package leetcode._001_050;

public class ReverseInteger_7 {
    public int reverse(int x) {
        int result = 0;
        int  flag = 1;
        if (x < 0) {
        	flag = -1;
        	x = -x;
        }
        while (x >= 10) {
        	result = result * 10 + x % 10;
        	x /= 10;
        }
        if ((double)(Integer.MAX_VALUE - x) / 10 < result ) {
        	return 0;
        } else {
        	result = result * 10 + x;
        }
        return result * flag;
    }

	public static void main(String[] args) {
		ReverseInteger_7 a = new ReverseInteger_7();
		System.out.println(a.reverse(3));
		System.out.println(a.reverse(-3));
		System.out.println(a.reverse(34));
		System.out.println(a.reverse(-367));
	}

}
