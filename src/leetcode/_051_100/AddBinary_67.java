package leetcode._051_100;

public class AddBinary_67 {

    public String addBinary(String a, String b) {
        char[] csA = a.toCharArray();
        char[] csB = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int posA = csA.length-1;
        int posB = csB.length-1;
        int jinwei = 0;
        int sum;
        while(posA >= 0 && posB >= 0) {
        	sum = jinwei + csA[posA] - '0' + csB[posB] - '0';
        	if(sum >= 2) {
        		jinwei = 1;
        		sum -= 2;
        		sb.append(""+sum);
        	} else {
        		jinwei = 0;
        		sb.append(""+sum);
        	}
        	posA--;
        	posB--;
        }
        while(posA >= 0) {
        	sum = jinwei + csA[posA] - '0';
        	if(sum == 2) {
        		jinwei = 1;
        		sb.append("0");
        	} else {
        		jinwei = 0;
        		sb.append(""+sum);
        	}
        	posA--;
        }
        while(posB >= 0) {
        	sum = jinwei + csB[posB] - '0';
        	if(sum == 2) {
        		jinwei = 1;
        		sb.append("0");
        	} else {
        		jinwei = 0;
        		sb.append(""+sum);
        	}
        	posB--;
        }
        if(jinwei == 1) {
        	sb.append("1");
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
    	AddBinary_67 demo = new AddBinary_67();
    	System.out.println(demo.addBinary("11", "1"));
	}
}
