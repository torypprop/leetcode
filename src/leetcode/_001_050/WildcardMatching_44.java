package leetcode._001_050;

public class WildcardMatching_44 {

////////////////////////////
//	递归很慢
	
//    public boolean isMatch(String s, String p) {
//    	char[] ps = p.toCharArray();
//    	char[] pps = new char[ps.length];
//    	int ppsLen = 0;
//    	boolean isStar = false;
//    	for(int i = 0; i < ps.length; i++) {
//    		if(ps[i] == '*') {
//    			if(!isStar) {
//    				pps[ppsLen++] = '*';
//    				isStar = true;
//    			}
//    		} else {
//    			pps[ppsLen++] = ps[i];
//    			isStar = false;
//    		}
//    	}
//    	return isMatchRecursive(s, new String(pps, 0, ppsLen), 0, 0);
//    }
//
//	private boolean isMatchRecursive(String s, String p, int i, int j) {
//		
//		if(j == p.length()) {
//			if(i == s.length()) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//		if(p.charAt(j) == '*') {
//			for(int pos = i; pos <= s.length(); pos++) {
//				if(isMatchRecursive(s, p, pos, j+1)) {
//					return true;
//				}
//			}
//		}
//		if(i == s.length()) {
//			return false;
//		}else if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
//			return isMatchRecursive(s, p, i+1, j+1);
//		} else {
//			return false;
//		}
//	}
    
////////////////////////////////////////////
//   动态规划
////////////////////////////////////////////
	
	//////////////难得一比！！！！
	
	public boolean isMatch(String s, String p) {
		if(s.length() == 0 && p.length() == 0) return true;
		if(s.length() != 0 && p.length() == 0) return false;
		if(s.length() == 0 && p.length() != 0) {
			for(int i = 0; i < p.length(); i++) {
				if(p.charAt(i) != '*')
					return false;
			}
			return true;
		}
		boolean[][] pattern = new boolean[s.length()+1][p.length()+1];
		pattern[0][0] = true;
		if(p.charAt(0) == '*') {
			for(int i = 1; i <= s.length(); i++) {
				pattern[i][0] = true;
			}
		}
		for(int j = 0; j < p.length(); j++) {
			boolean isBreak = true;
			for(int i = 0; i < s.length(); i++) {
				if((p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') && pattern[i][j] == true) {
					pattern[i+1][j+1] = true;
					isBreak = false;
				} else if(p.charAt(j) == '*') {
					boolean found = false;
					for(int k = 0; k <= i+1; k++) {
						if(pattern[k][j] == true) {
							found = true;
							break;
						}
					}
					pattern[i+1][j+1] = found;
					pattern[0][j+1] = pattern[0][j];
					isBreak = !found;
				} else {
					pattern[i+1][j+1] = false;
				}
			}
			if(isBreak) {
				break;
			}
		}
//		for(int i = 0; i <= s.length(); i++) {
//			for(int j = 0; j <= p.length(); j++) {
//				System.out.print(pattern[i][j]+" ");
//			}
//			System.out.println();
//		}
		return pattern[s.length()][p.length()];
	}

	public static void main(String[] args) {
		WildcardMatching_44 demo = new WildcardMatching_44();
		String s = "c";
		String p = "*?*";
		System.out.println(demo.isMatch(s, p));
	}
}
