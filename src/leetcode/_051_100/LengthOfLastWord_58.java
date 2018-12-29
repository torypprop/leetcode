package leetcode._051_100;

public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
        if(s.length() == 0) {
        	return 0;
        }
        int pos = s.length()-1;
        int num = 0;
        while(pos >= 0 && s.charAt(pos) == ' ') {
        	pos--;
        }
        while(pos >= 0) {
        	if(s.charAt(pos) != ' ') {
        		num++;
        		pos--;
        	} else {
        		break;
        	}
        }
        return num;
    }
}
