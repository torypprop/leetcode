package leetcode._001_050;

public class CountAndSay_38 {

    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++) {
        	s = func(s);
        }
        return s;
    }

	private String func(String s) {
		char[] cs = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int num = 1;
		for(int i = 1; i < cs.length; i++) {
			if(cs[i] == cs[i-1]) {
				num++;
			} else {
				sb.append(num).append(cs[i-1]);
				num = 1;
			}
		}
		sb.append(num).append(cs[cs.length-1]);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new CountAndSay_38().countAndSay(1));
		System.out.println(new CountAndSay_38().countAndSay(2));
		System.out.println(new CountAndSay_38().countAndSay(3));
		System.out.println(new CountAndSay_38().countAndSay(4));
		System.out.println(new CountAndSay_38().countAndSay(5));
		System.out.println(new CountAndSay_38().countAndSay(6));
	}
}
