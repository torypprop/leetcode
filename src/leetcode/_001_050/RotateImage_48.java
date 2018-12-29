package leetcode._001_050;

public class RotateImage_48 {
	
    public void rotate(int[][] matrix) {
        for(int i = 0; i < (matrix.length+1)/2; i++) {
            for(int j = 0; j < (matrix[0].length)/2; j++) {
            	int posI = i;
            	int posJ = j;
            	int NextPosI = posJ;
            	int NextPosJ = matrix[0].length - 1 - posI;
            	int data1 = matrix[posI][posJ];
            	int data2 = matrix[NextPosI][NextPosJ];
            	for(int k = 0; k < 4; k++) {
            		matrix[NextPosI][NextPosJ] = data1;
            		posI = NextPosI;
            		posJ = NextPosJ;
            		NextPosI = posJ;
            		NextPosJ = matrix[0].length - 1 - posI;
            		data1 = data2;
            		data2 = matrix[NextPosI][NextPosJ];
            	}
            }
        }
    }
    
    public static void main(String[] args) {
    	RotateImage_48 demo = new RotateImage_48();
    	int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    	demo.rotate(matrix);
    	for(int[] line: matrix) {
    		for(int data: line) {
    			System.out.print(data+" ");
    		}
        	System.out.println();
    	}
    }
}
