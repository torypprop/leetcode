package leetcode._001_050;

public class IntegerToRoman_12 {
    public String intToRoman(int num) {
        String[][] roman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
            };
            
            String ret = "";
            int digit = 0;
            while (num != 0) {
                int remain = num % 10;
                ret = roman[digit][remain] + ret;
                digit++;
                num /= 10;
            }
            
            return ret;
        
    }
}
