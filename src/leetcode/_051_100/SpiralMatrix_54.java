package leetcode._051_100;

import java.util.*;

public class SpiralMatrix_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> result = new ArrayList<>();
    	if(matrix.length > 0)
    		spiralOrderRecursive(matrix, result, 0, matrix.length-1, 0, matrix[0].length-1);
    	return result;
    }

	private void spiralOrderRecursive(int[][] matrix, ArrayList<Integer> result, int fromLine, int toLine, int fromCol, int toCol) {
		if(fromCol > toCol || fromLine > toLine) {
			return;
		}
		if(fromCol == toCol) {
			for(int i = fromLine; i <= toLine; i++) {
				result.add(matrix[i][fromCol]);
			}
			return;
		}
		if(fromLine == toLine) {
			for(int i = fromCol; i <= toCol; i++) {
				result.add(matrix[fromLine][i]);
			}
			return;
		}
		for(int i = fromCol; i <= toCol; i++) {
			result.add(matrix[fromLine][i]);
		}
		for(int i = fromLine+1; i < toLine; i++) {
			result.add(matrix[i][toCol]);
		}
		for(int i = toCol; i >= fromCol; i--) {
			result.add(matrix[toLine][i]);
		}
		for(int i = toLine-1; i > fromLine; i--) {
			result.add(matrix[i][fromCol]);
		}
		
		spiralOrderRecursive(matrix, result, fromLine+1, toLine-1, fromCol+1, toCol-1);
	}
}
