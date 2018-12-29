package leetcode._051_100;

public class SpiralMatrixII_59 {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        generateMatrixRecursive(result, 0, n-1, 0, n-1, 1);
        return result;
    }
    
    private void generateMatrixRecursive(int[][] result, int xfrom, int xto, int yfrom, int yto, int fromData) {
    	if(xfrom > xto) {
    		return;
    	}
    	if(xfrom == xto) {
    		result[xfrom][yfrom] = fromData;
    		return;
    	}
    	if(xfrom + 1 == xto) {
    		result[xfrom][yfrom] = fromData;
    		result[xfrom][yfrom+1] = fromData+1;
    		result[xfrom+1][yfrom+1] = fromData+2;
    		result[xfrom+1][yfrom] = fromData+3;
    		return;
    	}
    	for(int i = yfrom; i <= yto; i++) {
    		result[xfrom][i] = fromData++;
    	}
    	for(int i = xfrom+1; i < xto; i++) {
    		result[i][yto] = fromData++;
    	}
    	for(int i = yto; i >= yfrom; i--) {
    		result[xto][i] = fromData++;
    	}
    	for(int i = xto-1; i > xfrom; i--) {
    		result[i][yfrom] = fromData++;
    	}
    	generateMatrixRecursive(result, xfrom+1, xto-1, yfrom+1, yto-1, fromData);
    }
    
    
    public static void main(String[] args) {

    	SpiralMatrixII_59 demo = new SpiralMatrixII_59();
    	int[][] datas = demo.generateMatrix(6);
    	for(int[] line: datas) {
    		for(int data: line) {
    			System.out.printf("%4d ", data);
    		}
    		System.out.println();
    	}
	}
}
