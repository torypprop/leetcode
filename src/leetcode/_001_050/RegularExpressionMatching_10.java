package leetcode._001_050;

public class RegularExpressionMatching_10 {
	
	public boolean isCharMatch(String s, int pos1, String p, int pos2) {
		if (s.length() == pos1 || p.length() == pos2)
			return false;
		if (p.charAt(pos2) == '.')
			return true;
		else 
			return s.charAt(pos1) == p.charAt(pos2);
	}

    public boolean isMatch(String s, int pos1, String p, int pos2) {
    	//递归结束条件
    	if (p.length() == pos2) {
    		if (s.length() == pos1) {
    			return true;
    		} else
    			return false;
    	}
    	//普通匹配
    	if (pos2 == p.length()-1 || p.charAt(pos2 + 1) != '*') {
    		if (!isCharMatch(s, pos1, p, pos2)) {
    			return false;
    		}
    		return isMatch(s, pos1 + 1, p, pos2 + 1);
    	}
    	//匹配*
    	if (isMatch(s, pos1, p, pos2 + 2))
    		return true;
    	while (isCharMatch(s, pos1, p, pos2)) {
    		if (isMatch(s, pos1 + 1, p, pos2 + 2)) 
    			return true;
    		pos1++;
    	}
    	return false;
    }
	
    public boolean isMatch(String s, String p) {
    	return isMatch(s,0,p,0);
    }
    
    //动态规划法, 出错
    public boolean isMatch2(String s, String p) {
    	boolean[][] a = new boolean[s.length()+1][p.length()+1];
    	a[0][0] = true;
    	int pos = 0;
    	int flag = 0;
    	for (int i = 0; i < p.length(); i++) {
    		if (i < p.length()-1 && p.charAt(i+1) == '*') {
    			a[pos][i+1] = a[pos][i-flag];
    			for (int j = pos; j < s.length(); j++) {
    				if (isCharMatch(s, j, p, i)) {
    					a[j+1][i+1] = a[pos][i-flag];
    				}
    			}
    			i++;	//过滤*
    			flag = 1;
    		} else {
    			for (int pos2 = pos; pos2 < s.length(); pos2 ++) {
					if (isCharMatch(s, pos2, p, i)) {
						a[pos2+1][i+1] = a[pos2][i-flag];
					}
    			}
				flag = 0;
				pos++;
    		}
    	}
    	
    	for (boolean[] aa: a) {
    		for (boolean aaa: aa) {
    			System.out.print("\t" + aaa );
    		}
    		System.out.println("");
    	}
    	
    	return a[s.length()][p.length()-flag];
    }
    

	public static void main(String[] args) {
		RegularExpressionMatching_10 a = new RegularExpressionMatching_10();
//		System.out.println(a.isMatch2("aa","a"));
//		System.out.println(a.isMatch2("aa","aa"));
//		System.out.println(a.isMatch2("aaa","aa"));
//		System.out.println(a.isMatch2("aa", "a*"));
//		System.out.println(a.isMatch2("aa", ".*"));
//		System.out.println(a.isMatch2("ab", ".*"));
//		System.out.println(a.isMatch2("aab", "c*a*b"));
		System.out.println(a.isMatch2("a", ".*..a*"));
	}

}
