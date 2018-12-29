package leetcode._001_050;

//import java.util.ArrayList;
//import java.util.Arrays;

public class MedianOfTwoSortedArrays_4 {
//	double findKth(int a[], int m, int b[], int n, int k)  
//	{  
//	    //always assume that m is equal or smaller than n  
//	    if (m > n)  
//	        return findKth(b, n, a, m, k);  
//	    if (m == 0)  
//	        return b[k - 1];  
//	    if (k == 1)  
//	        return min(a[0], b[0]);  
//	    //divide k into two parts  
//	    int pa = min(k / 2, m), pb = k - pa;  
//	    if (a[pa - 1] < b[pb - 1])  
//	        return findKth(a + pa, m - pa, b, n, k - pa);  
//	    else if (a[pa - 1] > b[pb - 1])  
//	        return findKth(a, m, b + pb, n - pb, k - pb);  
//	    else  
//	        return a[pa - 1];  
//	}  
	
	double findKth(int a[], int posA, int b[], int posB, int k)  {
		if (a.length - posA > b.length - posB)
			return findKth(b, posB, a, posA, k);
		if (posA >= a.length)
			return b[posB + k -1];
		if ( k == 1)
			return Math.min(a[posA], b[posB]);
		int pa = Math.min(k / 2, a.length - posA), pb = k - pa;
		if (a[posA + pa -1] < b[posB + pb -1])
			return findKth(a, posA + pa, b, posB, k - pa);
		else if (a[posA + pa -1] > b[posB + pb -1])
			return findKth(a, posA, b, posB + pb, k - pb);
		else 
			return a[posA + pa - 1];
	}
	
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int total = nums1.length + nums2.length;  
      if (total % 2 == 1)  
          return findKth(nums1, 0, nums2, 0, total / 2 + 1);  
      else  
          return (findKth(nums1, 0, nums2, 0, total / 2)  
                  + findKth(nums1, 0, nums2, 0, total / 2 + 1)) / 2;  
	}
	
	
}
