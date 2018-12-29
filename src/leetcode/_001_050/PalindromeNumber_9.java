package leetcode._001_050;

public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
    	int xx = x;
    	int result = 0;
    	while (xx > 0) {
    		result = result * 10 + xx % 10;
    		xx /= 10;
    	}
        return result == x;
    }

	public static void main(String[] args) {
		PalindromeNumber_9 a =  new PalindromeNumber_9();
		System.out.println(a.isPalindrome(0));
		System.out.println(a.isPalindrome(4));
		System.out.println(a.isPalindrome(43));
		System.out.println(a.isPalindrome(44));
		System.out.println(a.isPalindrome(454));
		System.out.println(a.isPalindrome(455));
		System.out.println(a.isPalindrome(4554));
		System.out.println(a.isPalindrome(4556));
	}

}
